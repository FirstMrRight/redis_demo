package com.tea.fors;

import com.tea.modules.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * com.tea.fors
 * for-each优于传统的for循环
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class ForEachDemonstration {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getName());
        }

        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
