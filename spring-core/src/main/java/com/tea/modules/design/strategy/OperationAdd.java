package com.tea.modules.design.strategy;

/**
 * @author Liutx
 * @date 2020/11/19 22:01
 * @Description 策略的不同实现，相当于if else中不同的逻辑代码
 * 本demo使用加减乘除代替不同的策略逻辑
 */
public class OperationAdd implements CalculateStrategy {
    @Override
    public int doOperation(int firstNum, int secNum) {
        int result = firstNum + secNum;
        System.out.println(result);
        return result;
    }
}
