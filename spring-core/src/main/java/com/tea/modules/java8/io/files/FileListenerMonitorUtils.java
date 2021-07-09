package com.tea.modules.java8.io.files;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

/**
 * com.tea.modules.java8.io.files
 *
 * @author jaymin
 * @since 2021/7/8
 */
@Component
public class FileListenerMonitorUtils {

    @Resource
    private ApacheMonitor apacheMonitor;

    /**
     * 生成monitor,一intervalSeconds监听directory文件夹下面的以suffix结束，prefix开头的文件
     *
     * @param directory       监视的文件夹
     * @param intervalSeconds 轮训时间
     * @param suffix          监视文件的后缀
     * @param prefix          监视文件的前缀
     * @return 文件观察者
     */
    public FileAlterationMonitor getMonitor(File directory, Long intervalSeconds, String prefix, String suffix) {
        long interval = TimeUnit.SECONDS.toMillis(intervalSeconds);
        IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter());
        IOFileFilter suffixFilter = FileFilterUtils.suffixFileFilter(suffix);
        IOFileFilter prefixFilter = FileFilterUtils.prefixFileFilter(prefix);
        IOFileFilter files = FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
                suffixFilter, prefixFilter);
        IOFileFilter filter = FileFilterUtils.or(directories, files);
        FileAlterationObserver observer = new FileAlterationObserver(directory, filter);
        observer.addListener(apacheMonitor);
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        return monitor;
    }

    /**
     * 监控文件夹
     * @param directory 文件夹
     * @param intervalSeconds 间隔时间
     * @return
     */
    public FileAlterationMonitor getMonitor(File directory, Long intervalSeconds) {
        long interval = TimeUnit.SECONDS.toMillis(intervalSeconds);
        FileAlterationObserver observer = new FileAlterationObserver(directory);
        observer.addListener(apacheMonitor);
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        return monitor;
    }
}
