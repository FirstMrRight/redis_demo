package com.tea.modules.design.factory;

import com.tea.modules.design.factory.service.Charger;
import com.tea.modules.design.factory.service.Phone;

/**
 * @author jaymin<br>
 *     产品接口<br>
 * 2020/11/8 0:33
 */
public interface ProductFactory {
    /**
     * 生产手机
     * @return
     */
    Phone createPhone();

    /**
     * 生产充电器
     * @return
     */
    Charger createCharger();
}
