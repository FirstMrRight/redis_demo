package com.tea.modules.design.strategy;

/**
 * @author Liutx
 * @date 2020/11/19 21:57
 * @Description
 */
public class CalculateContext {
    private CalculateStrategy calculateStrategy;

    /**
     * 构造方法,使用策略对象
     */
    public CalculateContext(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    /**
     * 负责调用策略
     *
     * @param num1
     * @param num2
     * @return
     */
    public int executeStrategy(int num1, int num2) {
        return calculateStrategy.doOperation(num1, num2);
    }
}
