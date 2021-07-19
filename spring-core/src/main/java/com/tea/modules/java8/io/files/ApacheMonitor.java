package com.tea.modules.java8.io.files;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * com.tea.modules.java8.io.files
 *
 * @author jaymin
 * @since 2021/7/8
 */
@Component
public class ApacheMonitor extends FileAlterationListenerAdaptor {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onStart(FileAlterationObserver observer) {
        System.out.println("---monitor start---");
    }

    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("创建文件夹" + directory);
    }

    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("修改文件夹" + directory);
    }

    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("删除文件夹" + directory);
    }

    @Override
    public void onFileCreate(File file) {
        System.out.println("创建文件" + file);
        applicationEventPublisher.publishEvent(new FileModifyEvent(file));
    }

    @Override
    public void onFileChange(File file) {
        System.out.println("修改文件" + file);
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("删除文件" + file);
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        System.out.println("---monitor end---");
    }

}
