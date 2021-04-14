package com.tea.modules.java8.security.md;

import com.tea.modules.exception.RestfulException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * com.tea.modules.java8.security.md.<br>
 * 使用Common Codec实现消息摘要算法
 * @author xiejiemin
 * @create 2021/3/2
 */
public class CommonCodecMessageDigest implements IMessageDigest{
    @Override
    public String MD5(String law) {
        return DigestUtils.md5Hex(law);
    }

    @Override
    public String MD2(String law) {
        return DigestUtils.md2Hex(law);
    }

    @Override
    public String MD4(String law) {
        throw new RuntimeException("No such Algorithm");
    }
}
