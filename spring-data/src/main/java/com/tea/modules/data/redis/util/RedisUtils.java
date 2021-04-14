package com.tea.modules.data.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author jaymin<br>
 * Redis连接工具类<br>
 * 2020/12/20 19:54
 */
@SuppressWarnings("unchecked")
@Component
@Slf4j
public class RedisUtils {
    private static RedisTemplate<String, Object> redisTemplate;
    private static StringRedisTemplate stringRedisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> objectRedisTemplate) {
        redisTemplate = objectRedisTemplate;
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate redisTemplate){
        stringRedisTemplate = redisTemplate;
    }

    public static StringRedisTemplate getStringRedisTemplate(){
        return stringRedisTemplate;
    }

    public static <T> T get(String key, Supplier<T> supplier) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public static void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    public static void setEx(String key, Object value, Long expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }

    public static Long incrby(String key, Long delta) {
        Long increment = redisTemplate.opsForValue().increment(key, delta);
        return increment;
    }

    public static boolean zAdd(String key, double scope, String value) {
        boolean isOk = redisTemplate.opsForZSet().add(key, value, scope);
        return isOk;
    }

    public static Long zremrangeByScore(String key, double min, double max) {
        Long count = redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
        return count;
    }

    public static boolean del(String key){
        return redisTemplate.delete(key);
    }

    public static Cursor<String> sScan(String key, ScanOptions scanOptions){
        return stringRedisTemplate.opsForSet().scan(key, scanOptions);
    }

    public static String deserialized(byte[] value){
        String result = stringRedisTemplate.getStringSerializer().deserialize(value);
        return result;
    }
}
