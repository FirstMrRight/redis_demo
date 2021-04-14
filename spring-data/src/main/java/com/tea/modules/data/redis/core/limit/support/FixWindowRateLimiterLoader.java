package com.tea.modules.data.redis.core.limit.support;

import com.tea.modules.util.LocalDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * com.xjm.spring.data.redis.core.limit.support
 *
 * @author xiejiemin
 * @create 2020/12/24
 */
@Slf4j
@Component
public class FixWindowRateLimiterLoader implements RateLimiter {

    public static final int HOUR_MAX_REQUEST_COUNT = 10000;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 本次请求是否在限流次数内，使用固定时间窗口进行限流
     *
     * @param requestEvent    请求事件，作为Redis存储的key值
     * @param period          时间窗，即需要在多少时间范围内限制该行为
     * @param maxRequestCount 最大请求次数
     * @return
     */
    @Override
    public boolean isAllowed(String requestEvent, int period, int maxRequestCount) {
        if (StringUtils.isBlank(requestEvent)) {
            throw new RuntimeException("Expect the input parameter to exist, the actual value is empty");
        }
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        Long startTimeOfCurrentMinute = LocalDateUtil.getStartTimeOfCurrentMinute();
        Long startTimeOfCurrentHour = LocalDateUtil.getStartTimeOfCurrentHour();
        byte[] minuteKey = stringSerializer.serialize(requestEvent + ":minute:" + startTimeOfCurrentMinute);
        byte[] hourKey = stringSerializer.serialize(requestEvent + ":hour:" + startTimeOfCurrentHour);
        List<Object> redisCallBackList = redisTemplate.executePipelined((RedisCallback) redisConnection -> {
            Expiration minuteKeyExpiredTime = Expiration.from(60, TimeUnit.SECONDS);
            Expiration hourKeyExpiredTime = Expiration.from(3600, TimeUnit.SECONDS);
            redisConnection.set(minuteKey, stringSerializer.serialize("0"), minuteKeyExpiredTime, RedisStringCommands.SetOption.SET_IF_ABSENT);
            redisConnection.set(hourKey, stringSerializer.serialize("0"), hourKeyExpiredTime, RedisStringCommands.SetOption.SET_IF_ABSENT);
            redisConnection.incr(minuteKey);
            redisConnection.incr(hourKey);
            return null;
        });
        Long minuteRequestCount = (Long) redisCallBackList.get(2);
        Long hourRequestCount = (Long) redisCallBackList.get(3);
        log.info("current minute request count :{}",minuteRequestCount);
        log.info("current hour request count :{}",hourRequestCount);
        if (minuteRequestCount > maxRequestCount) {
            log.info("forbid----------------");
            return false;
        }
        if (hourRequestCount > HOUR_MAX_REQUEST_COUNT) {
            return false;
        }
        log.info("OK-------------------------");
        return true;
    }
}
