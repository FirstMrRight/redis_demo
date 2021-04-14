package com.tea.modules.data.redis.jedis.config;

import com.tea.modules.data.redis.jedis.CallWithJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Redis {
    private JedisPool jedisPool;

    public Redis(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(300);//最大空闲数
        jedisPoolConfig.setMaxTotal(1000);//最大连接数
        jedisPoolConfig.setMaxWaitMillis(30000);//最大等待时间,单位是毫秒,-1表示不做限制
        jedisPoolConfig.setTestOnBorrow(true);//空闲时检查有效性
        /**
         * config，配置信息
         * redis的ip地址
         * 端口
         * 超时时间
         * 密码
         */
        jedisPool = new JedisPool(jedisPoolConfig,"192.168.31.40",6379,30000,"123");
    }

    public void exeute(CallWithJedis callWithJedis){
        try (Jedis jedis = jedisPool.getResource()){
            callWithJedis.call(jedis);
        }
    }
}
