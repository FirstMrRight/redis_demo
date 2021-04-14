package com.tea.modules.design.proxy.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * @author jaymin.<br>
 * JDK动态代理工具类.<br>
 * 2021/2/14 20:04
 */
public class JdkDynamicProxyUtil {

    /**
     * 创建出代理类
     *
     * @param targetObject 被代理的类
     * @param handler      实现InvocationHandler的代理类
     * @return 代理类
     */
    public static <T> T newProxyInstance(T targetObject, InvocationHandler handler) {
        // 获取当前被代理类的类加载器
        ClassLoader classLoader = targetObject.getClass().getClassLoader();
        Class<?>[] interfaces = targetObject.getClass().getInterfaces();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, handler);
        return (T) proxyInstance;
    }

    /**
     * 当前类是否为代理类
     *
     * @param clazz 类
     * @return
     */
    public static boolean isProxyClass(Class<?> clazz) {
        return Proxy.isProxyClass(clazz);
    }

    /**
     * 当前对象是否为代理对象
     * @param target 传入的对象
     * @return
     */
    public static boolean isProxyInstance(Object target) {
        return isProxyClass(target.getClass());
    }
}
