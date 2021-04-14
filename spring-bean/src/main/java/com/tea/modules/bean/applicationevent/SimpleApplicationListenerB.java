package com.tea.modules.bean.applicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jaymin
 * 2021/1/17 0:07
 */
@Component
@Slf4j
@Order(1)
public class SimpleApplicationListenerB implements ApplicationListener<SimpleApplicationEvent> {

    /**
     * 监听事件进行处理
     *
     * @param event 事件对象
     */
    @Override
    public void onApplicationEvent(SimpleApplicationEvent event) {
        log.info("SimpleApplicationListenerB receive event :{} ", event.getMessage());
    }
}
