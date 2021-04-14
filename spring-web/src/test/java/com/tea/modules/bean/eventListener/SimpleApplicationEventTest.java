package com.tea.modules.bean.eventListener;

import com.tea.modules.bean.applicationevent.SimpleApplicationEvent;
import com.tea.modules.bean.applicationevent.SimpleApplicationPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jaymin
 * 2021/1/17 1:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleApplicationEventTest {

    @Autowired
    private SimpleApplicationPublisher simpleApplicationPublisher;

    @Test
    public void testSimpleApplication(){
        SimpleApplicationEvent event = SimpleApplicationEvent.builder().message("Hello,World").build();
        simpleApplicationPublisher.publish(event);
    }
}
