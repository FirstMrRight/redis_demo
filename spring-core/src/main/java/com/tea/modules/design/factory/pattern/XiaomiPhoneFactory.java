package com.tea.modules.design.factory.pattern;

import com.tea.modules.design.factory.service.Phone;
import com.tea.modules.design.factory.service.PhoneFactory;

/**
 * @author jaymin<br>
 *     小米手机工厂<br>
 * 2020/11/8 0:03
 */
public class XiaomiPhoneFactory implements PhoneFactory {

    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }
}
