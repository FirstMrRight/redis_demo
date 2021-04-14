package com.tea.modules.rabbit;

import com.tea.modules.data.rabbitmq.producer.FanoutProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jaymin
 * 2021/1/2 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FanoutMQTest {
    @Autowired
    private FanoutProducer fanoutProducer;

    @Test
    public void test() throws InterruptedException {
        fanoutProducer.sendMessage("Produce once,consume many times");
        Thread.sleep(10000);
    }
}
