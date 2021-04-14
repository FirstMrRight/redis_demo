package com.tea.modules.java8.security.base64;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * com.tea.modules.java8.security.<br>
 * Java安全加密学习-基于Base64的加密方式实战.<br>
 *
 * @author xiejiemin
 * @create 2021/2/23
 */
@Slf4j
public class JDKBase64 implements IBase64 {
    @Override
    public String encode(String laws) {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(laws.getBytes());
        return encode;
    }

    @Override
    public String decode(String ciphertext) {
        String result = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] decodeBuffer = decoder.decodeBuffer(ciphertext);
            result = new String(decodeBuffer);
        } catch (IOException exception) {
            log.error("jdk base64 decode error:{}", exception);
        }
        return result;
    }
}
