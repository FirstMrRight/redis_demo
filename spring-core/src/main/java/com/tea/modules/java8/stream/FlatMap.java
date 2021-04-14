package com.tea.modules.java8.stream;

import com.google.common.collect.Lists;
import com.tea.modules.model.StudentForLambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        /**
         * A班成员如下
         */
        StudentForLambda studentA = new StudentForLambda(1L,"特朗普",45,"漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L,"大雄",30,"日本");
        StudentForLambda studentC = new StudentForLambda(3L,"拿破仑",60,"法国");
        StudentForLambda studentD = new StudentForLambda(4L,"孙中山",25,"中国");
        ArrayList<StudentForLambda> classA = Lists.newArrayList(studentA, studentB, studentC, studentD);
        /**
         * B班成员如下
         */
        StudentForLambda studentE = new StudentForLambda(5L, "詹姆斯", 35, "漂亮国");
        StudentForLambda studentF = new StudentForLambda(6L, "杜兰特", 31, "漂亮国");
        StudentForLambda studentG = new StudentForLambda(7L, "姚明", 35, "中国");
        ArrayList<StudentForLambda> classB = Lists.newArrayList(studentE, studentF, studentG);
        /**
         * 年级中添加A班与B班的学生信息
         */
        List<List<StudentForLambda>> grade = new ArrayList<>();
        grade.add(classA);
        grade.add(classB);

        /**
         * 获取年级中每个班级的学生姓名
         */
        List<String> namesOfgrade = grade.stream().flatMap(Collection::stream).map(StudentForLambda::getName).collect(Collectors.toList());
        /**
         * 遍历输出结果
         */
        namesOfgrade.forEach(System.out::println);

        List<String> collect = classA.stream().map(StudentForLambda::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
