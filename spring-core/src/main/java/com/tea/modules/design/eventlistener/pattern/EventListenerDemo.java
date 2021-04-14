package com.tea.modules.design.eventlistener.pattern;

/**
 * @author jaymin
 * 2021/1/11 22:33
 */
public class EventListenerDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        OnlineNewsEventListener onlineNewsEventListener = new OnlineNewsEventListener();
        OfflineNewsEventListener offlineNewsEventListener = new OfflineNewsEventListener();
        eventSource.register(onlineNewsEventListener);
        eventSource.register(offlineNewsEventListener);
        eventSource.publishEvent(Event.builder().message("特朗普被推特永久封禁!").build());
    }
}
