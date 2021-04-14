package com.tea.modules.design.proxy.statics;

import com.tea.modules.design.proxy.statics.LandlordProxied;
import com.tea.modules.design.proxy.statics.RentAgencyProxy;
import com.tea.modules.design.proxy.statics.RentSubject;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author jaymin.<br>
 * 租客,目前租客想找房子，手里有1000块钱.<br>
 * 中介找到了900块的房子，将订单接收了下来,收取100块的中介费.<br>
 * 房东此时有空置的房子，900块。<br>
 * 2021/2/14 18:53
 */
@Slf4j
public class TenantClient {

    public static void main(String[] args) {
        RentSubject rentSubject = new RentAgencyProxy(new LandlordProxied());
        String house = rentSubject.findHouse(BigDecimal.valueOf(1000));
        log.info("租客拿到了房门钥匙:" + house);
    }
}
