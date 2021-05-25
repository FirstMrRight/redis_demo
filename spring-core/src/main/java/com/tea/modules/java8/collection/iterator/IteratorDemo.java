package com.tea.modules.java8.collection.iterator;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * com.tea.modules.java8.collection.iterator
 *
 * @author jaymin
 * @since 2021/5/25
 */
public class IteratorDemo {

    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(1, iterator.next())) {
                iterator.remove();
            }
        }
        integers.removeIf(integer -> Objects.equals(2, integer));
        integers.forEach(System.out::println);
    }
}
