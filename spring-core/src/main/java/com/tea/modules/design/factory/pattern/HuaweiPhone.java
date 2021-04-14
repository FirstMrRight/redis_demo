package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.service.Phone;

/**
 * @author jaymin<br>
 *     华为手机<br>
 * 2020/11/7 23:35
 */
public class HuaweiPhone implements Phone {

    @Override
    public void call() {
        System.out.println("用华为手机打电话");
    }

}
