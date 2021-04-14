package com.tea.modules.threalpool;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaymin
 * 2021/1/17 1:05
 */
@Configuration
@Getter
public class SpringThreadPoolPropertyConfig {

    @Value("${thread.pool.core-size:20}")
    private Integer corePoolSize;

    @Value("${thread.pool.max-size:50}")
    private Integer maxPoolSize;

    @Value("${thread.pool.keep-alive-seconds:10}")
    private Integer keepAliveSeconds;

    @Value("${thread.pool.queue-capacity:1000}")
    private Integer queueCapacity;

    @Value("${thread.pool.await-termination-seconds:0}")
    private Integer awaitTerminationSeconds;

    @Value("${thread.pool.thread-name-prefix2:spring-tea}")
    private String threadNamePrefix;

    @Value("${thread.pool.wait-for-tasks-to-complete-on-shutdown:true}")
    private Boolean waitForTasksToCompleteOnShutdown;
}
