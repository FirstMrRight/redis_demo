package com.tea.modules.java8.local.date;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

/**
 * com.xjm.java8.local.date
 *
 * @author xiejiemin
 * @create 2020/12/21
 */
@Slf4j
public class LocalDateWeekDemo {
    public static LocalDate getStartDayOfWeek(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return localDate;
        }
        DayOfWeek week = localDate.getDayOfWeek();
        int value = week.getValue();
        return localDate.minusDays(value - 1);
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now().minusDays(1L);
        log.info("now:{}",now);
        LocalDate localDate = now.minusWeeks(4L);
        log.info("move:{}",localDate);
        LocalDate startDayOfWeek = getStartDayOfWeek(localDate);
        log.info("start:{}",startDayOfWeek);
    }
}
