package com.tea.modules.java8.security.md;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * com.tea.modules.java8.security.md.<br>
 * 使用 Bouncy Castle实现消息摘要算法
 * @author xiejiemin
 * @create 2021/3/2
 */
public class BouncyCastleMessageDigest implements IMessageDigest{

    @Override
    public String MD5(String law) {
        Digest digest = new MD5Digest();
        // 用字节块更新消息摘要
        digest.update(law.getBytes(), 0, law.getBytes().length);
        byte[] md4Bytes = new byte[digest.getDigestSize()];
        // 关闭摘要，产生最终的摘要值。 doFinal调用使摘要复位
        digest.doFinal(md4Bytes, 0);
        String result = Hex.toHexString(md4Bytes);
        return result;
    }

    @Override
    public String MD2(String law) {
        Digest digest = new MD2Digest();
        // 用字节块更新消息摘要
        digest.update(law.getBytes(), 0, law.getBytes().length);
        byte[] md2Bytes = new byte[digest.getDigestSize()];
        // 关闭摘要，产生最终的摘要值。 doFinal调用使摘要复位
        digest.doFinal(md2Bytes, 0);
        String result = Hex.toHexString(md2Bytes);
        return result;
    }

    @Override
    public String MD4(String law) {
        Digest digest = new MD4Digest();
        // 用字节块更新消息摘要
        digest.update(law.getBytes(), 0, law.getBytes().length);
        byte[] md4Bytes = new byte[digest.getDigestSize()];
        // 关闭摘要，产生最终的摘要值。 doFinal调用使摘要复位
        digest.doFinal(md4Bytes, 0);
        String result = Hex.toHexString(md4Bytes);
        return result;
    }
}
