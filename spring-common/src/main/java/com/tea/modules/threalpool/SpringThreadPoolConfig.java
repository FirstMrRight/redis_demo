package com.tea.modules.threalpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jaymin
 * 2021/1/17 1:01
 */
@Configuration
@EnableAsync
public class SpringThreadPoolConfig {

    @Autowired
    private SpringThreadPoolPropertyConfig threadPoolConfig;

    @Bean("taskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor customizeThreadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        customizeThreadPoolTaskExecutor.setCorePoolSize(threadPoolConfig.getCorePoolSize());
        customizeThreadPoolTaskExecutor.setMaxPoolSize(threadPoolConfig.getMaxPoolSize());
        customizeThreadPoolTaskExecutor.setKeepAliveSeconds(threadPoolConfig.getKeepAliveSeconds());
        customizeThreadPoolTaskExecutor.setQueueCapacity(threadPoolConfig.getQueueCapacity());
        customizeThreadPoolTaskExecutor.setAwaitTerminationSeconds(threadPoolConfig.getAwaitTerminationSeconds());
        customizeThreadPoolTaskExecutor.setThreadNamePrefix(threadPoolConfig.getThreadNamePrefix());
        customizeThreadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(threadPoolConfig.getWaitForTasksToCompleteOnShutdown());
        customizeThreadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return customizeThreadPoolTaskExecutor;
    }
}
