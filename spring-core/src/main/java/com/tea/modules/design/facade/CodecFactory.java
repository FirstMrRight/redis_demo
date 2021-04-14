package com.tea.modules.design.facade;

/**
 * @author Liutx
 * @date 2020/12/26 22:44
 * @Description
 */
public class CodecFactory {
    /**
     * 解码器提取文件解码方法
     *
     * @param file
     * @return
     */
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (("mp4").equals(type)) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
