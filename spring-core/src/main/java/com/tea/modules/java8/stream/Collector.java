package com.tea.modules.java8.stream;

import com.alibaba.fastjson.JSON;
import com.tea.modules.model.po.StudentForLambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * com.tea.modules.java8.stream
 *
 * @author jaymin
 * @since 2021/5/14
 */
public class Collector {

    public static void main(String[] args) {
        StudentForLambda studentA = new StudentForLambda(1L, "特朗普", 45, "漂亮国");
        StudentForLambda studentB = new StudentForLambda(2L, "大雄", 30, "日本");
        StudentForLambda studentC = new StudentForLambda(3L, "拿破仑", 60, "法国");
        StudentForLambda studentD = new StudentForLambda(4L, "孙中山", 25, "中国");
        StudentForLambda studentE = new StudentForLambda(4L, "孙中山", 25, "中国");
        StudentForLambda studentF = new StudentForLambda(3L, "拿破仑", 60, "法国");
        List<StudentForLambda> studentList = Arrays.asList(studentA, studentB, studentC, studentD, studentE, studentF);
        Map<Long, String> collect = studentList.stream()
                .collect(
                        Collectors.toMap(
                                StudentForLambda::getId,
                                studentForLambda -> JSON.toJSONString(studentForLambda)
                        ));
    }
}
