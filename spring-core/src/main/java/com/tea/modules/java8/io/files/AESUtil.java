package com.tea.modules.java8.io.files;


import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Base64;

/**
 * com.tea.modules.util
 *
 * @author jaymin
 * @since 2021/7/10
 */
@Slf4j
public class AESUtil {

    /**
     * @param sKey       加密密钥
     * @param cipherMode 密码模式
     * @return
     */
    public static Cipher initAESCipher(String sKey, int cipherMode) {
        // 创建Key gen
        KeyGenerator generator = null;
        Cipher cipher = null;

        try {
            generator = KeyGenerator.getInstance("AES");
            generator.init(128, new SecureRandom(sKey.getBytes()));

            SecretKey secretKey = generator.generateKey();
            byte[] codeFormat = secretKey.getEncoded();

            SecretKeySpec keySpec = new SecretKeySpec(codeFormat, "AES");
            cipher = Cipher.getInstance("AES");

            // 初始化
            cipher.init(cipherMode, keySpec);

        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return cipher;
    }

    /**
     * 文件格式化
     *
     * @param sourceFile  本地文件
     * @param encryptFile 加密后的文件
     * @param sKey        密钥
     * @param type        加密类型
     * @return
     */
    public static File enOrDeFile(File sourceFile, File encryptFile, String sKey, int type) {
        try (
                InputStream inputStream = new FileInputStream(sourceFile);
                OutputStream outputStream = new FileOutputStream(encryptFile);) {
            Cipher cipher = AESEncrypt.getCipher(sKey.getBytes(StandardCharsets.UTF_8), type);
            CipherInputStream cipherInputStream = null;
            CipherOutputStream cipherOutputStream = null;
            if (Cipher.ENCRYPT_MODE == type) {
                // 创建加密流
                cipherInputStream = new CipherInputStream(inputStream, cipher);
            } else if (Cipher.DECRYPT_MODE == type) {
                // 创建解密流
                cipherOutputStream = new CipherOutputStream(outputStream, cipher);
            }
            byte[] cache = new byte[1024];

            int isRead = 0;
            if (Cipher.ENCRYPT_MODE == type) {
                // 加密流写入文件
                while ((isRead = cipherInputStream.read(cache, 0, cache.length)) != -1) {
                    outputStream.write(cache, 0, isRead);
                }
            } else if (Cipher.DECRYPT_MODE == type) {
                // 解密流开始写入文件
                while ((isRead = inputStream.read(cache, 0, cache.length)) != -1) {
                    cipherOutputStream.write(cache, 0, isRead);
                }
            }
            if (cipherInputStream != null) {
                cipherInputStream.close();
            }
            if (cipherOutputStream != null) {
                cipherOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encryptFile;
    }

    /**
     * 文件加密
     *
     * @param encrypFile 加密文件
     * @param sKey       加密密钥
     * @return
     */
    public static File encryptFile(File encrypFile, String sKey) {
        File file = enOrDeFile(null, encrypFile, sKey, Cipher.ENCRYPT_MODE);
        return file;
    }

    /**
     * 文件解密
     *
     * @param encryptFile 加密文件
     * @param suffix      解密文件
     * @param sKey        密钥
     * @return
     */
    public static File decryptFile(File encryptFile, String suffix, String sKey) {
        String path = encryptFile.getPath();
        String fileName = getFileName(encryptFile.getName());
        String decryptFileName = fileName + suffix;
        String directFile = path.substring(0, path.lastIndexOf(File.separator));
        log.info("directFile:" + directFile);
        log.info("decryptFileName:" + decryptFileName);
        String decryptFile = directFile + File.separator + decryptFileName + path.substring(path.lastIndexOf("."));
        log.info("解密文件名:" + decryptFile);
        File file = enOrDeFile(encryptFile, new File(decryptFile), sKey, Cipher.DECRYPT_MODE);
        return file;
    }

    /**
     * 加密文件
     *
     * @param sourceFile  源文件
     * @param encryptFile 目标文件
     * @param sKey        密钥
     * @return
     */
    public static File encryptFile(File sourceFile, File encryptFile, String sKey) {
        File file = enOrDeFile(sourceFile, encryptFile, sKey, Cipher.ENCRYPT_MODE);
        return file;
    }

    /**
     * 生成密钥对
     *
     * @return
     * @throws Exception
     */
    public static KeyPair getKeyPair() throws Exception {
        //BC即BouncyCastle加密包，EC为ECC算法
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "BC");
        keyPairGenerator.initialize(256, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    /**
     * 获取公钥（BASE64编码成字符串后方便用于其他人解码）
     *
     * @param keyPair
     * @return
     */
    public static String getPublicKey(KeyPair keyPair) {
        ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 获取私钥（Base64编码）
     *
     * @param keyPair
     * @return
     */
    public static String getPrivateKey(KeyPair keyPair) {
        ECPrivateKey privateKey = (ECPrivateKey) keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String getFileName(String fileUrl) {
        int name = fileUrl.lastIndexOf(".");
        if (name != -1) {
            String fileName = fileUrl.substring(0, name);
            return fileName;
        }
        return null;
    }
}
