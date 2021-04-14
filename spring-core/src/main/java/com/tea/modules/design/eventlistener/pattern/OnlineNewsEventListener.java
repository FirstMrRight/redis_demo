package com.tea.modules.design.eventlistener.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jaymin<br>
 * 如果发生大新闻，网络传媒要处理报道.<br>
 * 2021/1/11 22:27
 */
@Slf4j
public class OnlineNewsEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        log.info("微博爆料:今天的爆炸新闻:{}", event.getMessage());
    }
}
