package com.tea.modules.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * com.tea.modules.model
 *
 * @author jaymin
 * @since 2021/5/15
 */
@Data
public class HttpResponse {
    private String userName;
    @JSONField(name = "_id")
    private String id;
    private BigDecimal bookPrice;
}
