package com.tea.returnobject;

import com.alibaba.fastjson.JSONObject;
import com.tea.modules.model.po.Student;

import java.util.Collections;
import java.util.List;

/**
 * com.tea.returnobject<br>
 * 请不要在接口中返回Map、JSONObject这样的结果. <br>
 * 根本无法知晓返回了什么
 *
 * @author jaymin
 * @since 2021/5/16
 */
public class ReturnObjectDemonstration {

    public JSONObject queryStudentInfo() {
        List<Student> students = null;
        try {
            students = selectList();
        } catch (Exception e) {
            JSONObject result = new JSONObject();
            result.put("status", -1);
            result.put("data", Collections.emptyMap());
        }
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("data", students);
        return result;
    }

    public List<Student> queryStudentsInfo(){
        return selectList();
    }

    private List<Student> selectList() {
        return null;
    }
}
