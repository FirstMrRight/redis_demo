package com.tea.modules.design.strategy;

/**
 * @author Liu-PC
 * 策略角色
 */
public interface CalculateStrategy {
    /**
     * 策略计算接口
     * @param firstNum
     * @param secNum
     * @return
     */
    public int doOperation(int firstNum, int secNum);
}
