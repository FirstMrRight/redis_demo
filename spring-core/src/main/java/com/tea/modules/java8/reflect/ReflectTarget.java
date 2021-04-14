package com.tea.modules.java8.reflect;

import java.util.Objects;

/**
 * @author jaymin<br>
 * 反射获取class对象的三种方法<br>
 * 2020/11/8 0:59
 */
@SuppressWarnings("all")
public class ReflectTarget {
    /**
     * 通过三种反射方式拿到的Class对象都是一致的，说明每个类的Class对象是唯一的<br>
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // getClass()
        ReflectTarget reflectTarget = new ReflectTarget();
        Class<? extends ReflectTarget> reflectTargetClass1 = reflectTarget.getClass();
        System.out.println("first:" + reflectTargetClass1.getName());
        // .class
        Class<ReflectTarget> reflectTargetClass2 = ReflectTarget.class;
        System.out.println("second:" + reflectTargetClass2.getName());
        // Class.forName
        Class reflectTargetClass3 = Class.forName("com.tea.modules.java8.reflect.ReflectTarget");
        System.out.println("third:" + reflectTargetClass3.getName());
        System.out.println(Objects.equals(reflectTargetClass1, reflectTargetClass2));
        System.out.println(Objects.equals(reflectTargetClass2, reflectTargetClass3));
    }
}
