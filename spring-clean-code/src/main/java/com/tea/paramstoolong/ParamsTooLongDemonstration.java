package com.tea.paramstoolong;

import com.tea.modules.model.Student;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * com.tea.paramstoolong<br>
 * 参数过长，请使用对象封装
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class ParamsTooLongDemonstration {
    public List<Student> getStudentInfo(String studentName,
                                        String school,
                                        Date createTime,
                                        Long page,
                                        Long pageSize,
                                        Integer age) {
        List<Student> students = selectList(studentName, school, createTime, page, pageSize, age);
        return students;
    }

    public List<Student> getStudentInfo(StudentQueryVO queryVO) {
        List<Student> students = selectList(queryVO);
        return students;
    }

    private List<Student> selectList(StudentQueryVO queryVO) {
        return Collections.emptyList();
    }

    private List<Student> selectList(String studentName, String school, Date createTime, Long page, Long pageSize, Integer age) {
        return Collections.emptyList();
    }
}
