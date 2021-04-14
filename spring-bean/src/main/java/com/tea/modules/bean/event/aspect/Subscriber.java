package com.tea.modules.bean.event.aspect;

import com.tea.modules.bean.event.GlobalEventBus;

import java.lang.annotation.*;

/**
 * @author jaymin
 * 2021/1/8 23:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Subscriber {

    String value() default GlobalEventBus.GLOBAL_EVENT_BUS_EXPRESSION;
}
