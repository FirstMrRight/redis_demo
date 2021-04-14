package com.tea.modules.design.eventlistener.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jaymin
 * 2021/1/11 22:28
 */
@Slf4j
public class OfflineNewsEventListener implements EventListener{
    @Override
    public void processEvent(Event event) {
        log.info("日报头条:今天大事件:{}",event.getMessage());
    }
}
