package com.tea.modules.java8.io.files;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;

/**
 * com.tea.modules.java8.io.files <br>
 * 下载文件、加密传输监听器
 *
 * @author jaymin
 * @since 2021/7/10
 */
@Component
@Slf4j
public class EncryptFileListener implements ApplicationListener<FileModifyEvent> {

    @Value("${com.tea.path.push}")
    private String pushPath;
    /**
     * 加密公钥
     */
    private static final String publicKey = "uBdUx82vPHkDKb284d7NkjFoNcKWBuka";

    @Override
    public void onApplicationEvent(FileModifyEvent event) {
        String name = event.getModifyFile().getName();
        log.info("监控到文件事件,文件名:" + name);
        String encryptPath = pushPath + File.separator + name;
        AESUtil.encryptFile(event.getModifyFile(), new File(encryptPath), publicKey);
        int lastIndexOf = name.lastIndexOf(".");
        AESUtil.decryptFile(new File(encryptPath), "解密", publicKey);
    }

}
