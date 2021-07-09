package com.tea.modules.java8.io.files;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;

/**
 * com.tea.modules.java8.io.files
 *
 * @author jaymin
 * @since 2021/7/9
 */
@Component
public class FileMonitorRegisterConfig {


    @Resource
    private FileListenerMonitorUtils fileListenerMonitorUtils ;

    @PostConstruct
    private void register() {
        File directory = new File("C:\\Users\\jaymin\\Desktop\\Jaymin\\电子书");
        if (!directory.exists()) {
            throw new NullPointerException("目录不存在启动文件观察者失败:" + directory);
        }
        Long intervalSeconds = 5L;
        try {
            // 为指定文件夹下面的指定文件注册文件观察者
            FileAlterationMonitor monitor = fileListenerMonitorUtils.getMonitor(directory,intervalSeconds);
            // 启动观察者
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
