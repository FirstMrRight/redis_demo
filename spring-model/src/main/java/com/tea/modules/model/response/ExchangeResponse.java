package com.tea.modules.model.response;

import lombok.Data;

import java.util.Map;

/**
 * com.tea.modules.model
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Data
public class ExchangeResponse {
    /**
     * 汇率表
     */
    private Map<String,Object> conversionRates;
}
