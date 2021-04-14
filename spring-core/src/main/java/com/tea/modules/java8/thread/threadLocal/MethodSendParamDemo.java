package com.tea.modules.java8.thread.threadLocal;

/**
 * com.xjm.thread.threadLocal<br>
 * 尝试在两个方法间通过ThreadLocal进行参数传递
 * @author xiejiemin
 * @create 2020/12/14
 */
public class MethodSendParamDemo {
    public static void main(String[] args) {
        ThreadLocalUtils.put("data","nothing");
        receiveParam();
    }

    public static void receiveParam(){
        String data = ThreadLocalUtils.get("data", String::new);
        System.out.println(data);
        ThreadLocalUtils.clear();
    }
}
