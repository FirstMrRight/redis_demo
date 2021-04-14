package com.tea.modules.design.eventlistener.callback;

/**
 * @author jaymin<br>
 * 配送员，负责按照客户的要求进行配送，配送完后通知客户进行用餐。<br>
 * 2021/1/10 21:17
 */

public class DeliveryPerson {
    private String foodName;
    private Callback callback;


    public DeliveryPerson(Callback callback, String foodName) {
        this.callback = callback;
        this.foodName = foodName;
    }

    public void execute() {
        System.out.println("当前用户下单的食品清单:" + foodName);
        System.out.println("到达商家拿到食物");
        System.out.println("抵达客户留下的地址，通知客户进行取餐");
        callback.callback();
    }
}
