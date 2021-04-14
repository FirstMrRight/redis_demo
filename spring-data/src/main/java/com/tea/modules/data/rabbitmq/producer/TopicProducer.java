package com.tea.modules.data.rabbitmq.producer;

import com.tea.modules.data.rabbitmq.config.TopicMQConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/2 15:32
 */
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class TopicProducer {
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message, String topic) {
        rabbitTemplate.convertAndSend(TopicMQConfig.TOPIC_EXCHANGE_NAME, topic, message);
    }
}
