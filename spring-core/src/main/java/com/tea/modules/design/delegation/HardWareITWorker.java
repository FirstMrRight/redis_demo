package com.tea.modules.design.delegation;

/**
 * @author jaymin<br>
 * 硬件设备的IT工作人员，负责维修硬件设备，例如:修电脑<br>
 * 在委派事件中，这往往是被委托的角色，也就是真正干活的人<br>
 * 2020/12/13 21:16
 */
public class HardWareITWorker implements ITWorker{
    @Override
    public void work(String task) {
        System.out.println("I am a hardware worker.I will handler the task:" + task);
    }
}
