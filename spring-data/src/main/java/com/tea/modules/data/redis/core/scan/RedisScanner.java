package com.tea.modules.data.redis.core.scan;

import com.tea.modules.data.redis.util.RedisUtils;
import com.tea.modules.exception.RestfulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

/**
 * com.tea.modules.data.redis.core.scan <br>
 * <a href="https://aijishu.com/a/1060000000007477">在RedisTemplate中使用scan代替keys指令</a>
 * @author xiejiemin
 * @since 2021/4/8
 */
@Component
@Slf4j
public class RedisScanner {

    /**
     * scan 实现 <br>
     * TODO: Long.MAX_VALUE可以改为传参的方式
     * @param pattern  表达式
     * @param consumer 对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        RedisUtils.getStringRedisTemplate().execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor = connection.scan(
                    ScanOptions.scanOptions()
                            .count(Long.MAX_VALUE)
                            .match(pattern)
                            .build())
            ) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
                throw new RestfulException(e);
            }
        });
    }
}
