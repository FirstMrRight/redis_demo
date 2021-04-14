package com.tea.modules.bean.applicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/16 23:52
 */
@Component
@Slf4j
@Order(2)
public class SimpleApplicationListenerA implements ApplicationListener<SimpleApplicationEvent> {

    /**
     * 监听事件进行处理
     *
     * @param event 事件对象
     */
    @Override
    @Async
    public void onApplicationEvent(SimpleApplicationEvent event) {
        log.info("SimpleApplicationListenerA receive event :{} ", event.getMessage());
    }
}
