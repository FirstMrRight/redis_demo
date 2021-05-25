package com.tea.modules.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tea.modules.model.po.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jaymin
 * 2021/1/12 21:50
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(20);
        student.setName("李华");
        student.setBirthDay(new Date());
        String json = JSON.toJSONString(student);
        List<String> jsons = new ArrayList<>();
        jsons.add(json);
        jsons.add(json);
        String s = jsons.toString();
        List<Student> students = JSONArray.parseArray(s, Student.class);
    }
}
