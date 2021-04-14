package com.tea.modules.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private int age;

    static {
        System.out.println("我是一个静态方法,我是类加载的时候就会发生的事件");
    }

    {
        System.out.println("我是一个初始化时执行的方法，我比构造器的优先级要高");
    }
    public User(){
        System.out.println("一个User对象被创建出来了");
    }
    /**
     * 返回空集合，用于演示NPE
     * @return
     */
    public static List<User> getNullInstances(){
        return null;
    }
}
