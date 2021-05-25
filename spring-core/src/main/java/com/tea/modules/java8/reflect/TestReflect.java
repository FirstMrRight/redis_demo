package com.tea.modules.java8.reflect;

import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.tea.modules.model.po.Student");
        Method toString = aClass.getDeclaredMethod("toString",null);
        toString.setAccessible(true);
        Object o = aClass.newInstance();
        Object invoke = toString.invoke(o, null);
        System.out.println(invoke);
    }
}
