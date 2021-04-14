package com.tea.modules.design.facade;

import java.io.File;

/**
 * @author Liutx
 * @date 2020/12/26 22:59
 * @Description
 */
public class ClientDemo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("video.ogg", "mp4");


        System.out.println("===================================");


        VideoFile file = new VideoFile("TEST");
        CodecFactory.extract(file);
        BitrateReader.read(file,new OggCompressionCodec());
        BitrateReader.convert(file,new MPEG4CompressionCodec());
        AudioMixer audioMixer = new AudioMixer();
        audioMixer.fix(file);
    }
}
