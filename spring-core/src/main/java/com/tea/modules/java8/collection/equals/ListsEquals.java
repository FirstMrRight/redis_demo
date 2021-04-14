package com.tea.modules.java8.collection.equals;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jaymin
 * 2021/1/11 21:54
 */
public class ListsEquals {

    public static void main(String[] args) {
        ArrayList<Integer> one = Lists.newArrayList(1, 2, 2, 3);
        ArrayList<Integer> two = Lists.newArrayList(2, 1, 2, 3);
        Collections.sort(one);
        Collections.sort(two);
        boolean isEquals = Iterators.elementsEqual(one.iterator(), two.iterator());
        System.out.println(isEquals);
    }
}
