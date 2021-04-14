package com.tea.modules.java8.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        //发送数据报
        DatagramSocket datagramSocket = new DatagramSocket();
        //将发送的内容转成二进制
        byte[] bytes = "Hello Server".getBytes();
        //源地址
        InetAddress address =  InetAddress.getByName("127.0.0.1");
        //发送数据
        datagramSocket.send(new DatagramPacket(bytes,bytes.length, address,65001));

        //接收服务器回复的数据
        DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);
        datagramSocket.receive(datagramPacket);
        //获取数据
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data,0,data.length));
        datagramSocket.close();
    }
}
