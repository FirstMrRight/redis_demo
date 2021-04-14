package com.tea.modules.java8.thread.threadLocal;

public class TestApi {
    //ThreadLocal<T>
    public static ThreadLocal<Long> x = ThreadLocal.withInitial(() -> {
        System.out.println("initialValue run...");//延迟加载，只在第一次get的时候进行初始化
        return Thread.currentThread().getId();
    });
    public static void main(String[] args) {
        /**
         * ThreadLocal为每一个线程存储一个独立的变量
         */
        new Thread(()->{
            System.out.println(x.get());
        }).start();
        x.set(107L);
        x.remove();//清空当前线程的ThreadLocal的值
        System.out.println(x.get());//当前线程的ThreadLocal值被清空后，重新触发了initialValue()
    }
}
