package com.tea.modules.java8.string;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * com.xjm.string
 *
 * @author xiejiemin
 * @create 2021/1/12
 */
public class EqualsAndEqualsSign {
    public static void main(String[] args) {
        String s1 = new String("s");
        String s2 = "s";
        String s3 = new String("s");
        String s4 = "s";
        ArrayList<String> strings = Lists.newArrayList(s1, s2, s3, s4);
        strings.forEach(str-> System.out.println(System.identityHashCode(str)));
    }
}
