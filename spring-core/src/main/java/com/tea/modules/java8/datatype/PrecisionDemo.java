package com.tea.modules.java8.datatype;

import java.math.BigDecimal;

/**
 * @author jaymin<br>
 * 浮点数无法表示分数
 * @since 2021/3/21 15:07
 */
public class PrecisionDemo {
    public static void main(String[] args) {
        System.out.println(2.0 - 1.1);
        // 如何解决?使用BigDecimal
        BigDecimal a = BigDecimal.valueOf(2.0);
        BigDecimal b = BigDecimal.valueOf(1.1);
        System.out.println(a.subtract(b));
    }
}
