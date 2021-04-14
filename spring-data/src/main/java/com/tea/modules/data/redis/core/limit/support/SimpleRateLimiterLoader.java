package com.tea.modules.data.redis.core.limit.support;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

/**
 * @author jaymin
 * 2020/12/20 20:28
 */
@Component
@Slf4j
public class SimpleRateLimiterLoader implements RateLimiter {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 本次请求是否在限流次数内
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
        // 1. 获取当前的时间戳
        long now = Instant.now().toEpochMilli();
        log.info("current timestamp :{}", now);
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        byte[] redisKey = stringSerializer.serialize(requestEvent);
        // 2. 建立管道
        List<Object> list = redisTemplate.executePipelined((RedisCallback) redisConnection -> {
            byte[] value = stringSerializer.serialize(String.valueOf(now));
            // 3. 将当前的操作先存储下来
            redisConnection.zAdd(redisKey, now, value);
            double maxScope = now - period * 1000;
            log.info("max scope:{}", maxScope);
            // 4. 移除时间窗之外的数据
            redisConnection.zRemRangeByScore(redisKey, 0, maxScope);
            // 5. 统计剩下的key
            redisConnection.zCard(redisKey);
            // 6. 将当前key设置过期时间,过期时间为时间窗
            redisConnection.expire(redisKey, period + 1);
            return null;
        });
        Long currentRequestCount = (Long) list.get(2);
        // 8. 比较时间窗内的操作数
        log.info("current request count:{},maxRequestCount:{}", currentRequestCount,maxRequestCount);
        return currentRequestCount <= maxRequestCount;
    }
}
