package com.tea.modules.java8.exception;

import java.io.*;

/**
 * @author jaymin<br>
 * 抛出异常案例<br>
 * 2020/11/5 21:30
 */
public class ThrowsException {
    /**
     * 我们声明了一个不存在的文件，试图获取它的输出流，这时IDE会提示我们需要处理受检查的异常
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) {

        File noExitsFile = new File("D:\\logs\\notExistFile");
        try (FileOutputStream fileOutputStream = new FileOutputStream(noExitsFile);
             FileInputStream fileInputStream = new FileInputStream(noExitsFile);) {
            FileDescriptor fd = fileOutputStream.getFD();
            FileDescriptor fd1 = fileInputStream.getFD();
        } catch (IOException e) {
            // 实际工作中，应使用自定义异常将此错误抛出
            e.printStackTrace();
        }
    }
}
