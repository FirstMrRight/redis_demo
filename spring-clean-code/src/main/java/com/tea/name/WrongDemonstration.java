package com.tea.name;

import com.tea.modules.model.Student;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * com.tea.name <br>
 * 一个不好的命名风格的代码，看起来非常糟糕
 *
 * @author jaymin
 * @since 2021/5/13
 */
public class WrongDemonstration {
    /**
     * 男人
     */
    private static final int MAN = 0;

    /**
     * 这段代码充满了坏味道:  <br>
     * 1. p代表什么意义？     <br>
     * 2. selectList()到底返回了什么? list能准确表达语意吗? <br>
     * 3. 遍历中的s类型是Student,但是如果你不看Student，你无法知道它真正代表什么 <br>
     * 4. 0到底代表什么?   <br>
     * 5. 方法名:do_something代表什么意思?这样命名是规范的吗? <br>
     */
    public Date do_something(String p) {
        List<Student> list = selectList(p);
        for (Student s : list) {
            if (s.getGender().equals(0)) {
                return s.getBirthDay();
            }
        }
        return null;
    }

    /**
     * 获取当前男学生姓名的生日
     * @param studentName 学生姓名
     * @return Date
     */
    public Date getBirthDayOfMan(String studentName) {
        List<Student> students = selectList(studentName);
        if (CollectionUtils.isEmpty(students)) {
            return null;
        }
        for (Student student : students) {
            if (isMan(student.getGender())) {
                return student.getBirthDay();
            }
        }
        return null;
    }

    /**
     * 模拟平时调用数据库的操作
     *
     * @param params 参数
     * @return 学生列表
     */
    private List<Student> selectList(String params) {
        return Collections.emptyList();
    }

    private boolean isMan(Integer gender) {
        return Objects.equals(gender, MAN);
    }

}
