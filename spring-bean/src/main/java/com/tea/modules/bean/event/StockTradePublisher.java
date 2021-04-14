package com.tea.modules.bean.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jaymin<br>
 * 上面的代码将此类标记为Guava EventBus事件的订阅者，而Guava的@Subscribe批注将方法handleNewStockTradeEvent标记为事件的接收者。<br>
 * 它将接收的事件类型基于该方法的单个参数的类。在这种情况下，我们将收到StockTrade类型的事件。<br>
 * 该@AllowConcurrentEvents注释允许这种方法的并发调用。<br>
 * 收到交易后，我们会进行任何处理，然后通知所有监听者。<br>
 * 2021/1/9 0:09
 */
public class StockTradePublisher {

    Set<StockTradeListener> stockTradeListeners = new HashSet<>();

    public void addStockTradeListener(StockTradeListener listener) {
        synchronized (this.stockTradeListeners) {
            this.stockTradeListeners.add(listener);
        }
    }

    public void removeStockTradeListener(StockTradeListener listener) {
        synchronized (this.stockTradeListeners) {
            this.stockTradeListeners.remove(listener);
        }
    }

    @Subscribe
    @AllowConcurrentEvents
    void handleNewStockTradeEvent(StockTrade trade) {
        // publish to DB, send to PubNub, ...
        Set<StockTradeListener> listeners;
        synchronized (this.stockTradeListeners) {
            listeners = new HashSet<>(this.stockTradeListeners);
        }
        listeners.forEach(li -> li.stockTradePublished(trade));
    }
}
