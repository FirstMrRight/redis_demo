package com.tea.modules.java8.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author jaymin
 * 2021/1/18 22:33
 */
public class InputStreamDemo {

    /**
     * <h3>使用available获取当前可以读入的字节数量，这样就不会发送阻塞了.</h3>
     * @throws IOException
     */
    public static void available() throws IOException {
        // 使用try-with-resources关闭资源
        try (FileInputStream in = new FileInputStream("C:\\Users\\95152\\Desktop\\test.txt")) {
            int bytesAvailable = in.available();
            if (bytesAvailable > 0) {
                byte[] data = new byte[bytesAvailable];
                in.read(data);
            }
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
