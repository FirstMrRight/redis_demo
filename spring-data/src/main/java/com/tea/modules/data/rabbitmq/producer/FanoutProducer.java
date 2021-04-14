package com.tea.modules.data.rabbitmq.producer;

import com.tea.modules.data.rabbitmq.config.FanoutMQConfig;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/2 14:52
 */
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class FanoutProducer {

    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息至fanout交换机,由于fanout只关注订阅关系，所以routing key随便指定都可以
     * @param message
     */
    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(FanoutMQConfig.FANOUT_EXCHANGE_NAME, StringUtils.EMPTY, message);
    }
}
