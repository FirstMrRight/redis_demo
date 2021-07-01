package com.tea.modules.java8.oop.polymorphism;

/**
 * com.tea.modules.java8.oop.polymorphism <br>
 * 中国银行
 *
 * @author jaymin
 * @since 2021/7/1
 */
public class ChineseBank implements IBank {
    @Override
    public void applyCreditCard() {
        System.out.println("办理信用卡送行李箱");
    }
}
