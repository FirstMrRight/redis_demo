package com.tea.modules.aopproxy;

import com.tea.modules.model.po.SimplePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.util.function.Consumer;

/**
 * @author jaymin.<br>
 * 本文旨在理解Spring AOP的调用方式.<br>
 * Spring AOP对于自调用有一定的限制.<br>
 * 详情查看:<br>
 * <a href="https://zhuanlan.51cto.com/art/202011/631922.htm">一个Spring AOP的坑！很多人都犯过！ </a> <br>
 * <a href="https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-understanding-aop-proxies"> Understanding AOP Proxies</a> <br>
 *
 * 2021/2/14 21:36
 * @see SimplePojo
 */
@Slf4j
public class SpringAopProxyDemo {

    public static void main(String[] args) {
        // 定义接口,即被代理对象实现的接口
        final Class[] interfaces = new Class[]{Consumer.class};
        ProxyFactory proxyFactory = new ProxyFactory(interfaces);
        // 配置被代理类
        proxyFactory.setTarget(new SimplePojo());
        // 增加前置通知
        proxyFactory.addAdvice((MethodBeforeAdvice) (method, objects, o) -> log.info("hello,I am beforeAdvice."));
        proxyFactory.addAdvice((AfterReturningAdvice) (o, method, objects, o1) -> log.info("hello,I am afterReturningAdvice."));
        // 获取代理对象
        Consumer proxy = (Consumer) proxyFactory.getProxy();
        proxy.accept(null);
    }
}
