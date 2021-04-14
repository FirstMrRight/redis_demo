package com.tea.modules.java8.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jaymin<br>
 * 反射获取构造器<br>
 * 2020/11/8 1:21
 */
@SuppressWarnings("all")
public class ConstructorReflector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.tea.modules.model.ReflectBean");
        // 1. 获取所有的公有构造方法
        System.out.println("********************All Public Constructor Methods****************************************");
        Constructor[] allPublicConstructors = clazz.getConstructors();
        for (Constructor publicConstructor : allPublicConstructors) {
            System.out.println(publicConstructor);
        }
        // 2. 获取所有的构造方法
        System.out.println("****************************All Constructor Methods***************************************");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
        System.out.println("**********************************GET Two Args Constructor Method With Public*************");
        // 3. 获取某一个构造方法
        Constructor charWithIntParamConstructor = clazz.getDeclaredConstructor(char.class, int.class);
        System.out.println(charWithIntParamConstructor);
        char s = 'c';
        Object jaymin = charWithIntParamConstructor.newInstance(s, 1);
        System.out.println("**************************GET Private Constructor Method**********************************");
        Constructor privateConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println(privateConstructor);
        // 授权访问私有构造函数
        privateConstructor.setAccessible(true);
        Object o = privateConstructor.newInstance(2);
    }
}
