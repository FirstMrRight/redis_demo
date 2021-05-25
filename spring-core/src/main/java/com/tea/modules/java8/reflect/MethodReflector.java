package com.tea.modules.java8.reflect;

import com.tea.modules.model.po.ReflectBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * com.xjm.reflect
 *
 * @author xiejiemin
 * @create 2020/11/8
 */
@SuppressWarnings("all")
public class MethodReflector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 获取Class对象
        Class clazz = Class.forName("com.tea.modules.model.po.ReflectBean");
        // 2. 获取所有公有方法,获取到的methods是可以获取到父类的方法的，包括Object
        System.out.println("******************Get All Public Methods***************************************************");
        Method[] publicMethods = clazz.getMethods();
        for (Method publicMethod : publicMethods) {
            System.out.println(publicMethod);
        }
        // 3. 获取所有的方法，无视private,这个不包含父类的方法
        System.out.println("******************Get All Methods*********************************************************");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        // 4. 获取某个public的method
        System.out.println("******************Get A Public Method*****************************************************");
        Method display = clazz.getMethod("display", String.class);
        System.out.println(display);
        // 5. 获取某个method，无视private
        System.out.println("******************Get A Private Method*****************************************************");
        Method getMessage = clazz.getDeclaredMethod("getMessage", int.class);
        System.out.println(getMessage);
        // 授权
        getMessage.setAccessible(true);
        Constructor constructor = clazz.getConstructor();
        ReflectBean reflectBean = (ReflectBean) constructor.newInstance();
        // 方法返回值
        String invokeResult = String.valueOf(getMessage.invoke(reflectBean, 1));
        System.out.println(invokeResult);
        display.invoke(reflectBean, "Display");
    }
}
