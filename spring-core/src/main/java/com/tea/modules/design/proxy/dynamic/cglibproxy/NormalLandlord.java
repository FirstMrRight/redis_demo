package com.tea.modules.design.proxy.dynamic.cglibproxy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * 对CGLIB测试，是否能增强没有实现接口的类.<br>
 * 此类为普通的房东，没有实现任何接口，纯收钱交房.<br>
 * 2021/2/14 21:00
 */
@Slf4j
public class NormalLandlord {

    public String findHouse(BigDecimal rent) {
        log.info("房东收到了:{}租金,交出钥匙.", rent);
        return "Lock";
    }

}
