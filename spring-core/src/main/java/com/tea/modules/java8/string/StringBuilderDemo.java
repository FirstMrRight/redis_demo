package com.tea.modules.java8.string;

/**
 * com.tea.modules.java8.string<br>
 * 使用"+"号拼接字符串，会每次产生新的不可变类，造成大量的空间浪费<br>
 * 影响young GC,甚至是full GC.
 *
 * @author jaymin
 * @since 2021/6/4
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        concat();
    }

    /**
     * 会被JVM用StringBuilder优化
     */
    private static void concat() {
        String userName = "QQ";
        String age = "20";
        String company = "tx";

        String info = userName + age + company;
        System.out.println(info);
    }
}
