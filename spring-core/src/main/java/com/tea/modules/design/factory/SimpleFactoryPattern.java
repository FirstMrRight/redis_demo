package com.tea.modules.design.factory;

import com.tea.modules.design.factory.service.Phone;
import com.tea.modules.enums.PhoneEnum;

/**
 * @author jaymin<br>
 * 简单工厂模式<br>
 * 2020/11/7 23:30
 */
public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Phone phone = PhoneFactory.createPhone(PhoneEnum.XIAO_MI);
        phone.call();
    }
}
