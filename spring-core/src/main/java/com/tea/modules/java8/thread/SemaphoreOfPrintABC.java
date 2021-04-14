package com.tea.modules.java8.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * PACKAGE_NAME
 *
 * @author xiejiemin
 * @create 2020/10/12
 */
public class SemaphoreOfPrintABC {
    // 以A开始的信号量,初始信号量数量为1
    private static Semaphore A = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 20, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.execute(() -> PrintA(A, B));
        threadPoolExecutor.execute(() -> PrintB(B, C));
        threadPoolExecutor.execute(() -> PrintC(C, A));
        threadPoolExecutor.shutdown();
    }

    public static void PrintA(Semaphore A, Semaphore B) {
        try {
            for (int i = 0; i < 10; i++) {
                A.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.print("A");
                B.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void PrintB(Semaphore B, Semaphore C) {
        try {
            for (int i = 0; i < 10; i++) {
                B.acquire();
                System.out.print("B");
                C.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void PrintC(Semaphore C, Semaphore A) {
        try {
            for (int i = 0; i < 10; i++) {
                C.acquire();
                System.out.println("C");
                A.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
