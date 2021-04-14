package com.tea.modules.java8.local.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.xjm.java8.local.date
 *
 * @author xiejiemin
 * @create 2020/12/10
 */
public class localdatetimedemo {
    public static String getStartOrEndDayOfWeek(LocalDate today, Boolean isFirst){
        LocalDate resDate = LocalDate.now();
        if (today == null) {
            today = resDate;
        }
        DayOfWeek week = today.getDayOfWeek();
        int value = week.getValue();
        if (isFirst) {
            resDate = today.minusDays(value - 1);
        } else {
            resDate = today.plusDays(7 - value);
        }
        return resDate.toString();
    }

    public static Integer[] getMonthArray(LocalDate localDate) {
        LocalDate startDate = localDate.minusMonths(4L);
        Integer period = ((int) ChronoUnit.MONTHS.between(startDate, localDate));
        List<Integer> monthArray = new ArrayList<>(period);
        int index = startDate.getMonthValue();
        while (monthArray.size() < period + 1) {
            monthArray.add(index);
            index++;
        }
        return monthArray.toArray(new Integer[monthArray.size()]);
    }

    public static void main(String[] args) {
        Integer[] monthArray = getMonthArray(LocalDate.now());
        Arrays.stream(monthArray).forEach(System.out::println);
    }
}
