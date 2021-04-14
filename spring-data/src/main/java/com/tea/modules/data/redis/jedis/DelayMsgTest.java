package com.tea.modules.data.redis.jedis;


import com.tea.modules.data.redis.jedis.config.Redis;

public class DelayMsgTest {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.exeute(jedis -> {
            //构造一个消息队列
            DelayMsgQueue delayMsgQueue = new DelayMsgQueue(jedis, "jaymin-delay-queue");
            Runnable producer = () -> {
                for (int i=0;i<5;i++){
                    delayMsgQueue.queue("Java>>>>>"+i);
                }
            };
            Thread producerThread = new Thread(producer);
            Runnable customer = () -> delayMsgQueue.loop();
            Thread customerThread = new Thread(customer);
            producerThread.start();
            customerThread.start();
            try {
                //休息7秒后，停止程序
                Thread.sleep(7000);
                customerThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }
}
