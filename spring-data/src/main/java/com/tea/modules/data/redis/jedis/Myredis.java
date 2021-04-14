package com.tea.modules.data.redis.jedis;

import redis.clients.jedis.Jedis;

public class Myredis {
    public static void main(String[] args) {
        //构造一个jedis对象,如果是6379，则不用配置端口
        Jedis jedis = new Jedis("192.168.11.131");
        //密码认证
//        jedis.auth("123");
        //测试连接
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
