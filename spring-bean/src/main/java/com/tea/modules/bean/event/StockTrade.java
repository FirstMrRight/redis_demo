package com.tea.modules.bean.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author jaymin<br>
 * 股票交易
 * 2021/1/9 0:08
 */
@Data
@AllArgsConstructor
public class StockTrade {
    private String symbol;
    private int quantity;
    private double price;
    private Date tradeDate;

}
