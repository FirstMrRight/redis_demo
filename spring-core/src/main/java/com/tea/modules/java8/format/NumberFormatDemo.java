package com.tea.modules.java8.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * com.tea.java8.format
 *
 * @author xiejiemin
 * @create 2021/1/27
 */
public class NumberFormatDemo {


    /**
     * 对数字做补齐,补齐4位,但是无法对超过4位的数字做长度限制，这个需要开发者自己进行编写.
     */
    private static void format(Long number) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("0000");
        String format = decimalFormat.format(number);
        System.out.println(format);
    }

    /**
     * 使用NumberFormat进行格式化，也可以达到上面的效果.
     * @param number
     * @return
     */
    public static String geFourNumber(int number) {
        if (number > 9999) {
            number = number % 10000;
        }
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(4);
        formatter.setMaximumIntegerDigits(4);
        formatter.setGroupingUsed(false);
        return formatter.format(number);
    }

    public static void main(String[] args) {
        format(100000L);
        // 使用String.format,同样可以
        String format = String.format("%04d", 11112);
        if (format.length() > 4) {
            format = format.substring(0, 4);
        }
        System.out.println(format);
    }
}
