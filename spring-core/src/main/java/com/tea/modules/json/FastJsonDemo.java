package com.tea.modules.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tea.modules.model.Student;

import java.util.Date;

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
        System.out.println(json);

        Integer integer = Integer.valueOf(20);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("number", integer);
        String s = JSON.toJSONString(jsonObject);
        System.out.println(s);
    }
}
