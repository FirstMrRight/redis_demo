package com.tea.modules.redis;

import com.tea.modules.data.redis.core.limit.support.SimpleRateLimiterLoader;
import com.tea.modules.data.redis.util.RedisUtils;
import com.tea.modules.java8.thread.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jaymin
 * 2020/12/20 21:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RateLimiterTest {
    @Autowired
    private SimpleRateLimiterLoader rateLimiter;

    private static volatile int runtimeCount = 0;

    private static volatile int allowedCount = 0;

    @Test
    public void testRateLimiter() throws InterruptedException {
        String key = "192.168.14.149";
        RedisUtils.del(key);
        while (runtimeCount < 25000) {
            ThreadPoolUtil.getThreadPool().execute(() -> {
                boolean allowed = rateLimiter.isAllowed(key, 60, 10000);
                if (allowed) {
                    log.info("This operation is allowed");
                    allowedCount++;
                    return;
                }
                log.info("fuck you! stop your foolish action");
            });
            runtimeCount++;
        }
        Thread.sleep(30000);
        log.info("allow:{}", allowedCount);
    }
}
