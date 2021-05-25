package com.tea.modules.aspect;

import com.tea.modules.model.po.SimplePojo;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * 使用纯Java的方式构建AspectJExpressionPointcut
 * @author jaymin
 * @since 2021/4/24 15:54
 */
public class AspectJExpressionPointcutOfJavaStyle {
    public static void main(String[] args) {
        // 切点表达式
        String pointcutExpression = "@annotation(org.springframework.transaction.annotation.Transactional)";
        // 构建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(new SimplePojo());
        proxyFactory.setProxyTargetClass(true);
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(pointcutExpression);
        // 声明一个通知（此处使用环绕通知 MethodInterceptor ）
        Advice advice = (MethodInterceptor) invocation -> {
            System.out.println("============>放行前拦截...");
            Object obj = invocation.proceed();
            System.out.println("============>放行后拦截...");
            return obj;
        };

        //切面=切点+通知
        // 它还有个构造函数：DefaultPointcutAdvisor(Advice advice); 用的切面就是Pointcut.TRUE，所以如果你要指定切面，请使用自己指定的构造函数
        // Pointcut.TRUE：表示啥都返回true，也就是说这个切面作用于所有的方法上/所有的方法
        // addAdvice();方法最终内部都是被包装成一个 `DefaultPointcutAdvisor`，且使用的是Pointcut.TRUE切面，因此需要注意这些区别  相当于new DefaultPointcutAdvisor(Pointcut.TRUE,advice);
        Advisor advisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut, advice);
        proxyFactory.addAdvisor(advisor);
        SimplePojo simplePojo = (SimplePojo) proxyFactory.getProxy();
        simplePojo.selfCall();
    }
}
