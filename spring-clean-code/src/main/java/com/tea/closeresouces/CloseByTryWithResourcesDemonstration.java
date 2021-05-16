package com.tea.closeresouces;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * com.tea.closeresouces <br>
 * 关闭资源，请使用try-with-resources
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Slf4j
public class CloseByTryWithResourcesDemonstration {
    /**
     * 常规的情况下关闭资源，特别地啰嗦
     */
    public void close() {
        File noExitsFile = new File("D:\\logs\\notExistFile");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(noExitsFile);
        } catch (FileNotFoundException e) {
            // 实际工作中，应使用自定义异常将此错误抛出
            log.error("An exception occurred when opening a file", e);
        } finally {
            if (Objects.nonNull(fileOutputStream)) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    log.error("An exception occurred when closing the stream");
                }
            }
        }
    }

    /**
     * 使用try-with-resources,事半功倍
     */
    public void closeByTryWithResources() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\logs\\notExistFile")) {
            fileOutputStream.write("something".getBytes());
        } catch (IOException exception) {
            log.error("An exception occurred when closing the stream");
        }
    }
}
