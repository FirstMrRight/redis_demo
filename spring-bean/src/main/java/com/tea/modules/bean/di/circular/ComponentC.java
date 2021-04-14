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
public class ComponentC {

    @Autowired
    private ComponentB componentB;
}
