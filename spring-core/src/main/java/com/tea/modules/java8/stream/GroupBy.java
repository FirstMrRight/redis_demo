package com.tea.modules.java8.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tea.modules.model.po.Student;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * com.xjm.java8.stream
 *
 * @author xiejiemin
 * @create 2021/1/7
 */
public class GroupBy {
    /**
     * 按年龄分组
     */
    public static void groupbyAge() {
        ArrayList<Student> students = Lists.newArrayList(
                Student.builder().age(1).name("婴儿1").build(),
                Student.builder().age(1).name("婴儿2").build(),
                Student.builder().age(2).name("大婴儿1").build(),
                Student.builder().age(2).name("大婴儿2").build(),
                Student.builder().age(3).name("大人").build());
        Map<Integer, List<String>> collect = students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));
        collect.entrySet().stream().forEach(group -> System.out.println("当前分组:" + JSON.toJSONString(group.getValue())));
    }

    public static void groupByName() {
        ArrayList<Student> students = Lists.newArrayList(
                Student.builder().age(1).name("A").build(),
                Student.builder().age(1).name("A").build(),
                Student.builder().age(2).name("B").build(),
                Student.builder().age(2).name("B").build(),
                Student.builder().age(3).name("B").build());
        groupByAgeAndJoiningName(students);
        List<Map<String, Integer>> count = new ArrayList<>();
        students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.toList()))
                .forEach((name, studentList) -> {
                    Map<String, Integer> cop = new HashMap<>();
                    Integer ageSum = studentList.stream().reduce(0, (x, y) -> x + y.getAge(), (sum, ageCount) -> sum + ageCount);
                    cop.put(name, ageSum);
                    count.add(cop);
                });
        Map<String, IntSummaryStatistics> summaryStatisticsMap = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.summarizingInt(Student::getAge)));
        summaryStatisticsMap.entrySet().forEach(System.out::println);
        count.stream().forEach(map -> map.forEach((k, v) -> System.out.println(k + " " + v)));
    }

    /**
     * 根据年龄分组，并将名称进行合并
     * @param students
     */
    private static void groupByAgeAndJoiningName(ArrayList<Student> students) {
        Map<Integer, String> result = students.stream().collect(Collectors.groupingBy(
                Student::getAge,
                Collectors.mapping(Student::getName, Collectors.joining("、"))));
        result.forEach((k, v) -> System.out.println(k + "," + v));
    }


    public static void main(String[] args) {
        groupByName();
    }
}
