package com.tea.modules.util;

import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jaymin.<br>
 * 摘自:<a href="https://www.iteye.com/blog/rejoy-1627405">JDK动态代理实现原理</a>
 * 2021/2/15 0:17
 */
@Slf4j
public class ProxyGeneratorUtils {

    /**
     * 把代理类的字节码写到硬盘上
     * @param path 保存路径
     */
    public static void writeProxyClassToHardDisk(String path,Class<?> clazz,String proxyName) {
        // 获取代理类的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                log.info("IO error:{}",e);
            }
        }
    }
}
