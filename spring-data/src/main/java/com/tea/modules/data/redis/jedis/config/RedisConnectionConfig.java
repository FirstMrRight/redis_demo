package com.tea.modules.data.redis.jedis.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaymin
 * 2020/12/20 18:40
 */
@Configuration
@Getter
public class RedisConnectionConfig {
    /**
     * Redis连接地址
     */
    @Value("${spring.redis.host}")
    private String host;
    /**
     * Redis连接密码
     */
    @Value("${spring.redis.password}")
    private String password;


}
