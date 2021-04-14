package com.tea.modules.java8.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpCilent {
    public static void main(String[] args) {
        try {
            //连接到65000端口
            Socket socket = new Socket("127.0.0.1",65000);
            //获取socket的输出流
            OutputStream outputStream = socket.getOutputStream();
            //获取socket的输入流
            InputStream inputStream = socket.getInputStream();
            //往输入流中写入信息
            outputStream.write(new String("Hello Server").getBytes());
            int ch = 0;
            byte[] buff = new byte[1024];
            //从输出流中获取信息与长度
            ch = inputStream.read(buff);
            System.out.println(new String(buff,0,ch));
            //释放连接
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
