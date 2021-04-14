package com.tea.modules.java8.annotation;

/**
 * @author jaymin<br>
 * 人力资源类<br>
 * 2020/11/8 21:51
 */
@ResourceInfo(info = "Human Resources", clazz = PersonResource.class)
public class PersonResource {
    @PersonInfo(name = "张三", language = {"Java,Linux"})
    private String worker;

    @PersonInfo(name = "马老师", age = 40, language = "LOL")
    private String teacher;

    @ResourceInfo(info = "The Company is existed", clazz = Void .class)
    public void getResourceInfo() {

    }

}
