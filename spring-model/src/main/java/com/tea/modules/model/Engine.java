package com.tea.modules.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * com.tea.modules.model<br>
 * 汽车引擎
 * @author xiejiemin
 * @create 2021/1/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Engine implements Serializable {
    /**
     * 引擎名称
     */
    private String name;
    /**
     * 价格
     */
    private BigDecimal price;
}
