package com.tea.modules.java8.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * com.tea.modules.java8.generic <br>
 * 理解泛型
 *
 * @author jaymin
 * @since 2021/6/4
 */
@SuppressWarnings("all")
public class Genericity {

    /**
     * 泛型只起到检查作用，编译时会变成Object
     */
    private static void checkAndCompile() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1234");
        // 新增数字会报错
        // list.add(1);
    }

    /**
     * 泛型不支持继承
     */
    private static void genericityCanNotExtend() {
        // 第一类错误
        // List<String> first =  new ArrayList<Object>();

        List<Object> list1 = new ArrayList<>();
        list1.add(new Object());
        ArrayList<String> list2 = new ArrayList<>();
        // list2 = list1;

        // 第二类错误
        // ArrayList<Object> second = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<>();
        list3.add(new String());
        // list3 = list1;
    }

    /**
     * 泛型的类型参数只能是类类型，不能是简单类型
     *
     * @param values
     * @param <T>
     */
    private static <T> void doSomething(T... values) {
        for (T value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3};
        int[] arrayB = new int[]{1, 2, 3};
        doSomething(array);
        doSomething(arrayB);
    }
}
