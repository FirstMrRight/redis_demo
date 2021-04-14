package com.tea.modules.java8.security.base64;

import lombok.extern.slf4j.Slf4j;

/**
 * com.tea.modules.java8.security.base64.<br>
 * Base64测试类
 * @author xiejiemin
 * @create 2021/2/24
 */
@Slf4j
public class Base64Test {
    /**
     * 明文
     */
    private static final String LAWS = "Hello,World";

    public static void main(String[] args) {
        IBase64 base64 = new BouncyCastleBase64();
        log.info("before encode:{}", LAWS);
        String encode = base64.encode(LAWS);
        log.info("after encode:{}", encode);
        log.info("before decode:{}", encode);
        String decode = base64.decode(encode);
        log.info("after decode:{}", decode);
    }
}
