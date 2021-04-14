package com.tea.modules.data.redis.jedis;

import com.tea.modules.data.redis.jedis.config.Redis;

/**
 * 使用Redis的HyperLogLog统计用户访问量Page View和访问用户数User View
 */
public class CountPvAndUv {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.exeute(jedis -> {
            for (int i = 0; i < 2000; i++) {
                //key为uv,value每次放2个，一个是当前的i，一个是下一个i值，那么下次循环就会产生重复值了
                jedis.pfadd("uv","u"+i,"u"+(i+1));
            }
            long uv = jedis.pfcount("uv");
            System.out.println(uv);
        });
    }
}
