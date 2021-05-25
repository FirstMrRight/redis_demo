package com.tea.modules.java8.reflect;

import com.tea.modules.model.po.Student;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
public class JavaReflect {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        getStudent(student);
        System.out.println(student);

    }

    public static  <T> void  getStudent(T entity) throws Exception{
        Class<?> studentClass = Class.forName(Student.class.getName());
        Field[] declaredFields = studentClass.getDeclaredFields();//所有属性
//        T o = (T) studentClass.newInstance();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            if(type == String.class){
                declaredField.set(entity,"看到我了没有");
            }else if(type == Integer.class){
                declaredField.set(entity,22222);
            }else if(type == Date.class){
                declaredField.set(entity,new Date());
            }else if(type == BigDecimal.class){
                declaredField.set(entity,BigDecimal.valueOf(888));
            }else if(type == Double.class){
                declaredField.set(entity,50.0);
            }else if(type == Boolean.class){
                declaredField.set(entity,true);
            }
        }
    }
}
