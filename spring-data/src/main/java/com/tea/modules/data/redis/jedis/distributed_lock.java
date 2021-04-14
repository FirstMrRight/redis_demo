package com.tea.modules.data.redis.jedis;

import com.tea.modules.data.redis.jedis.config.Redis;
import redis.clients.jedis.params.SetParams;

import java.util.Arrays;
import java.util.UUID;

/**
 * 实践redis的分布式锁
 */
public class distributed_lock {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
                disributedLock();
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();

    }

    static void  disributedLock(){
        Redis redis = new Redis();
        redis.exeute(jedis -> {
            String uuid = UUID.randomUUID().toString();
            String result = jedis.set("k1", uuid, new SetParams().nx().ex(5));
            if(result!=null && "OK".equals(result)){
                /**
                 * 如果这里的代码出现异常，会导致资源（锁）无法释放，导致其他线程无法得到该资源。
                 * 可以设置过期时间，让Key在一段时间之后自动过期
                 * 设置过期时间，也会存在问题，如果服务器在获取锁和设置过期时间之间挂掉了，那么锁还是无法被释放
                 * 也会造成死锁，因为这是两个操作，不具备原子性。
                 * 在Redis 2.8的版本中，Redis发布了一个新指令,value最好设置成随机数，官网推荐
                 * value的值必须是随机数主要是为了更安全的释放锁，释放锁的时候使用脚本告诉Redis:
                 * 只有key存在并且存储的值和我指定的值一样才能告诉我删除成功
                 * if redis.call("get",KEYS[1]) == ARGV[1] then
                 *     return redis.call("del",KEYS[1])
                 * else
                 *     return 0
                 * end
                 * ---------------------------
                 * set key value nx ex/px time
                 * 关于超时时间的问题：
                 * 如果执行的业务消耗的时间不一致，可能会出现凌乱。
                 * A线程执行了8S，B线程执行了5秒，那么在B执行的过程中，A可能会释放掉Key,让锁失效。
                 * value设置为随机数的话，可以比较value再释放资源.否则不释放
                 * ------------------通过Lua脚本缓存比较value的这个操作，它是原子性的
                 * cat lua/releaseWhereValueEquals.lua | redis-cli -a 123 script load --pipe
                 * -----------SHA1校验码
                 * b8059ba43af6ffe8bed3db65bac35d452f8115d8
                 */
                jedis.set("hello", "world");//没人占位
                System.out.println(jedis.get("hello"));
                //解铃还需系铃人,释放自己的锁
                jedis.evalsha("b8059ba43af6ffe8bed3db65bac35d452f8115d8", Arrays.asList("k1"),Arrays.asList(uuid));
            }else {
                //有人占位,停止/暂缓操作
                System.out.println("先等等...");
            }
        });
    }
}
