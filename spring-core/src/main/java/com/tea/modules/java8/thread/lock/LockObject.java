package com.tea.modules.java8.thread.lock;

/**
 * com.xjm.thread.lock
 *
 * @author xiejiemin
 * @create 2021/1/7
 */
public class LockObject {

    public synchronized void a() throws InterruptedException {
        System.out.println("a拿到了锁");
        Thread.sleep(2000);
    }

    public synchronized void b() throws InterruptedException {
        System.out.println("b拿到了锁");
        Thread.sleep(2000);
    }
}
