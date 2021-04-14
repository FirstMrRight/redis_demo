package com.tea.modules.java8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.xjm.annotation<br>
 * 注解<br>
 * 所有的注解都源自Annotation.java<br>
 *
 * @author xiejiemin
 * <h4>@interface会在编译的时候自动继承Annotation<br></h4>
 * 可以通过反编译指令来查看它们之间的联系<br>
 * javac FirstAnnotation.java<br>
 * javap FirstAnnotation.class<br>
 * 注解的属性支持所有的基础类型、Enum类型、String类型、Class类型、Annotation类型，以及它们的数组<br>
 * 属性的修饰符可以是public和缺省的<br>
 * @create 2020/11/8
 */
@Target(value = {ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfo {
    /**
     * 名字
     *
     * @return
     */
    public String name();

    /**
     * 年龄
     * @return
     */
    public int age() default 20;

    /**
     * 语言
     */
    public String[] language();
}
