package com.tea.modules.data.redis.jedis.config;

public class JedisPoolRourse {
    public static void main(String[] args) {
//        //构造一个连接池对象
//        JedisPool jedisPool = new JedisPool("192.168.11.129",6379);
//        /**
//         *从连接池中获取Jedis连接,这是使用了try-wtih-rourse机制
//         * 如果一个资源类继承了Closeable接口,编制时会自动生成finnal回收资源
//         * 但是这样不能做到强约束，会出现资源利用完后没有被回收的情况
//         */
//
//        try (Jedis jedis =  jedisPool.getResource()) {
//            jedis.auth("123");
//            System.out.println(jedis.ping());
//        }

         Redis redis = new Redis();
         redis.exeute(jedis -> System.out.println(jedis.ping()));
    }
}
