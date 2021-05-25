package com.tea.retrunnull;

import com.tea.modules.model.po.Student;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * com.tea.retrunnull <br>
 * 返回空的对象，而不是null
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class ReturnEmptyObjectReplaceNull {

    public List<Student> getStudentsInfo(String studentName) {
        List<Student> students = list(studentName);
        if (Objects.isNull(students)) {
            return null;
        }
        return students;
    }

    public List<Student> queryStudentsInfo(String studentName) {
        List<Student> students = list(studentName);
        if (Objects.isNull(students)) {
            return Collections.emptyList();
        }
        return students;
    }

    private List<Student> list(String studentName) {
        return null;
    }
}
