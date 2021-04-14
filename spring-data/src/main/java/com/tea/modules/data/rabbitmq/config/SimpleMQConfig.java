package com.tea.modules.data.rabbitmq.config;


import lombok.Getter;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaymin<br>
 * 简单的MQ配置类<br>
 * 2020/12/30 17:41
 */
@Configuration
@Getter
public class SimpleMQConfig {
    /**
     * 队列名
     */
    public static final String SIMPLE_QUEUE_NAME = "com.xjm.mq.simple";
    /**
     * 处理对象的MQ队列
     */
    public static final String HANDLER_OBJECT_QUEUE_NAME = "com.xjm.mq.simple.object";

    @Bean
    public Queue simpleQueue() {
        return new Queue(SIMPLE_QUEUE_NAME);
    }

    @Bean
    public Queue handleObjectQueue() {
        return new Queue(HANDLER_OBJECT_QUEUE_NAME);
    }

}
