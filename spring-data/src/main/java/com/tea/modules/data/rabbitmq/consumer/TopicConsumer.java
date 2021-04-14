package com.tea.modules.data.rabbitmq.consumer;

import com.tea.modules.data.rabbitmq.config.TopicMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/2 15:35
 */
@Component
@Slf4j
public class TopicConsumer {

    @RabbitListener(queues = {TopicMQConfig.BASKETBALL_TOPIC_QUEUE_NAME})
    @RabbitHandler
    public void basketballReceiveMessage(String message) {
        log.info("basketball consumer receive the message:{}", message);
    }

    @RabbitListener(queues = {TopicMQConfig.FOOTBALL_TOPIC_QUEUE_NAME})
    @RabbitHandler
    public void footballReceiveMessage(String message) {
        log.info("football consumer receive the message:{}", message);
    }

    @RabbitListener(queues = {TopicMQConfig.BOOK_TOPIC_QUEUE_NAME})
    @RabbitHandler
    public void bookReceiveMessage(String message) {
        log.info("book consumer receive the message:{}", message);
    }
}
