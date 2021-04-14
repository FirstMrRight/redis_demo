package com.tea.modules.design.factory;

import com.google.common.base.Enums;
import com.tea.modules.design.factory.service.Phone;
import com.tea.modules.enums.PhoneEnum;
import com.tea.modules.design.factory.pattern.HuaweiPhone;
import com.tea.modules.design.factory.pattern.XiaomiPhone;

/**
 * @author jaymin<br>
 * 工厂类<br>
 * 2020/11/7 23:37
 */
public class PhoneFactory {

    /**
     * 根据手机类型来返回手机对象<br>
     * 注意，工厂模式中，每新增一个手机品牌，就需要在代码中新增代码进行判断，这时违反开闭原则的<br>
     * 生活中: 富士康是一个大型的工厂，目前生产小米与华为，如果要帮苹果生产手机，那么要额外加多一条苹果的生产线<br>
     * @param phoneEnum
     * @return
     */
    public static Phone createPhone(PhoneEnum phoneEnum) {
        PhoneEnum phoneType = Enums.getIfPresent(PhoneEnum.class, phoneEnum.name()).get();
        switch (phoneType) {
            case XIAO_MI:
                return new XiaomiPhone();
            case HUAWEI:
                return new HuaweiPhone();
            default:
                return new XiaomiPhone();
        }

    }
}
