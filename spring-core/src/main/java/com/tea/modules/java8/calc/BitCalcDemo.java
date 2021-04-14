package com.tea.modules.java8.calc;

import com.rabbitmq.tools.json.JSONUtil;

/**
 * @author jaymin
 * @since 2021/3/25 0:16
 */
public class BitCalcDemo {
    public static void main(String[] args) {
        // 3: 0011
        // 5: 0101
        // ^的规则是:若两个输入位的某一个是 1，另一个不是 1，那么 "^" 运算后结果才是 1
        // ---0110->6
        System.out.println("3^5运算的结果是 :" + (3 ^ 5));
        // 3: 0011
        // 5: 0101
        // &的规则是:若两个输入位都是 1，则"&" 运算后结果是 1，否则结果是 0
        // ---0001->1
        System.out.println("3&5运算的结果是 :" + (3 & 5));
        // 3: 0011
        // 5: 0101
        // |的规则是:若两个输入位里至少有一个是 1，则"|" 运算后结果是 1，都是0的情况下结果是 0
        // ---0111->7
        System.out.println("3|5运算的结果是 :" + (3 | 5));
        //  3: 0011
        // ~3: 1100-> -4
        // 其中，第一位表示正负值
        System.out.println("~3运算的结果是:" + ~3);
        int i = 3 << 1;
        // 3: 0011
        // 左移: 0110->6
        System.out.println("3左移一位运算结果是:" + i);
        int j = 3 >> 1;
        // 3: 0011
        // 右移: 0001->1
        System.out.println("3右移一位运算结果是:" + j);
        // 15: 1111
        // >>>: 0111->7
        System.out.println("15>>>后的结果是:" + (15 >>> 1));
/*        int sum = 1;
        if (sum > 0 && sum < 2) {
            System.out.println("我是1");
        }*/
        int sum = 1;
        sum = sum > 0 ? 1 : -1;
        int number = 1;
        if (sum > 0 || sum < 0) {
            System.out.println("bingo!");
        }
    }
}
