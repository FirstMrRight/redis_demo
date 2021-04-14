package com.tea.modules.design.factory;

import com.tea.modules.design.factory.service.Phone;
import com.tea.modules.design.factory.pattern.HuaweiPhoneFactory;

/**
 * @author jaymin<br>
 * 工厂方法模式<br>
 * 2020/11/8 0:01
 */
public class FactoryMethodPattern {

    /**
     * 工厂方法模式不违反开闭原则，新增品牌工厂只需要继承PhoneFactory即可。<br>
     * 同时也符合单一职责原则，每个工厂只生产自己的产品<br>
     * 缺点:工厂不可能只生产一样东西，每当要生产新的产品，如手机壳，那么相应的工厂将成倍增加。<br>
     * 也就是说，工厂方法模式，更侧重于生产一种产品，它可以来自不同的厂商。<br>
     * @param args
     */
    public static void main(String[] args) {
        HuaweiPhoneFactory huaweiFactory = new HuaweiPhoneFactory();
        Phone phone = huaweiFactory.createPhone();
        phone.call();
    }

}
