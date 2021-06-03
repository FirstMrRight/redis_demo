package com.tea.modules.java8.stream.lambda;

/**
 * com.tea.modules.java8.stream.lambda <br>
 * 入门lambda表达式
 * @author jaymin
 * @since 2021/6/3
 */
public class WhatIsLambda {

    /**
     * 在Java8之前，使用匿名内部类来创建Runnable任务
     */
    private static void runnableOfBeforeJava8(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am running");
            }
        }).start();
    }

    /**
     * 使用lambda表示创建Runnable任务
     */
    private static void runnableOfJava8(){
        new Thread(() -> System.out.println("I am running")).start();
    }

    public static void main(String[] args) {
        runnableOfBeforeJava8();
        runnableOfJava8();
    }
}
