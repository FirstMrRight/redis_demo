package com.tea.modules.design.proxy.dynamic;

import com.tea.modules.design.proxy.dynamic.cglibproxy.CglibUtil;
import com.tea.modules.design.proxy.dynamic.cglibproxy.IntermediaryMethInterceptor;
import com.tea.modules.design.proxy.dynamic.cglibproxy.NormalLandlord;
import com.tea.modules.design.proxy.dynamic.jdkproxy.IntermediaryInvocationHandler;
import com.tea.modules.design.proxy.dynamic.jdkproxy.JdkDynamicProxyUtil;
import com.tea.modules.design.proxy.statics.LandlordProxied;
import com.tea.modules.design.proxy.statics.RentSubject;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * 动态代理:        <br>
 * 1. JDK的动态代理,需要被代理类实现接口.<br>
 * 2. CGLIB动态代理.                 <br>
 * 2021/2/14 20:11
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        jdkDynamicProxy();
        cglibDynamicProxy();
    }

    /**
     * JDK的动态代理.<br>
     * 在这里，我们只需要提供一个切面逻辑的IntermediaryInvocationHandler即可完成代理逻辑的复用.<br>
     * 更难得的是，只要类实现了任意接口，并且方法参数中的第一个参数为金额，那么中介就可以无缝进行赚取差价了，而不是通过创建类的形式.<br>
     * 形象的来说，中介的逻辑在运行时被"织入"了.<br>
     * 通过debug可以看到,被代理的对象引用前缀为:$Proxy <br>
     */
    private static void jdkDynamicProxy() {
        RentSubject targetObject = new LandlordProxied();
        InvocationHandler handler = new IntermediaryInvocationHandler(targetObject);
        RentSubject rentSubject = JdkDynamicProxyUtil.newProxyInstance(targetObject, handler);
        System.out.println("当前对象是否为代理类:"+JdkDynamicProxyUtil.isProxyInstance(rentSubject));
        rentSubject.findHouse(BigDecimal.valueOf(1000));
    }

    /**
     * CGLIB.在运行时会创建一个继承目标类的子类，并拦截其中的方法执行(覆盖),转发到MethodInterceptor中.
     */
    private static void cglibDynamicProxy(){
        NormalLandlord targetObject = new NormalLandlord();
        MethodInterceptor methInterceptor = new IntermediaryMethInterceptor();
        NormalLandlord proxy = CglibUtil.createProxy(targetObject, methInterceptor);
        proxy.findHouse(BigDecimal.valueOf(1000));
    }
}
