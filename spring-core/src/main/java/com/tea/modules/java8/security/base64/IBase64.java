package com.tea.modules.java8.security.base64;

/**
 * com.tea.modules.java8.security.base64
 *
 * @author xiejiemin
 * @create 2021/2/24
 */
public interface IBase64 {

    /**
     * 对明文进行Base64加密
     *
     * @param laws 明文
     * @return 密文
     */
    String encode(String laws);

    /**
     * 对密文进行Base64解密
     *
     * @param ciphertext 密文
     * @return 明文
     */
    String decode(String ciphertext);
}
