package com.tea.modules.java8.extend;

import com.tea.modules.model.Children;

/**
 * @author jaymin<br>
 * 做一个测试，一个子类继承自父类，子类被实例化的时候，看看会不会触发父类的构造方法<br>
 * 2020/11/29 12:29
 */
public class ExtendInitDemo {
    public static void main(String[] args) {
        Children children = new Children();
    }
}
