package com.tea.modules.bean.applicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/17 1:28
 */
@Component
@Slf4j
public class SimpleApplicationEventListenerOfAnnotation {

    @EventListener()
    @Order(2)
    @Async
    public void onApplicationEventA(SimpleApplicationEvent event) {
        log.info("SimpleApplicationEventListenerOfAnnotation#onApplicationEventA receive event :{} ", event.getMessage());
    }

    @EventListener()
    @Order(1)
    @Async
    public void onApplicationEventB(SimpleApplicationEvent event) {
        log.info("SimpleApplicationEventListenerOfAnnotation#onApplicationEventB receive event :{} ", event.getMessage());
    }
}
