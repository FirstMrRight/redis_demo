package com.tea.modules.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jaymin
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable, Comparable {
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 出生日期
     */
    private Date birthDay;
    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空")
    private String name;
    /**
     * 体重
     */
    private Double weight;
    /**
     * 学校
     */
    private String school;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 学费
     */
    private BigDecimal tuition;
    private List<Role> roleList;


    /**
     * the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
     * @param o 与之比较的其他学生
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Student otherStudent = (Student) o;
        return Integer.compare(this.age, otherStudent.age);
    }

}
