package com.tea.modules.redis;

import com.tea.modules.data.redis.core.scan.RedisScanner;

import com.tea.modules.data.redis.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * com.tea.modules.redis
 *
 * @author xiejiemin
 * @since 2021/4/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisScannerTest {

    @Autowired
    private RedisScanner redisScanner;

    @Test
    public void test() {
        RedisUtils.set("k1", "1");
        RedisUtils.set("k2", "1");
        RedisUtils.set("k3", "1");
        RedisUtils.set("k4", "1");
        RedisUtils.set("k5", "1");
        RedisUtils.set("k6", "1");
        RedisUtils.set("k8", "1");
        RedisUtils.set("k9", "1");
        redisScanner.scan("k*", (bytes) -> log.info("scan result:{}", RedisUtils.deserialized(bytes)));
    }
}
