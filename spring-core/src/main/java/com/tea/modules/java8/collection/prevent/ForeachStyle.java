package com.tea.modules.java8.collection.prevent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * com.xjm.collection.prevent<br>
 * 使用for循环容易犯错的地方<br>
 *
 * @author xiejiemin
 * @create 2020/12/22
 */
@SuppressWarnings("all")
public class ForeachStyle {

    private static Collection<Integer> left = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    private static Collection<Integer> right = Arrays.asList(1, 2, 3, 4, 5);

    /**
     * 传统集合遍历的弊端<br>
     * 对于数组或者集合来说，我们往往只关心其中的元素，并不需要其中的索引。<br>
     * 在嵌套环境下，需要小心迭代器对象的正确性<br>
     */
    private static void wrongIterator() {
        int[] wrongArray = new int[]{1, 2, 3, 4, 5};
        // 嵌套迭代容易出现问题
        for (Iterator<Integer> leftIterator = left.iterator(); leftIterator.hasNext(); ) {
            for ( Iterator<Integer> rightIterator = right.iterator(); rightIterator.hasNext(); ) {
                System.out.println("left multi right result:" + leftIterator.next() * rightIterator.next());
            }
        }
    }

    /**
     * 正确的迭代器嵌套方式
     */
    public static void rightIterator() {
        // 迭代器遍历集合
        for (Iterator<Integer> leftIterator = left.iterator(); leftIterator.hasNext(); ) {
            System.out.println(leftIterator.next());
        }

        // 正确的用法，嵌套迭代
        for (Iterator<Integer> leftIteratorB = left.iterator(); leftIteratorB.hasNext(); ) {
            Integer tmp = leftIteratorB.next();
            for (Iterator<Integer> rightIteratorB = right.iterator(); rightIteratorB.hasNext(); ) {
                System.out.println("left multi right result:" + tmp * rightIteratorB.next());
            }
        }
    }

    /**
     * 增强for循环
     */
    public static void strengthenFor(){
        // 增强for循环
        for (Integer leftElement : left) {
            for (Integer rightElement : right) {
                System.out.println(leftElement * rightElement);
            }
        }
    }

    /**
     * java8的函数式遍历
     */
    public static void foreachOflambda(){
        // java8的foreach
        left.forEach(l -> {
            right.forEach(r -> {
                System.out.println(l * r);
            });
        });
        // 简单的遍历输出
        left.forEach(System.out::println);
    }

    public static void main(String[] args) {
        wrongIterator();
    }
}
