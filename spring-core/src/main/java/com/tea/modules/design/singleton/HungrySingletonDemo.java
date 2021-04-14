package com.tea.modules.design.singleton;

/**
 * @author jaymin<br>
 * 饿汉式单例模式<br>
 * 2020/11/15 21:11
 */
public class HungrySingletonDemo {
    private static final HungrySingletonDemo hungrySingleton = new HungrySingletonDemo();

    private HungrySingletonDemo() {
    }

    public static HungrySingletonDemo getInstance() {
        return hungrySingleton;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
