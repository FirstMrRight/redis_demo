package com.tea.modules.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * com.xjm.spring.localdate
 * Java8的日期包装器
 * @author xiejiemin
 * @create 2021/1/6
 */
public class LocalDateHolder {

    private LocalDate localDate;

    private LocalDateTime localDateTime;

    public static <T> LocalDateHolder of(T date) {
        return new LocalDateHolder(date);
    }

    public <T> LocalDateHolder(T date) {
        if (date instanceof Long) {
            Long timestamp = (Long) date;
            localDate = LocalDateParserDelegate.longToLocalDate(timestamp);
            localDateTime = LocalDateParserDelegate.longToLocalDateTime(timestamp);
        } else if (date instanceof Date) {
            Date time = (Date) date;
            localDate = LocalDateParserDelegate.parseDateToLocalDate(time);
            localDateTime = LocalDateParserDelegate.parseDateToLocalDateTime(time);
        }else if(date instanceof LocalDate){
            LocalDate localDate = (LocalDate) date;
            this.localDate = localDate;
            this.localDateTime = LocalDateParserDelegate.getStartTimeByDate(localDate);
        }
    }
}
