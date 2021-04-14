package com.tea.modules.design.factory;

import com.tea.modules.design.factory.pattern.HuaweiProductFactory;
import com.tea.modules.design.factory.service.Charger;
import com.tea.modules.design.factory.service.Phone;


/**
 * @author jaymin<br>
 * 抽象工厂模式<br>
 * 2020/11/8 0:38
 */
public class AbstractFactoryPattern {
    /**
     * 抽象工厂模式无法解决新增产品的问题。<br>
     * 也就是说如果此时要让工厂具备生产手机膜的能力，必须将ProductFactory加多一个生产手机膜的接口。这也是违反了开闭原则的<br>
     *
     * @param args
     */
    public static void main(String[] args) {
        HuaweiProductFactory huaweiProductFactory = new HuaweiProductFactory();
        Phone phone = huaweiProductFactory.createPhone();
        Charger charger = huaweiProductFactory.createCharger();
        phone.call();
        System.out.println("2天后，华为手机没电了");
        charger.charge();
    }
}
