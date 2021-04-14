package com.tea.modules.design.proxy.dynamic.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author jaymin
 * 2021/2/14 20:51
 */
public class CglibUtil {

    /**
     * 使用GGLIB创建代理对象
     * @param targetObject 被代理对象
     * @param methodInterceptor 提供“around advice”的通用增强器回调。
     * @return 被代理对象
     */
    public static <T> T createProxy(T targetObject, MethodInterceptor methodInterceptor) {
        Object proxy = Enhancer.create(targetObject.getClass(), methodInterceptor);
        return (T) proxy;
    }
}
