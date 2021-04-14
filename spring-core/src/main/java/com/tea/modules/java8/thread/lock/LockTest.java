package com.tea.modules.java8.thread.lock;

import com.tea.modules.java8.thread.ThreadPoolUtil;

/**
 * com.xjm.thread.lock
 *
 * @author xiejiemin
 * @create 2021/1/7
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        LockObject lockObject = new LockObject();
        ThreadPoolUtil.getThreadPool().execute(()-> {
            try {
                lockObject.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ThreadPoolUtil.getThreadPool().execute(()-> {
            try {
                lockObject.b();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
