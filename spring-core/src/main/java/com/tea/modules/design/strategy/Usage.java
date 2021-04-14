package com.tea.modules.design.strategy;

/**
 * @author Liutx
 * @date 2020/11/19 22:07
 * @Description
 */
public class Usage {

    public static void main(String[] args) {
        //使用策略模式，创建上下文对象即可，根据不同的上下文调用不同的策略接口

        //调用相加策略
        CalculateContext context = new CalculateContext(new OperationAdd());
        context.executeStrategy(10, 5);

        context = new CalculateContext(new OperationMultiply());
        context.executeStrategy(10, 5);

        context = new CalculateContext(new OperationSubtract());
        context.executeStrategy(10, 5);
    }
}
