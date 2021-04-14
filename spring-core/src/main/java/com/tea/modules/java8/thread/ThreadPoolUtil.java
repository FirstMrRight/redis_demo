package com.tea.modules.java8.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jaymin
 * 2020/11/6 0:16
 */
@Slf4j
public class ThreadPoolUtil {
    /**
     * 定义一个线程池，核心线程数:10,最大线程数:100,空闲存活:60s,阻塞队列:1000
     */
    private static final ThreadPoolExecutor threadPool = initPool();


    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    /**
     * 工具类不应该开放构造方法
     */
    private ThreadPoolUtil(){}

    /**
     * 初始化线程池
     * @return
     */
    private static ThreadPoolExecutor initPool() {
        int corePoolSize = 10;
        int maximumPoolSize = 100;
        long keepAliveTime = 60;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(1000);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyRejectPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (
                        corePoolSize,
                        maximumPoolSize,
                        keepAliveTime,
                        TimeUnit.SECONDS,
                        workQueue,
                        threadFactory,
                        handler
                );
        // 预热启动核心线程
        threadPoolExecutor.prestartAllCoreThreads();
        log.info("线程池初始化成功!");
        return threadPoolExecutor;
    }

    /**
     * 自定义线程名称
     */
    private static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-demo-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    /**
     * 拒绝策略
     */
    public static class MyRejectPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
            if (!e.isShutdown()) {
                r.run();
            }
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            log.info(r.toString() + " rejected");
        }
    }
}
