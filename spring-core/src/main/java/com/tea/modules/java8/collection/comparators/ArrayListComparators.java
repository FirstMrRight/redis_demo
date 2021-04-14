package com.tea.modules.java8.collection.comparators;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * com.xjm.collection.comparators
 *
 * @author xiejiemin
 * @create 2020/12/22
 */
public class ArrayListComparators {

    public static void main(String[] args) {
        ArrayList<Integer> sourceList = Lists.newArrayList(1, 1,2, 3, 4);
        ArrayList<Integer> targetList = Lists.newArrayList(2, 2, 3,4, 5, 6);
        doWithGuava(sourceList, targetList);
        doOfMySelf(sourceList, targetList);
    }

    /**
     * 使用Guava对比
     * @param sourceList
     * @param targetList
     */
    private static void doWithGuava(ArrayList<Integer> sourceList, ArrayList<Integer> targetList) {
        HashSet<Integer> sourceSet = Sets.newHashSet(sourceList);
        HashSet<Integer> targetSet = Sets.newHashSet(targetList);
        Sets.SetView<Integer> difference = Sets.difference(sourceSet, targetSet);
        Sets.SetView<Integer> differenceB = Sets.difference(targetSet, sourceSet);
        difference.stream().forEach(System.out::println);
        differenceB.forEach(System.out::println);
    }

    /**
     * demo调用
     * @param sourceList
     * @param targetList
     */
    private static void doOfMySelf(ArrayList<Integer> sourceList,ArrayList<Integer> targetList){
        sourceList.forEach(System.out::println);
        targetList.forEach(System.out::println);
        List<Integer> resultA = getDifferenceSetByMyself(sourceList, targetList);
        List<Integer> resultB = getDifferenceSetByMyself(targetList, sourceList);
        System.out.println("-----------------------");
        resultA.forEach(System.out::println);
        System.out.println("-----------------------");
        resultB.forEach(System.out::println);
    }

    /**
     * 自己实现对比集合的操作
     * @param big
     * @param small
     * @return
     */
    private static List<Integer> getDifferenceSetByMyself(List<Integer> big, List<Integer> small) {
        Set<Integer> sameInteger = Sets.newHashSet();
        for (Integer s : small) {
            sameInteger.add(s);
        }
        List<Integer> result = Lists.newArrayList();
        for (Integer s : big) {
            if (sameInteger.add(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
