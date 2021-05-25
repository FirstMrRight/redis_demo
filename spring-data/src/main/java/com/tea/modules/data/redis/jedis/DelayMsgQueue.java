package com.tea.modules.data.redis.jedis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tea.modules.model.po.RedisMessage;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * 延迟消息队列
 */
public class DelayMsgQueue {
    private Jedis jedis;
    private String queue;

    public DelayMsgQueue(Jedis jedis, String queue) {
        this.jedis = jedis;
        this.queue = queue;
    }

    /**
     * 消息入队，要发送的消息
     * @param message
     */
    public void queue(Object message){
         RedisMessage redisMessage = new RedisMessage();
         redisMessage.setId(UUID.randomUUID().toString());
         redisMessage.setMessage(message);
        try {
            //序列化
            String s = new ObjectMapper().writeValueAsString(redisMessage);
            System.out.println("Redis发送消息:"+new Date());
            //消息发送,score延迟5秒
            jedis.zadd(queue,System.currentTimeMillis()+5000,s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息出队（消息消费）
     *
     */
    public void loop(){
        /**
         * 轮询，线程被中断时停止
         */
        while (!Thread.interrupted()){
            //读取score时间在0到当前时间戳的之间的消息，一次一条
            Set<String> message = jedis.zrangeByScore(queue, 0, System.currentTimeMillis(), 0, 1);
            if (message.isEmpty()){
                try {
                    //如果消息为空，则线程休眠一段时间
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            //如果读取到了消息,则直接加载
            String next = message.iterator().next();
            if(jedis.zrem(queue,next)>0){
                //抢到了,接下来处理业务
                try {
                    RedisMessage redisMessage = new ObjectMapper().readValue(next, RedisMessage.class);
                    System.out.println("抢到了!"+new Date());
                    System.out.println(redisMessage.toString());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
