package com.tea.modules.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jaymin<br>
 * 反射可以无视private，因此使用枚举来实现单例<br>
 * 2020/11/15 21:32
 */
@SuppressWarnings("all")
public class HungrySingletonEnumDemo {
    private HungrySingletonEnumDemo() {
    }

    public static HungrySingletonEnumDemo getInstance() {
        return ContainHolder.HOLDER.instance;
    }

    private enum ContainHolder {
        HOLDER;
        private HungrySingletonEnumDemo instance;

        ContainHolder() {
            instance = new HungrySingletonEnumDemo();
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过单例获取的对象
        System.out.println(HungrySingletonEnumDemo.getInstance());
        Class clazz = HungrySingletonEnumDemo.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // 使用反射破坏private获取的对象
        HungrySingletonEnumDemo hungrySingletonEnumDemo = (HungrySingletonEnumDemo) constructor.newInstance();
        System.out.println(hungrySingletonEnumDemo.getInstance());
        Class containHolderClass = ContainHolder.class;
        // 报错,尝试使用枚举的构造函数进行反射侵入
        // Constructor containHolderConstructor = containHolderClass.getDeclaredConstructor();
        /**
         *     protected Enum(String name, int ordinal) {
         *         this.name = name;
         *         this.ordinal = ordinal;
         *     }
         */
        // Cannot reflectively create enum objects
        // 原因是枚举是使用static进行加载的，其实现也是一种饿汉的单例模式
        Constructor containHolderConstructor = containHolderClass.getDeclaredConstructor(String.class,int.class);
        containHolderConstructor.setAccessible(true);
        System.out.println(containHolderConstructor.newInstance());
    }
}
