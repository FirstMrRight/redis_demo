package com.tea.modules.java8.calc;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author jaymin<br>
 * 使用BigDecimal进行计算<br>
 * 2020/11/5 23:29
 */
public class BigDecimalDemo {
    /**
     * <h2>scale需要比小数位大</h2>
     */
    private static void problem() {
        // 生成一个BigDecimal对象，值为12.222
        BigDecimal bigDecimal = new BigDecimal("12.222");
        // 设置精度为2位小数点,这样会报错-精度丢失,设成比原来的小数点大可以解决这个问题
        BigDecimal result = bigDecimal.setScale(2);
        System.out.println(result);
    }

    /**
     * 保留2位小数，舍入方式为四舍五入
     */
    private static void rounding(String number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        BigDecimal result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result);
    }

    /**
     * 除法除不尽的问题
     */
    private static void divideProblem() {
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal result = bigDecimal.divide(BigDecimal.valueOf(3));
        System.out.println(result);
    }

    /**
     * 使用四舍五入的方式来处理除法除不尽的情况
     */
    private static void divideHandle() {
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal result = bigDecimal.divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP);
        System.out.println(result);
        // 保留2位小数
        BigDecimal scaleResult = bigDecimal.divide(BigDecimal.valueOf(3), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(scaleResult);
    }

    /**
     * 精度问题导致比较结果与预期的不一致<br>
     * 0与0.0实际上应该相等才对<br>
     *     触发原因:java.math.BigDecimal#equals(java.lang.Object)
     */
    private static void equalProblem() {
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        BigDecimal bigDecimal1 = new BigDecimal("0.0");
        System.out.println(Objects.equals(bigDecimal, bigDecimal1));
    }

    /**
     * 使用compareTo来比较BigDecimal
     */
    private static void compareBigDecimal() {
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        BigDecimal bigDecimal1 = new BigDecimal("0.0");
        int result = bigDecimal.compareTo(bigDecimal1);
        if (result == 0) {
            System.out.println("两数相等");
        }
    }

    public static void main(String[] args) {
        equalProblem();
        compareBigDecimal();
    }
}
