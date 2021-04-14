package com.tea.modules.bean.di.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * com.tea.modules.bean.di.circular
 *
 * @author xiejiemin
 * @create 2021/1/29
 */
@Component
public class ComponentB {

    @Autowired
    private ComponentA businessServiceA;

    public void info() {
        System.out.println("now is businessServiceB:  " + this.getClass().getName());
    }
}
