package com.tea.modules.design.strategy;

/**
 * @author Liutx
 * @date 2020/11/19 22:04
 * @Description
 */
public class OperationMultiply implements CalculateStrategy {
    @Override
    public int doOperation(int firstNum, int secNum) {
        int result = firstNum * secNum;
        System.out.println(result);
        return result;
    }
}
