package com.tea.modules.java8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jaymin
 * 2020/11/8 21:48
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceInfo {
    /**
     * 信息
     * @return
     */
    public String info();

    /**
     * 所用的类
     * @return
     */
    public Class clazz();
}
