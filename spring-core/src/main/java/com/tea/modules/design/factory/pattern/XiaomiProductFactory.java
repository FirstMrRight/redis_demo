package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.ProductFactory;
import com.tea.modules.design.factory.service.Charger;
import com.tea.modules.design.factory.service.Phone;

/**
 * @author jaymin<br>
 * 小米产品线<br>
 * 2020/11/8 0:35
 */
public class XiaomiProductFactory implements ProductFactory {
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Charger createCharger() {
        return new XiaomiCharger();
    }
}
