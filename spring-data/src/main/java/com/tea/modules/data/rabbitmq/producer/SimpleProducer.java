package com.tea.modules.data.rabbitmq.producer;

import com.tea.modules.model.po.Order;
import com.tea.modules.data.rabbitmq.config.SimpleMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2020/12/30 17:42
 */
@Component
public class SimpleProducer {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public SimpleProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 发生消息到RabbitMQ,使用SpringBoot默认的交换机<br>
     *
     * @param message
     */
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(SimpleMQConfig.SIMPLE_QUEUE_NAME, message);
    }

    /**
     * 消息体为对象。配置MessageConverter为Jackson2JsonMessageConverter即可
     * @param order
     */
    public void sendOrderMessage(Order order){
        rabbitTemplate.convertAndSend(SimpleMQConfig.HANDLER_OBJECT_QUEUE_NAME, order);
    }
}
