package com.tea.modules.design.delegation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jaymin<br>
 * 委托方,对外暴露，你可以把它当成一个组合类，它可以帮你做软件服务和硬件服务。<br>
 * 但是你无需关心它的内部运作.<br>
 * 委托类将任务接收到后，马上进行转发.<br>
 * 聚合代替继承<br>
 * 2020/12/13 21:24
 */
public class ITTaskDelegate implements ITWorker {
    private Map<String, ITWorker> targetMap = new HashMap<>();

    public ITTaskDelegate() {
        targetMap.put("server task", new ServerITWorker());
        targetMap.put("hardware task", new HardWareITWorker());
    }

    @Override
    public void work(String task) {
        targetMap.get(task).work(task);
    }
}
