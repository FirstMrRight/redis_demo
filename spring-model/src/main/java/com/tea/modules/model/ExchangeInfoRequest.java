package com.tea.modules.model;


import lombok.Data;

import java.util.Date;

/**
 * com.tea.modules.model
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Data
public class ExchangeInfoRequest {
    private String exchangeCode;
    private Date updateTime;

    public static ExchangeInfoRequest init(String exchangeCode){
        ExchangeInfoRequest exchangeInfoRequest = new ExchangeInfoRequest();
        exchangeInfoRequest.setExchangeCode(exchangeCode);
        exchangeInfoRequest.setUpdateTime(new Date());
        return exchangeInfoRequest;
    }
}
