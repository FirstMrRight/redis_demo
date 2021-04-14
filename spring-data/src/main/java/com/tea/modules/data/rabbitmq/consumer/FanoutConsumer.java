package com.tea.modules.data.rabbitmq.consumer;

import com.tea.modules.data.rabbitmq.config.FanoutMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/2 14:52
 */
@Component
@Slf4j
public class FanoutConsumer {

    @RabbitListener(queues = {FanoutMQConfig.FIRST_FANOUT_QUEUE_NAME})
    @RabbitHandler
    public void firstReceiveMessage(String message) {
        log.info("first fanout consumer receive the message:{}", message);
    }

    @RabbitListener(queues = {FanoutMQConfig.SECOND_FANOUT_QUEUE_NAME})
    @RabbitHandler
    public void secondReceiveMessage(String message) {
        log.info("second fanout consumer receive the message:{}", message);
    }
}
