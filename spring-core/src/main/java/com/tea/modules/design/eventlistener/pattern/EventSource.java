package com.tea.modules.design.eventlistener.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jaymin
 * 2021/1/11 22:30
 */
public class EventSource {
    /**
     * 将所有的监听者进行存储
     */
    private List<EventListener> listenerList = new ArrayList<>();

    /**
     * 注册监听者
     * @param eventListener
     */
    public void register(EventListener eventListener){
        listenerList.add(eventListener);
    }

    /**
     * 发布事件
     * @param event
     */
    public void publishEvent(Event event){
        listenerList.forEach(eventListener -> eventListener.processEvent(event));
    }
}
