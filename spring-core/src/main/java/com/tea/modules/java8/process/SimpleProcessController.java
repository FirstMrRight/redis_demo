package com.tea.modules.java8.process;

import java.util.Scanner;

/**
 * com.tea.modules.java8.process <br>
 * 实现一个简单的控制流程
 *
 * @author xiejiemin
 * @since 2021/4/2
 */
public class SimpleProcessController {

    public static void main(String[] args) {
        ifAndElse();
        whileStyle();
        doWhileStyle();
        forStyle();
        labelStyle();
        switchStyle();
    }

    private static void switchStyle() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入当前月份");
        int month = in.nextInt();
        switch (month){
            case 1 :
                System.out.println("一月");break;
            case 2 :
                System.out.println("二月");break;
            case 3 :
                System.out.println("三月");break;
            case 4 :
                System.out.println("四月");break;
            case 5 :
                System.out.println("五月");break;
            case 6 :
                System.out.println("六月");break;
            case 7 :
                System.out.println("七月");break;
            case 8 :
                System.out.println("八月");break;
            case 9 :
                System.out.println("九月");break;
            case 10 :
                System.out.println("十月");break;
            case 11 :
                System.out.println("十一月");break;
            case 12 :
                System.out.println("十二月");break;
            default:
                System.out.println("错误的输入");break;
        }
    }

    private static void labelStyle() {
        int i = 0;
        outer: // 此处不允许存在执行语句
        for(; true ;) { // 无限循环
            inner: // 此处不允许存在执行语句
            for(; i < 10; i++) {
                System.out.println("i = " + i);
                if(i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if(i == 3) {
                    System.out.println("break");
                    i++; // 否则 i 永远无法获得自增
                    // 获得自增
                    break;
                }
                if(i == 7) {
                    System.out.println("continue outer");
                    i++;  // 否则 i 永远无法获得自增
                    // 获得自增
                    continue outer;
                }
                if(i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for(int k = 0; k < 5; k++) {
                    if(k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }

    private static void forStyle() {
        int sum = 0;
        int i;
        for (i = 1; i <= 100; i++) {
            if (i == 77) {
                break;
            }
            sum += i;
        }
        System.out.println("1累计到76的结果:" + sum + "  i:" + i);
    }

    private static void doWhileStyle() {
        int i = 1;
        int sum = 0;
        do {
            sum += i;
            i++;
        } while (i <= 100);
        System.out.println("1累加到100的结果是:" + sum);
    }

    /**
     * 使用while的方式来计算1累加到100
     */
    private static void whileStyle() {
        int i = 1;
        int sum = 0;
        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1累加到100的结果是:" + sum);
    }

    private static void ifAndElse() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个数");
        double userEnterNumber = in.nextDouble();
        if (userEnterNumber > 0) {
            System.out.println("正数");
        } else if (userEnterNumber < 0) {
            System.out.println("负数");
        } else {
            System.out.println("0");
        }
    }
}
