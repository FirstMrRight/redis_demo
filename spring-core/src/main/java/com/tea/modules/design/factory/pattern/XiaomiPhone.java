package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.service.Phone;

/**
 * @author jaymin<br>
 *     小米手机<br>
 * 2020/11/7 23:31
 */
public class XiaomiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("用小米手机打电话");
    }
}
