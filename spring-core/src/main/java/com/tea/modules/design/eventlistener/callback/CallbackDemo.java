package com.tea.modules.design.eventlistener.callback;

/**
 * @author jaymin
 * 2021/1/10 21:34
 */
public class CallbackDemo {
    public static void main(String[] args) {
        new DeliveryPerson(()-> System.out.println("食物已到达，请下楼取餐"),"冰红茶").execute();

        new Thread(()-> System.out.println("callback")).start();
    }
}
