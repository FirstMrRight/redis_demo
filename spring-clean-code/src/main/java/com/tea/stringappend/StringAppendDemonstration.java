package com.tea.stringappend;

/**
 * com.tea.stringappend
 * 不要在循环中使用+拼接String
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class StringAppendDemonstration {
    public static void right() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            result.append(i);
        }
        System.out.println(result.toString());
    }

    public static void wrong() {
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result = result + i;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        right();
    }
}
