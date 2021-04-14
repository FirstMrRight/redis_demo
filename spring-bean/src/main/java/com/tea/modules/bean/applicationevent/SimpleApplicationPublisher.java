package com.tea.modules.bean.applicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/17 0:08
 */
@Component
public class SimpleApplicationPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发布事件
     * @param event 事件对象
     */
    public void publish(SimpleApplicationEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
