package com.tea.modules.design.proxy.dynamic.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * 基于CGLIB实现动态代理.<br>
 * 2021/2/14 20:46
 */
@Slf4j
public class IntermediaryMethInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        BigDecimal actualPrice = beforeRealSubject(((BigDecimal) args[0]));
        args[0] = actualPrice;
        Object result = methodProxy.invokeSuper(object, args);
        return result;
    }

    private BigDecimal beforeRealSubject(BigDecimal money) {
        log.info("中介收取费用:{}", money);
        // 中介赚取中间差价后，支付给服务商
        BigDecimal actualPrice = money.subtract(BigDecimal.valueOf(100));
        return actualPrice;
    }
}
