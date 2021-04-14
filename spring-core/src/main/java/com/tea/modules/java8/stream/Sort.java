package com.tea.modules.java8.stream;

import com.tea.modules.model.StudentForLambda;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class Sort {
    public static void main(String[] args) {
        StudentForLambda studentA = new StudentForLambda(1L,"特朗普",45,"漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L,"大雄",30,"中国");
        StudentForLambda studentC = new StudentForLambda(3L,"拿破仑",60,"法国");
        StudentForLambda studentD = new StudentForLambda(4L,"孙中山",25,"中国");
        StudentForLambda studentE = new StudentForLambda(1L,"特朗普",80,"漂亮国");
        List<StudentForLambda> studentList = Arrays.asList(studentA,studentB,studentC,studentD,studentE);
        groupByAddressWithAgeDesc(studentA, studentB, studentC, studentD, studentE);
        //按照ID降序排序
        studentList.stream().sorted((s1,s2)->Long.compare(s2.getId(),s1.getId())).forEach(System.out::println);
        //按照ID降序排序，年龄降序排序
        studentList.stream()
                .sorted((s1,s2)->Long.compare(s2.getId(),s1.getId()))
                .sorted(Comparator.comparingInt(StudentForLambda::getAge).reversed())
                .forEach(System.out::println);

        studentList.stream()
                .sorted(Comparator.comparingLong(StudentForLambda::getId).thenComparingInt(StudentForLambda::getAge).reversed())
                .forEach(System.out::println);
    }

    /**
     * 按地址分组，然后计算平均数，最后降序排序
     * @param studentA
     * @param studentB
     * @param studentC
     * @param studentD
     * @param studentE
     */
    private static void groupByAddressWithAgeDesc(StudentForLambda studentA, StudentForLambda studentB, StudentForLambda studentC, StudentForLambda studentD, StudentForLambda studentE) {
        List<StudentForLambda> studentList = Arrays.asList(studentA, studentB, studentC, studentD, studentE);
        LinkedHashMap<String, Double> collect = studentList.stream()
                .sorted(Comparator.comparing(StudentForLambda::getAddress).thenComparing(StudentForLambda::getAge).reversed())
                .collect(Collectors.groupingBy(StudentForLambda::getAddress, LinkedHashMap::new, Collectors.averagingInt(StudentForLambda::getAge)));
        collect.forEach((k,v)-> System.out.println(k+": "+v));
    }
}
