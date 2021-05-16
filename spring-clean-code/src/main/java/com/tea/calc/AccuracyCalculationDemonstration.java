package com.tea.calc;

import java.math.BigDecimal;

/**
 * com.tea.calc<br>
 * 使用BigDecimal代替浮点数进行精度计算
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class AccuracyCalculationDemonstration {
    public static void main(String[] args) {
        System.out.println(1.02 - 0.42);
        BigDecimal balance = BigDecimal.valueOf(1.02);
        BigDecimal price = BigDecimal.valueOf(0.42);
        System.out.println(balance.subtract(price));
    }
}

