package com.tea.modules.bean.event;

/**
 * @author jaymin
 * 2021/1/9 0:08
 */
@FunctionalInterface
public interface StockTradeListener {
    void stockTradePublished(StockTrade trade);
}
