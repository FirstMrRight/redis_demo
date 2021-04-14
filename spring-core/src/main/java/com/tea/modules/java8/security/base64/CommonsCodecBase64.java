package com.tea.modules.java8.security.base64;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * com.tea.modules.java8.security.base64.<br>
 * 基于Apache的Commons Codec进行 Base64.<br>
 * @author xiejiemin
 * @create 2021/2/24
 */
@Slf4j
public class CommonsCodecBase64 implements IBase64 {

    @Override
    public String encode(String laws) {
        byte[] encodeBytes = Base64.encodeBase64(laws.getBytes());
        String result = new String(encodeBytes);
        return result;
    }

    @Override
    public String decode(String ciphertext) {
        String result;
        byte[] decodeBase64 = Base64.decodeBase64(ciphertext);
        result = new String(decodeBase64);
        return result;
    }
}
