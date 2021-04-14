package com.tea.modules.java8.stream;

import com.google.common.collect.Lists;
import com.tea.modules.model.StudentForLambda;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void filter(){
        StudentForLambda studentA = new StudentForLambda(1L,"特朗普",45,"漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L,"大雄",30,"日本");
        StudentForLambda studentC = new StudentForLambda(3L,"拿破仑",60,"法国");
        StudentForLambda studentD = new StudentForLambda(4L,"孙中山",25,"中国");
        List<StudentForLambda> studentList = Arrays.asList(studentA,studentB,studentC,studentD);
        //过滤年龄小于40岁的学生
        studentList.stream().filter(student -> student.getAge()<40).collect(Collectors.toList()).forEach(System.out::println);
        studentList.stream().filter(student -> student.getAddress().equals("日本")).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        StudentForLambda studentA = new StudentForLambda(1L, "特朗普", 20, "漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L, "大雄", 30, "日本");
        StudentForLambda studentC = new StudentForLambda(3L, "拿破仑", 20, "法国");
        StudentForLambda studentD = new StudentForLambda(4L, "孙中山", 25, "中国");
        StudentForLambda studentZ = new StudentForLambda(4L, "郑爽", 30, "中国");
        ArrayList<StudentForLambda> classA = Lists.newArrayList(studentA, studentB, studentD);
        ArrayList<StudentForLambda> classB = Lists.newArrayList(studentC, studentZ);
        if (CollectionUtils.isEmpty(classB)) {
            return;
        }
        List<Integer> ageListOfClassA = classA.stream().map(StudentForLambda::getAge).collect(Collectors.toList());
        List<StudentForLambda> needToInsert = classB.stream()
                .filter(student -> ageListOfClassA.contains(student.getAge()))
                .collect(Collectors.toList());
        batchInsert(needToInsert);
    }

    private static void batchInsert(List<StudentForLambda> needToInsert) {

    }
}
