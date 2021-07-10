package com.tea.modules.java8.io.files;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

/**
 * com.tea.modules.java8.io.files
 *
 * @author jaymin
 * @since 2021/7/10
 */
public class AESEncrypt {
    public static final String ALGORITHM = "AES/ECB/PKCS7Padding";
    /**
     * 使用PKCS7Padding填充必须添加一个支持PKCS7Padding的Provider
     * 类加载的时候添加进去
     */
    static{
        try{
            Security.addProvider(new BouncyCastleProvider());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String Aes256Encode(String str, byte[] key) {
        byte[] result = null;
        try {
            Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
            result = cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.getEncoder().encode(result));
    }

    public static Cipher getCipher(byte[] key, int encryptMode){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            cipher.init(encryptMode, keySpec);
            return cipher;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String Aes256Decode(String str, byte[] key) {
        byte[] bytes = Base64.getDecoder().decode(str);
        String result = null;
        try {
            Cipher cipher = getCipher(key, Cipher.DECRYPT_MODE);
            byte[] decoded = cipher.doFinal(bytes);
            result = new String(decoded, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String content = "CD1000250201906121742434441";
        String aesKey = "0a091b3aa4324435aab703142518a8f7";
        String Result = AESEncrypt.Aes256Encode(content, aesKey.getBytes());
        System.out.println("加密結果:" + Result);
        String value = AESEncrypt.Aes256Decode(Result, aesKey.getBytes());
        System.out.println("解密結果:" + value);
    }
}
