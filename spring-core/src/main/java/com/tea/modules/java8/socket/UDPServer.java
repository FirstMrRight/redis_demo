package com.tea.modules.java8.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        //服务端接收客户发送的数据报
        DatagramSocket datagramSocket = new DatagramSocket(65001);
        //存储从客户端接收的内容
        byte[] buf = new byte[100];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //接收客户端发送的内容，并将内容封装进DatagramPacket对象中
        datagramSocket.receive(packet);
        //从DatagramPacket对象中获取数据
        byte[] data = packet.getData();
        String content = new String(data, 0, packet.getLength());
        System.out.println(content);
        //转换成二进制
        byte[] sendData = String.valueOf(content.length()).getBytes();
        //从DatagramPacket对象中获取数据的来源地址与端口号
        DatagramPacket packetToClient = new DatagramPacket(sendData,
                sendData.length, packet.getAddress(), packet.getPort());
        //回发消息
        datagramSocket.send(packetToClient);
        //关闭资源
        datagramSocket.close();
    }
}
