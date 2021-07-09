package com.tea.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * com.tea.test
 *
 * @author jaymin
 * @since 2021/7/8
 */
public class IDEADemo {
    public static void main(String[] args) {
        printYesterday();
        printYesterdayEndTime();
    }

    /**
     * 昨天的日期
     */
    private static void printYesterday() {
        LocalDate yesterday = getYesterday();
        System.out.println(yesterday);
    }

    /**
     * 昨天最后的日期
     */
    private static void printYesterdayEndTime(){
        LocalDate yesterday = getYesterday();
        LocalDateTime yesterdayEndTime = yesterday.atTime(LocalTime.MAX);
        System.out.println(yesterdayEndTime);
    }

    private static LocalDate getYesterday() {
        LocalDate now = LocalDate.now();
        return now.plusDays(-1);
    }
}
