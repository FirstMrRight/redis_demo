package com.tea.modules.java8.security.md;


import lombok.extern.slf4j.Slf4j;

/**
 * com.tea.modules.java8.security.md
 *
 * @author xiejiemin
 * @create 2021/3/2
 */
@Slf4j
public class MessageDigestTest {
    /**
     * 明文
     */
    public static String LAW = "Hello,world";

    public static void main(String[] args) {
        IMessageDigest jdkmd = new JDKMessageDigest();
        jdkMD5(jdkmd);
        jdkMD2(jdkmd);
        jdkMD4(jdkmd);
        IMessageDigest bcmd = new BouncyCastleMessageDigest();
        bcMD5(bcmd);
        bcMD2(bcmd);
        bcMD4(bcmd);
    }

    /**
     * 使用BouncyCastle实现MD4消息摘要算法
     * @param bcmd Bouncy Castle算法对象
     */
    private static void bcMD4(IMessageDigest bcmd) {
        log.info("Before BouncyCastle MD4:{}",LAW);
        String bcmd4Result = bcmd.MD4(LAW);
        log.info("After BouncyCastle MD4:{}",bcmd4Result);
    }

    /**
     * 使用BouncyCastle实现MD2消息摘要算法
     * @param bcmd Bouncy Castle算法对象
     */
    private static void bcMD2(IMessageDigest bcmd) {
        log.info("Before BouncyCastle MD2:{}",LAW);
        String bcmd2Result = bcmd.MD2(LAW);
        log.info("After BouncyCastle MD2:{}",bcmd2Result);
    }

    /**
     *  使用BouncyCastle实现MD5消息摘要算法
     * @param bcmd Bouncy Castle算法对象
     */
    private static void bcMD5(IMessageDigest bcmd) {
        log.info("Before BouncyCastle MD5:{}",LAW);
        String bcmd5Result = bcmd.MD5(LAW);
        log.info("After BouncyCastle MD5:{}",bcmd5Result);
    }

    /**
     * JDK的MD5摘要算法
     * @param jdkmd jdkmd摘要算法对象
     */
    private static void jdkMD5(IMessageDigest jdkmd) {
        log.info("Before JDK MD5:{}",LAW);
        String result = jdkmd.MD5(LAW);
        log.info("After JDK MD5:{}",result);
    }

    /**
     * JDK的MD2摘要算法
     * @param jdkmd jdkmd摘要算法对象
     */
    private static void jdkMD2(IMessageDigest jdkmd) {
        log.info("Before JDK MD2:{}",LAW);
        String jdkMD2Result = jdkmd.MD2(LAW);
        log.info("After JDK MD2:{}",jdkMD2Result);
    }


    /**
     * JDK的MD5摘要算法
     * @param jdkmd jdkmd摘要算法对象
     */
    private static void jdkMD4(IMessageDigest jdkmd) {
        log.info("Before JDK MD4:{}",LAW);
        String jdkMD4Result = jdkmd.MD4(LAW);
        log.info("After JDK MD4:{}",jdkMD4Result);
    }
}
