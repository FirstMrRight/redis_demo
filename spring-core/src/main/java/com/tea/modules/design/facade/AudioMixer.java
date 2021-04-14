package com.tea.modules.design.facade;

import java.io.File;

/**
 * @author Liutx
 * @date 2020/12/26 22:50
 * @Description 混音器，组合视频、音频
 */
public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
