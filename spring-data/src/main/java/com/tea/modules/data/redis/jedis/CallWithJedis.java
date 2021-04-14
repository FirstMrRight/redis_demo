package com.tea.modules.data.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * 调用Jedis的接口
 */
public interface CallWithJedis {
    void call(Jedis jedis);
}
