package com.tea.modules.java8.io.files;

import com.tea.modules.util.LocalDateUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/**
 * com.tea.modules.java8.io.files <Br>
 * 文件夹监控
 *
 * @author jaymin
 * @since 2021/7/8
 */
public class FileMonitor {
    public static void main(String[] args) throws IOException {
//        lookFile();
        monitor();
    }

    /**
     * 查看当前文件夹下的信息
     */
    private static void lookFile() {
        File file = new File("C:\\Users\\jaymin\\Desktop\\Jaymin\\电子书");
        if (!file.exists()) {
            return;
        }
        Arrays.stream(file.listFiles())
                .filter(File::isFile)
                .forEach(f -> {
                    System.out.println("最后的修改时间:" + LocalDateUtil.longToLocalDateTime(f.lastModified()));
                    System.out.println("文件名:[" + f.getName() + "]");
                });
    }

    private static void monitor() throws IOException {

        // 需要监听的文件目录（只能监听目录）
        String path = "C:\\Users\\jaymin\\Desktop\\Jaymin\\电子书";

        WatchService watchservice = FileSystems.getDefault().newWatchService();
        Path p = Paths.get(path);
        p.register(watchservice, StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    WatchKey watchkey = watchservice.take();
                    List<WatchEvent<?>> watchEvents = watchkey.pollEvents();
                    for (WatchEvent<?> event : watchEvents) {
                        //todo 根据事件类型采取不同的操作。。。。。。。
                        System.out.println("[" + path + "/" + event.context() + "]文件发生了[" + event.kind() + "]事件");
                    }
                    watchkey.reset();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();

        // 增加jvm关闭的钩子来关闭监听
        Runtime.getRuntime().addShutdownHook((new Thread(() -> {
            try {
                watchservice.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        )));
    }
}




