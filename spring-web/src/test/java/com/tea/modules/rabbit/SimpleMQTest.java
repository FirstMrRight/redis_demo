package com.tea.modules.rabbit;

import com.tea.modules.model.Order;
import com.tea.modules.data.rabbitmq.producer.SimpleProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author jaymin
 * 2020/12/30 17:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleMQTest {
    @Autowired
    private SimpleProducer simpleProducer;

    @Test
    public void test() throws InterruptedException {
        simpleProducer.sendMessage("First message in spring boot.");
        Thread.sleep(10000);
    }

    @Test
    public void testOrder() throws Exception {
        simpleProducer.sendOrderMessage(Order.builder()
                .createTime(new Date())
                .name("Phone")
                .price("2000")
                .build());
        Thread.sleep(10000);
    }
}
