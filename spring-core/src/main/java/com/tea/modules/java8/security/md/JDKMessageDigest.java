package com.tea.modules.java8.security.md;

import com.tea.modules.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * com.tea.modules.java8.security.md
 *
 * @author xiejiemin
 * @create 2021/3/2
 */
@Slf4j
public class JDKMessageDigest implements IMessageDigest {

    //  *************************************  //
    //  使用JDK提供的扩展接口来动态添加支持MD4的算法库 //
    //  ************************************* //
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Override
    public String MD5(String law) {
        return messageDigestOfJDK(law,Constants.MD5);
    }

    @Override
    public String MD2(String law) {
        return messageDigestOfJDK(law,Constants.MD2);
    }

    @Override
    public String MD4(String law) {
        return messageDigestOfJDK(law,Constants.MD4);
    }

    /**
     * JDK消息摘要算法
     * @param law 明文
     * @param mdVersion 所使用的MD版本,例如:MD5、MD2
     * @return 密文
     */
    private String messageDigestOfJDK(String law,String mdVersion){
        String result;
        try {
            // 获取md2加密算法对象
            MessageDigest md = MessageDigest.getInstance(mdVersion);
            // 对指定的字节数组对摘要执行更新操作，然后完成摘要计算。
            // 也就是说，此方法首先调用update（input），将输入数组传递给update方法，然后调用digest（）。
            byte[] digest = md.digest(law.getBytes());
            // 这里需要将加密后的数组转化成十六进制
            result = Hex.encodeHexString(digest);
            return result;
        } catch (NoSuchAlgorithmException e) {
            log.error("get md5 instance error:", e);
        }
        return null;
    }
}
