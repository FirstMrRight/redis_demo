package com.tea.modules.java8.datatype;

/**
 * @author jaymin<br>
 * 如何表示一个值不是数字、正无穷大、负无穷大
 * 2021/3/21 14:54
 */
public class NaNDemo {
    public static void main(String[] args) {
        isNaN();
        isPositiveInfinityAndNegativeInfinity();
    }

    private static void isNaN() {
        Double doubleNaN = new Double(0.0/0.0);
        // 一个常数，其值为double类型的非数字（NaN）值
        Double nan = Double.NaN;
        System.out.println(doubleNaN.isNaN());
        System.out.println(nan.isNaN());
    }

    private static void isPositiveInfinityAndNegativeInfinity(){
        double positiveInfinity = Double.POSITIVE_INFINITY;
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        System.out.println(positiveInfinity);
        System.out.println(negativeInfinity);
    }
}
