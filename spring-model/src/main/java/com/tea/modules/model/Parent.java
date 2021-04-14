package com.tea.modules.model;

import lombok.Data;

/**
 * @author jaymin<br>
 * 父类<br>
 * 2020/11/29 12:31
 */
@Data
public class Parent {
    private Integer age;
    private String name;
    private Integer gender;

    public Parent() {
        System.out.println("I am Parent");
    }

}
