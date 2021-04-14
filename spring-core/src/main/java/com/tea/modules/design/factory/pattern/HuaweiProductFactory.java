package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.ProductFactory;
import com.tea.modules.design.factory.service.Charger;
import com.tea.modules.design.factory.service.Phone;

/**
 * @author jaymin<br>
 * 华为产品线<br>
 * 2020/11/8 0:36
 */
public class HuaweiProductFactory implements ProductFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Charger createCharger() {
        return new HuaweiCharger();
    }
}
