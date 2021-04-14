package com.tea.modules.design.proxy.statics;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * 房东,只负责收钱交房子即可.不关心谁进行支付.<br>
 * 2021/2/14 18:48
 */
@Slf4j
public class LandlordProxied implements RentSubject {

    @Override
    public String findHouse(BigDecimal rent) {
        log.info("房东收到了:{}租金,交出钥匙.", rent);
        return "Lock";
    }
}
