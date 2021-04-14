package com.tea.modules.rabbit;

import com.tea.modules.data.rabbitmq.producer.TopicProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jaymin
 * 2021/1/2 15:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TopicMQTest {

    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void test() throws InterruptedException {
        topicProducer.sendMessage("start the game!", "topic.sports.news");
        topicProducer.sendMessage("SpringBoot 编程思想", "topic.book.springboot");
        Thread.sleep(10000);
    }
}
