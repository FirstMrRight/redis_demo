package com.tea.modules.data.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaymin
 * 2021/1/2 14:26
 */
@Configuration
public class DirectMQConfig {
    /**
     * 消息的routing key与队列的binding key相同的队列
     */
    public static final String DIRECT_QUEUE_NAME = "com.xjm.mq.direct";
    /**
     * direct 交换机
     */
    public static final String DIRECT_EXCHANGE_NAME = "com.xjm.mq.direct.exchange";
    /**
     * routing key
     */
    public static final String DIRECT_ROUTING_KEY_NAME = "com.xjm.mq.direct.routing.key";

    /**
     * 交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    /**
     * 创建一条持久化的、非排他的、非自动删除的队列
     * @return
     */
    @Bean
    public Queue directQueue(){
        return new Queue(DIRECT_QUEUE_NAME);
    }

    /**
     * Binding,将该routing key的消息通过交换机转发到该队列
     * @return
     */
    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DIRECT_ROUTING_KEY_NAME);
    }

}
