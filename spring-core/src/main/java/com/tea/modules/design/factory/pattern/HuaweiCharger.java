package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.service.Charger;

/**
 * @author jaymin<br>
 *     华为充电器<br>
 * 2020/11/8 0:30
 */
public class HuaweiCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("使用华为充电器进行充电");
    }
}
