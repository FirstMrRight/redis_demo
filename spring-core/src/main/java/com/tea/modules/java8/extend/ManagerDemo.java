package com.tea.modules.java8.extend;

import com.tea.modules.model.base.Employee;
import com.tea.modules.model.po.Manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * com.tea.modules.java8.extend <br>
 * 理解继承
 *
 * @author jaymin
 * @since 2021/5/25
 */
public class ManagerDemo {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        LocalDate hireDay = LocalDate.of(2021, 5, 25);
        Employee manager = new Manager("经理", 20000, hireDay, 10000);
        Employee jack = new Employee("Jack", 10000, hireDay);
        Employee james = new Employee("James", 10000, hireDay);
        employees.add(manager);
        employees.add(jack);
        employees.add(james);
        employees.forEach(System.out::println);
        for (Employee employee : employees) {
            if(employee instanceof Manager){
                Manager managerPerson = (Manager) employee;
                System.out.println(managerPerson.getSalary());
            }
        }
        Manager testManager = new Manager();
    }
}
