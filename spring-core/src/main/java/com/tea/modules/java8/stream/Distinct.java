package com.tea.modules.java8.stream;

import com.tea.modules.model.po.StudentForLambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Distinct {
    public static void main(String[] args) {
        StudentForLambda studentA = new StudentForLambda(1L, "特朗普", 45, "漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L, "大雄", 30, "日本");
        StudentForLambda studentC = new StudentForLambda(3L, "拿破仑", 60, "法国");
        StudentForLambda studentD = new StudentForLambda(4L, "孙中山", 25, "中国");
        StudentForLambda studentE = new StudentForLambda(4L, "孙中山", 25, "中国");
        StudentForLambda studentF = new StudentForLambda(3L, "拿破仑", 60, "法国");
        List<StudentForLambda> studentList = Arrays.asList(studentA, studentB, studentC, studentD, studentE, studentF);
        studentList.stream().distinct().forEach(System.out::println);
        studentList.stream().filter(distinctByKey(student -> student.getName())).forEach(System.out::println);
    }


    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        //putIfAbsent
        //如果不存在（新的entry），那么会向map中添加该键值对，并返回null。
        //如果已经存在，那么不会覆盖已有的值，直接返回已经存在的值。
        return t -> objectObjectConcurrentHashMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


//    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
//        Set<Object> seen = ConcurrentHashMap.newKeySet();
//        return t -> seen.add(keyExtractor.apply(t));
//    }
}