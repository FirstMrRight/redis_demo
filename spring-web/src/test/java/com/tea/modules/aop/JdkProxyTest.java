package com.tea.modules.aop;

import com.tea.modules.design.proxy.dynamic.jdkproxy.IntermediaryInvocationHandler;
import com.tea.modules.design.proxy.dynamic.jdkproxy.JdkDynamicProxyUtil;
import com.tea.modules.design.proxy.statics.LandlordProxied;
import com.tea.modules.design.proxy.statics.RentSubject;
import com.tea.modules.util.ProxyGeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.math.BigDecimal;

/**
 * @author jaymin
 * 2021/2/15 0:21
 */
@Slf4j
public class JdkProxyTest {
    private String path = "C:\\Users\\95152\\Desktop\\proxy.class";

    @Test
    public void testProxy() throws Throwable {
        RentSubject targetObject = new LandlordProxied();
        InvocationHandler handler = new IntermediaryInvocationHandler(targetObject);
        RentSubject rentSubject = JdkDynamicProxyUtil.newProxyInstance(targetObject, handler);
        log.info("当前对象是否为代理类:" + JdkDynamicProxyUtil.isProxyInstance(rentSubject));
        String proxyName = rentSubject.getClass().getName();
        log.info("代理类名称:" + proxyName);
        ProxyGeneratorUtils.writeProxyClassToHardDisk(path, rentSubject.getClass(), proxyName);
        rentSubject.findHouse(BigDecimal.valueOf(1000));
    }
}
