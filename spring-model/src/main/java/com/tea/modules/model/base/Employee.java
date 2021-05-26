package com.tea.modules.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * com.tea.modules.model.base <br>
 * 雇员类
 *
 * @author jaymin
 * @since 2021/5/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    /**
     * 名称
     */
    private String name;
    /**
     * 工资
     */
    private double salary;
    /**
     * 入职日期
     */
    private LocalDate hireDay;

    /**
     * 涨工资
     * @param byPercent 涨薪幅度,例如: 1.25
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary *= raise;
    }
}
