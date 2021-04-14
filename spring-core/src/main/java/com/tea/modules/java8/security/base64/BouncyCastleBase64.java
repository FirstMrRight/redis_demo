package com.tea.modules.java8.security.base64;

import org.bouncycastle.util.encoders.Base64;

/**
 * com.tea.modules.java8.security.base64
 *
 * @author xiejiemin
 * @create 2021/2/24
 */
public class BouncyCastleBase64 implements IBase64 {

    @Override
    public String encode(String laws) {
        String result = Base64.toBase64String(laws.getBytes());
        return result;
    }

    @Override
    public String decode(String ciphertext) {
        byte[] decodeBytes = Base64.decode(ciphertext);
        String result = new String(decodeBytes);
        return result;
    }
}
