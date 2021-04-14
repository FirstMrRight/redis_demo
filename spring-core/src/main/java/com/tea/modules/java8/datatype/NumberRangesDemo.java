package com.tea.modules.java8.datatype;



/**
 * @author jaymin
 * 2021/3/21 14:16
 */
public class NumberRangesDemo {

    public static void main(String[] args) {
        printIntegerRange();
        printShortRange();
        printLongRange();
        printByteRange();
        printFloatRange();
        printDoubleRange();
    }

    /**
     * 打印int的取值范围
     */
    public static void printIntegerRange() {
        System.out.println("min value of integer is:" + Integer.MIN_VALUE);
        System.out.println("max value of integer is:" + Integer.MAX_VALUE);
    }

    /**
     * 打印short的取值范围
     */
    public static void printShortRange() {
        System.out.println("min value of short is:" + Short.MIN_VALUE);
        System.out.println("max value of short is:" + Short.MAX_VALUE);
    }


    /**
     * 打印long的取值范围
     */
    public static void printLongRange() {
        System.out.println("min value of long is:" + Long.MIN_VALUE);
        System.out.println("max value of long is:" + Long.MAX_VALUE);
    }


    /**
     * 打印byte的取值范围
     */
    public static void printByteRange() {
        System.out.println("min value of byte is:" + Byte.MIN_VALUE);
        System.out.println("max value of byte is:" + Byte.MAX_VALUE);
    }

    /**
     * 打印float的取值范围
     */
    public static void printFloatRange() {
        System.out.println("min value of float is:" + Float.MIN_VALUE);
        System.out.println("max value of float is:" + Float.MAX_VALUE);
    }

    /**
     * 打double的取值范围
     */
    public static void printDoubleRange() {
        System.out.println("min value of double is:" + Double.MIN_VALUE);
        System.out.println("max value of double is:" + Double.MAX_VALUE);
    }

    /**
     * 打char的取值范围
     */
    public static void printCharRange() {
        System.out.println("min value of double is:" + Character.MIN_VALUE);
        System.out.println("max value of double is:" + Double.MAX_VALUE);
    }
}
