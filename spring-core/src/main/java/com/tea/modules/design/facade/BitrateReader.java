package com.tea.modules.design.facade;

/**
 * @author Liutx
 * @date 2020/12/26 22:48
 * @Description 字节读取转换为Video
 */
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }

}
