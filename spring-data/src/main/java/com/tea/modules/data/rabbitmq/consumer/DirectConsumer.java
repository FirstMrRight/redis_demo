package com.tea.modules.data.rabbitmq.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tea.modules.data.rabbitmq.config.DirectMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author jaymin
 * 2021/1/2 14:48
 */
@Component
@Slf4j
public class DirectConsumer {

    @RabbitListener(queues = {DirectMQConfig.DIRECT_QUEUE_NAME})
    @RabbitHandler
    public void receiveMessage(String message, Message originalMessage) throws JsonProcessingException {
        Map<String, Object> headers = originalMessage.getMessageProperties().getHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        String headersParam = objectMapper.writeValueAsString(headers);
        log.info("direct consumer receive the message:{},original message:{},\n headers param:{}", message, originalMessage.toString(), headersParam);
    }
}
