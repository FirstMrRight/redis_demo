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
public class ComponentA {

    @Autowired
    private ComponentB businessServiceB;

    public void execute(){
        businessServiceB.info();
    }
}
