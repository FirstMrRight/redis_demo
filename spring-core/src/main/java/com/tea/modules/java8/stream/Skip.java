package com.tea.modules.java8.stream;

import com.tea.modules.model.StudentForLambda;

import java.util.Arrays;
import java.util.List;

public class Skip {
    public static void main(String[] args) {
        StudentForLambda studentA = new StudentForLambda(1L,"特朗普",45,"漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L,"大雄",30,"日本");
        StudentForLambda studentC = new StudentForLambda(3L,"拿破仑",60,"法国");
        StudentForLambda studentD = new StudentForLambda(4L,"孙中山",25,"中国");
        List<StudentForLambda> studentList = Arrays.asList(studentA,studentB,studentC,studentD);
        studentList.stream().skip(2).forEach(System.out::println);
    }
}
