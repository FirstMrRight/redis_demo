package com.tea.modules.design.eventlistener.callback;

import lombok.Data;

/**
 * @author jaymin<br>
 * 客户，负责点餐和留下联系方式<br>
 * 2021/1/10 21:16
 */
@Data
public class UserOrder implements Callback {

    /**
     * 联系方式，配送员送到之后通过这个方法通知客户
     */
    @Override
    public void callback() {
        System.out.println("食物已到达，请下楼取餐");
    }
}
