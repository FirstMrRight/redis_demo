package com.tea.modules.design.proxy.statics;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * 房租中介机构,负责帮租客找房子.<br>
 * 同时，找到房子后，中介需要向房东支付租金.<br>
 * 2021/2/14 18:45
 */
@Slf4j
public class RentAgencyProxy implements RentSubject {

    private RentSubject rentSubject;

    public RentAgencyProxy(RentSubject rentSubject) {
        this.rentSubject = rentSubject;
    }

    @Override
    public String findHouse(BigDecimal rent) {
        BigDecimal actualRent = beforeRealSubject(rent);
        return this.rentSubject.findHouse(actualRent);
    }

    private BigDecimal beforeRealSubject(BigDecimal rent) {
        log.info("中介收取当前租客租金:{}", rent);
        // 中介赚取中间差价后，支付给房东
        BigDecimal actualRent = rent.subtract(BigDecimal.valueOf(100));
        return actualRent;
    }
}
