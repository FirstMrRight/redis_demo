package com.tea.modules.model.po;

import com.tea.modules.model.base.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * com.tea.modules.model.po <br>
 * 经理类，继承自雇员。经理属于特殊的雇员:<br>
 * 除了领工资外，经理还可以达到绩效后领取奖金 <br>
 * Employee->超类(super class)|基类(base class)|父类(parent class)<br>
 * Manager->子类(sub class)|派生类(derived class)|孩子类(child class) <br>
 *
 * @author jaymin
 * @since 2021/5/25
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Manager extends Employee {
    /**
     * 奖金
     */
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay, double bonus) {
        super(name, salary, hireDay);
        this.bonus = bonus;
    }

    /**
     * 经理的工资由[工资+奖金]组成
     *
     * @return double
     */
    @Override
    public double getSalary() {
        // 注意这里要使用super关键字，否则会无限递归
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
