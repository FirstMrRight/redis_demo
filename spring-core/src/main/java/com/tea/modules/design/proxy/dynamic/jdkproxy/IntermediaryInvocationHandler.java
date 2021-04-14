package com.tea.modules.design.proxy.dynamic.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * JDK动态代理实现中介赚取差价的逻辑.<br>
 * 此处封装切面逻辑，相对于AOP中的Aspect.<br>
 * 2021/2/14 19:56
 */
@Slf4j
public class IntermediaryInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public IntermediaryInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        BigDecimal actualPrice = beforeRealSubject(((BigDecimal) args[0]));
        args[0] = actualPrice;
        Object result = method.invoke(targetObject, args);
        return result;
    }

    private BigDecimal beforeRealSubject(BigDecimal money) {
        log.info("中介收取费用:{}", money);
        // 中介赚取中间差价后，支付给服务商
        BigDecimal actualPrice = money.subtract(BigDecimal.valueOf(100));
        return actualPrice;
    }
}
