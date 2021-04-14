package com.tea.test;

/**
 * com.tea.test
 *
 * @author xiejiemin
 * @since 2021/4/2
 */
public class MyThread extends Thread{

    public MyThread(Runnable run) {
        super(run);
    }

    @Override
    public void start(){
        super.start();
        System.out.println("start");
    }
}
