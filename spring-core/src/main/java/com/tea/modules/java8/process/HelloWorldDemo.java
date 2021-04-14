package com.tea.modules.java8.process;

import java.util.Arrays;

/**
 * @author jaymin
 * 2021/3/18 23:14
 */
public class HelloWorldDemo {

    /**
     * 根据Java语言规范，main方法必须是public的 <br>
     * 官方规范请查阅:<a href="http://docs.oracle.com/javase/specs">Java语言规范</a><br>
     * 在JDK4后，Java会强制要求main方法是public的<br>
     * static是为了可以直接通过"类名.方法"的方式来调用main方法，例如这里就是->HelloWorldDemo.main(),<br>
     * 这里先留一个印象，static是与class强相关的<br>
     * void 是表示方法没有返回值 <br>
     * @param args 执行主函数的参数列表,例如执行 "java HelloWorldDemo 1",你可以看到Java将参数传递进来的过程
     */
    public static void main(String[] args) {
        /* 1.我是一段注释 */
        // 2. 其实我也可以这样写
        System.out.println("Hello,World :" + Arrays.toString(args));
    }

}
