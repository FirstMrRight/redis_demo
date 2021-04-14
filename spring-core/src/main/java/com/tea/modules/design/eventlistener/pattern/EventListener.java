package com.tea.modules.design.eventlistener.pattern;

/**
 * @author jaymin<br>
 * 事件监听器<br>
 * 2021/1/11 22:18
 */
public interface EventListener {
    /**
     * 处理事件
     * @param event 事件
     */
    void processEvent(Event event);
}
