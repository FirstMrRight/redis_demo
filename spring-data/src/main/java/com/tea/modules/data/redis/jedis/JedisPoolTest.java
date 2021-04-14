package com.tea.modules.data.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {
    public static void main(String[] args) {
        Jedis jedis = null;
        //构造一个连接池对象
        JedisPool jedisPool = new JedisPool("192.168.11.131",6379);
        //从连接池中获取Jedis连接
        jedis = jedisPool.getResource();
        jedis.auth("123");
        try {
            //如果抛出异常，会导致资源无法回收,所以要使用try catch finally机制
            String ping = jedis.ping();
            System.out.println(ping);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis!=null) {
                //归还连接
                jedis.close();
            }
        }
    }
}
