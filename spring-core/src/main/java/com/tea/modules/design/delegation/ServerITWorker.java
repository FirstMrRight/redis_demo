package com.tea.modules.design.delegation;

/**
 * @author jaymin<br>
 * 服务端程序员,负责写代码，不会修电脑<br>
 * 在委派事件中，这往往是被委托的角色，也就是真正干活的人<br>
 * 2020/12/13 21:12
 */
public class ServerITWorker implements ITWorker {

    @Override
    public void work(String task) {
        System.out.println("I am a Java programmer.I will handler the task:" + task);
    }
}
