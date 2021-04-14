package com.tea.modules.rabbit;

import com.tea.modules.data.rabbitmq.producer.DirectProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jaymin
 * 2021/1/2 14:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DirectMQTest {

    @Autowired
    private DirectProducer directProducer;

    @Test
    public void test() throws InterruptedException {
        directProducer.sendMessageWithProperties("Hello,2021");
        Thread.sleep(10000);
    }
}
