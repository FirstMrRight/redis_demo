package com.tea.modules.data.rabbitmq.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tea.modules.model.Order;
import com.tea.modules.data.rabbitmq.config.SimpleMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2020/12/30 17:52
 */
@Component
@Slf4j
public class SimpleConsumer {

    @RabbitListener(queues = {SimpleMQConfig.SIMPLE_QUEUE_NAME})
    @RabbitHandler
    public void receiveMessage(String message) {
        log.info("simple consumer receive the message:{}", message);
    }

    @RabbitListener(queues = {SimpleMQConfig.HANDLER_OBJECT_QUEUE_NAME})
    @RabbitHandler
    public void receiveObject(Order order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(order);
        log.info("simple consumer receive the object:{}", message);
    }
}
