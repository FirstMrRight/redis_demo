package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.service.Charger;

/**
 * @author jaymin<br>
 *     小米充电器<br>
 * 2020/11/8 0:29
 */
public class XiaomiCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("使用小米充电器进行充电");
    }
}
