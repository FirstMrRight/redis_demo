package com.tea.modules.java8.reflect;

import com.tea.modules.model.po.ReflectBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * com.xjm.reflect<br>
 * 反射获取field<br>
 *
 * @author xiejiemin
 * @create 2020/11/8
 */
@SuppressWarnings("all")
public class FieldReflector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 获取Class对象
        Class clazz = Class.forName("com.tea.modules.model.po.ReflectBean");
        // 2. 获取所有的公有字段
        System.out.println("******************Get All Public Fields***************************************************");
        Field[] fieldArray = clazz.getFields();
        for (Field field : fieldArray) {
            System.out.println(field);
        }
        // 3. 获取所有的字段
        System.out.println("*****************************Get All Fields***********************************************");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        // 4. 获取某个公有的field
        System.out.println("******************Get public Fields******************************************************");
        Field nameField = clazz.getField("name");
        System.out.println(nameField);
        Constructor constructor = clazz.getConstructor();
        ReflectBean reflectBean = (ReflectBean) constructor.newInstance();
        // 赋值
        nameField.set(reflectBean, "Lebron James");
        // 验证name
        System.out.println(reflectBean.name);
        Field staticField = clazz.getDeclaredField("staticField");
        staticField.setAccessible(true);
        staticField.set(reflectBean, "TEST");
        System.out.println("after set static field : "+reflectBean.getStaticField());
        // 5. 获取某个field,无视private
        System.out.println("******************Get Any Fields******************************************************");
        Field targetInfo = clazz.getDeclaredField("targetInfo");
        targetInfo.setAccessible(true);
        targetInfo.set(reflectBean, "ReflectBean Info is null");
        System.out.println(reflectBean.toString());
    }
}
