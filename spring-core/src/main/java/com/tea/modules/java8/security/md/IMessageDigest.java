package com.tea.modules.java8.security.md;


/**
 * com.tea.modules.java8.security.md.<br>
 * 用于研究MD5、MD4、MD2
 *
 * @author xiejiemin
 * @create 2021/3/2
 */
public interface IMessageDigest {

    /**
     * MD5加密
     *
     * @param law 明文
     * @return 密文
     */
    String MD5(String law);

    /**
     * MD2加密
     *
     * @param law 明文
     * @return 密文
     */
    String MD2(String law);

    /**
     * 使用Bouncy Castle实现MD4加密
     *
     * @param law 明文
     * @return 密文
     */
    String MD4(String law);
}
