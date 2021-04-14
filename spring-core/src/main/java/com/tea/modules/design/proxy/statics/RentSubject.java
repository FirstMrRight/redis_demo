package com.tea.modules.design.proxy.statics;

import java.math.BigDecimal;

/**
 * @author jaymin<br>
 * 租房子的主题.<br>
 * 对于租客来说，只需要付钱即可.<br>
 * 2021/2/14 18:40
 */
public interface RentSubject {

    /**
     * 支付租金寻找房子.
     * @param rent 租金
     * @return
     */
    String findHouse(BigDecimal rent);
}
