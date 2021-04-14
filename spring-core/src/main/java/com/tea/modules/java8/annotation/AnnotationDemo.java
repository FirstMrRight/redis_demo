package com.tea.modules.java8.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author jaymin
 * 2020/11/8 21:59
 */
@SuppressWarnings("all")
public class AnnotationDemo {
    public static void main(String[] args) {
        PersonResource personResource = new PersonResource();
        personResource.getResourceInfo();
        // 获取Class对象
        Class personResourceClass = personResource.getClass();
        // 获取Class类的注解，不包括field和method的,仅仅是类级别，也就是Type
        Annotation[] annotations = personResourceClass.getAnnotations();
        for (Annotation annotation : annotations) {
            ResourceInfo resourceInfo = (ResourceInfo) annotation;
            System.out.println(resourceInfo.info() + "\n" + resourceInfo.clazz().getName());
        }
        Field[] declaredFields = personResourceClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //判断成员变量中是否有指定类型的注解
            boolean hasAnnotation = declaredField.isAnnotationPresent(PersonInfo.class);
            if (hasAnnotation) {
                PersonInfo personInfo = declaredField.getAnnotation(PersonInfo.class);
                System.out.println(personInfo.name() + "\n" +
                        personInfo.age() + "\n" +
                        Arrays.stream(personInfo.language()).collect(Collectors.joining(",")));
            }
        }

        Method[] declaredMethods = personResourceClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            boolean hasAnnotation = method.isAnnotationPresent(ResourceInfo.class);
            if (hasAnnotation) {
                ResourceInfo resourceInfo = method.getAnnotation(ResourceInfo.class);
                System.out.println(resourceInfo.info() + "\n" +
                        resourceInfo.clazz().getName());
            }
        }
        System.out.println("finish");
    }
}
