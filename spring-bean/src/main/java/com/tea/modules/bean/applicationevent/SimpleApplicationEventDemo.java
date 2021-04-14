package com.tea.modules.bean.applicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author jaymin
 * 2021/1/17 0:11
 */
@ComponentScan("com.tea")
@Slf4j
@EnableAsync
public class SimpleApplicationEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(SimpleApplicationEventDemo.class);
        SimpleApplicationPublisher publisher = annotationConfigApplicationContext.getBean(SimpleApplicationPublisher.class);
        SimpleApplicationEvent event = SimpleApplicationEvent.builder().message("Hello,World").build();
        publisher.publish(event);
    }
}
