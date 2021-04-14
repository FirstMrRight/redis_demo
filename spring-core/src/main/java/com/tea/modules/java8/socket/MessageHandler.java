package com.tea.modules.java8.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MessageHandler extends Thread {
    private Socket socket;

    public MessageHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            //获取socket的输出流
            OutputStream outputStream = socket.getOutputStream();
            //获取socket的输出流
            InputStream inputStream = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            //从socket的输入流中读取字节存在buff中，将长度赋值给ch
            ch = inputStream.read(buff);
            String content = new String(buff, 0, ch);
            System.out.println(content);
            String receive = "我是服务器，我收到了"+content.length()+"个字节";
            //往输出流中写入信息，回发给客户端
            outputStream.write(receive.getBytes());
            //关闭连接
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
