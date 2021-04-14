package com.tea.modules.bean.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @author jaymin<br>
 * 此代码提供用于访问GlobalEventBus和基础EventBus以及注册和注销事件以及发布事件的静态方法。<br>
 * 在自定义批注中，它还具有SpEL表达式作为默认表达式，以定义我们要使用的EventBus。<br>
 * 2021/1/8 23:55
 */
public class GlobalEventBus {

    /**
     * 全局事件总线表达式
     */
    public static final String GLOBAL_EVENT_BUS_EXPRESSION
            = "T(com.baeldung.postprocessor.GlobalEventBus).getEventBus()";
    /**
     * 识别码
     */
    private static final String IDENTIFIER = "global-event-bus";
    /**
     * 静态的全局事件总线
     */
    private static final GlobalEventBus GLOBAL_EVENT_BUS = new GlobalEventBus();
    private final EventBus eventBus = new AsyncEventBus(IDENTIFIER, Executors.newCachedThreadPool());

    private GlobalEventBus() {
    }

    public static GlobalEventBus getInstance() {
        return GlobalEventBus.GLOBAL_EVENT_BUS;
    }

    public static EventBus getEventBus() {
        return GlobalEventBus.GLOBAL_EVENT_BUS.eventBus;
    }

    /**
     * 订阅
     *
     * @param obj
     */
    public static void subscribe(Object obj) {
        getEventBus().register(obj);
    }

    /**
     * 取消订阅
     *
     * @param obj
     */
    public static void unsubscribe(Object obj) {
        getEventBus().unregister(obj);
    }

    public static void post(Object event) {
        getEventBus().post(event);
    }
}
