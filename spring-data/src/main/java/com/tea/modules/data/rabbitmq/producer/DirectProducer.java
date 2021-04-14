package com.tea.modules.data.rabbitmq.producer;

import com.tea.modules.data.rabbitmq.config.DirectMQConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author jaymin
 * 2021/1/2 14:43
 */
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DirectProducer {

    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(DirectMQConfig.DIRECT_EXCHANGE_NAME, DirectMQConfig.DIRECT_ROUTING_KEY_NAME, message);
    }

    /**
     * 发送消息时往请求头添加信息
     * @param message
     */
    public void sendMessageWithProperties(String message) {
        rabbitTemplate.convertAndSend(DirectMQConfig.DIRECT_EXCHANGE_NAME,
                DirectMQConfig.DIRECT_ROUTING_KEY_NAME,
                message,
                originalMessage -> {
                    MessageProperties messageProperties = originalMessage.getMessageProperties();
                    messageProperties.setHeader("X-TOKEN", UUID.randomUUID().toString());
                    return originalMessage;
                });
    }
}
