package com.tea.modules.localdate;


import org.springframework.util.CollectionUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;

/**
 *
 *
 * @author xiejiemin
 * @create 2020/8/14
 */
public class LocalDateParserDelegate {

    /**
     * 获取该日期的开始时间
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime getStartTimeByDate(LocalDate localDate) {
        LocalDateTime startOfDay = localDate.atStartOfDay();
        return startOfDay;
    }

    /**
     * 获取该日期的结束时间
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime getEndTimeByDate(LocalDate localDate) {
        LocalDateTime endTime = localDate.atTime(LocalTime.MAX);
        return endTime;
    }

    /**
     * 根据日期返回当月的开始时间
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime getStartTimeOfMonthByDate(LocalDate localDate) {
        LocalDate firtDateOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        return firtDateOfMonth.atTime(LocalTime.MIN);
    }

    /**
     * 获取当月最初的日期
     * @param localDate
     * @return
     */
    public static LocalDate getStartDateOfMonthByDate(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 根据日期返回当月的结束时间
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime getEndTimeOfMonthByDate(LocalDate localDate) {
        LocalDate endDateOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime endDateTimeOfMonth = endDateOfMonth.atTime(LocalTime.MAX);
        return endDateTimeOfMonth;
    }

    /**
     * 获取当月最后的日期
     * @param localDate
     * @return
     */
    public static LocalDate getEndDateOfMonthByDate(LocalDate localDate){
        LocalDate endDateOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        return endDateOfMonth;
    }


    /**
     * 将Date转化成LocalDate
     *
     * @param date
     * @return
     */
    private static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    /**
     * 将时间戳转化成LocalDate
     *
     * @param time
     * @return
     */
    public static LocalDate longToLocalDate(Long time) {
        if (Objects.isNull(time)) {
            return null;
        }
        return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDate();
    }


    /**
     * 将时间戳转化成LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime longToLocalDateTime(Long timestamp) {
        if (Objects.isNull(timestamp)) {
            return null;
        }
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将字符串转成LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate stringToLocalDate(String date) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("日期转化错误，请查看日期格式是否正确!");
        }
        return localDate;
    }

    /**
     * 根据传入的时间戳字符串，转化成正确的日期格式
     *
     * @param timestamp
     * @return
     */
    public static String getLocalDateTimeText(String timestamp) {
        Long instant = Long.valueOf(timestamp);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(instant), ZoneId.systemDefault()));
    }

    /**
     * 跟进开始日期和结束日期返回日期数组
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static LocalDate[] getLocalDateArrayByTimeStamp(LocalDate startDate, LocalDate endDate) {
        Integer period = ((int) ChronoUnit.DAYS.between(startDate, endDate));
        ArrayList<LocalDate> localDateList = new ArrayList<>(period);
        int index = 0;
        while (localDateList.size() < period + 1) {
            LocalDate localDate = startDate.plusDays(index);
            localDateList.add(localDate);
            index++;
        }
        return localDateList.toArray(new LocalDate[localDateList.size()]);
    }

    /**
     * 根据当前时间返回最近的 5个月
     *
     * @param localDate 当前时间
     * @return 月份数组.例如:现在12月，返回[8,9,10,11,12]
     */
    public static Integer[] getMonthArray(LocalDate startDate, LocalDate endDate) {
        Integer period = ((int) ChronoUnit.MONTHS.between(startDate, endDate));
        List<Integer> monthArray = new ArrayList<>(period);
        int index = startDate.getMonthValue();
        while (monthArray.size() < period + 1) {
            int month = (index) % 12;
            if (month == 0) {
                month = 12;
            }
            monthArray.add(month);
            index++;
        }
        return monthArray.toArray(new Integer[monthArray.size()]);
    }

    /**
     * 根据开始时间和结束时间返回特定格式的日期数组
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 开始时间:11-09,结束时间:12-10,返回
     * [
     * "11.09-11.15",
     * "11.16-11.22",
     * "11.23-11.29",
     * "11.30-12.06",
     * "12.07-12.13"
     * ]
     */
    public static List<String> getDateListByStartAndEnd(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> weekDateList = LocalDateParserDelegate.getWeekDateList(startDate, endDate);
        List<String> key = new ArrayList<>();
        weekDateList.forEach(date -> key.add(LocalDateParserDelegate.getStartAndEndOfWeekByDate(date)));
        return key;
    }

    /**
     * 判断日期与传入的MySQL字符串是否是同一周
     * @param localDate 日期 例如: 2020-12-15
     * @param weekOfYear MySQL的按周函数返回的格式,例如:"2020-50"
     * @return boolean
     */
    public static boolean isSameWeek(LocalDate localDate,String weekOfYear){
        int index = weekOfYear.lastIndexOf("-");
        Integer weekOfYearFromMySQL = Integer.valueOf(weekOfYear.substring(index+1));
        Integer weekIndexOfYear = getWeekIndexOfYear(localDate);
        return Objects.equals(weekOfYearFromMySQL,weekIndexOfYear);
    }

    /**
     * 获取当前日期所在周的开始和结束时间
     * @param localDate
     * @return
     */
    public static String getStartAndEndOfWeekByDate(LocalDate localDate) {
        StringBuilder stringBuilder = new StringBuilder();
        String start = getStartOrEndDayOfWeek(localDate, true);
        String end = getStartOrEndDayOfWeek(localDate, false);
        return stringBuilder.append(start).append("-").append(end).toString();
    }

    /**
     * 根据传入的开始时间和结束时间，返回在此区间的周日期
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<LocalDate> getWeekDateList(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> result = new ArrayList<>();
        result.add(startDate);
        startDate = startDate.plusWeeks(1);
        while (startDate.isBefore(endDate)) {
            result.add(startDate);
            startDate = startDate.plusWeeks(1);
        }
        return result;
    }

    /**
     * 获取一周的开始获取结束时间字符串，具体格式可以在pattern进行指定
     * @param localDate
     * @param isFirst
     * @return
     */
    private static String getStartOrEndDayOfWeek(LocalDate localDate, Boolean isFirst) {
        LocalDate resDate = LocalDate.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM.dd");
        if (Objects.isNull(localDate)) {
            localDate = resDate;
        }
        DayOfWeek week = localDate.getDayOfWeek();
        int value = week.getValue();
        if (isFirst) {
            resDate = localDate.minusDays(value - 1);
        } else {
            resDate = localDate.plusDays(7 - value);
        }
        return resDate.format(pattern);
    }

    /**
     * 获取一周的结束时间
     * @param localDate
     * @return
     */
    public static LocalDate getEndDayOfWeek(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return localDate;
        }
        DayOfWeek week = localDate.getDayOfWeek();
        int value = week.getValue();
        return localDate.plusDays(7 - value);
    }

    /**
     * 获取一周的开始时间
     * @param localDate
     * @return
     */
    public static LocalDate getStartDayOfWeek(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return localDate;
        }
        DayOfWeek week = localDate.getDayOfWeek();
        int value = week.getValue();
        return localDate.minusDays(value - 1);
    }

    /**
     * 获取当前日期是一年中的第几周
     * @param localDate
     * @return
     */
    private static Integer getWeekIndexOfYear(LocalDate localDate){
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,4);
        return localDate.get(weekFields.weekOfWeekBasedYear());
    }

    /**
     * 获取分钟的开始时间
     * @return
     */
    public static Long getStartTimeOfCurrentMinute(){
        return LocalDateTime.now().withSecond(0).withNano(0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    /**
     * 获取小时的开始时间
     * @return
     */
    public static Long getStartTimeOfCurrentHour(){
        return LocalDateTime.now().withMinute(0).withSecond(0).withNano(0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Map<String,Object> getWeekResultMap(List<Map<String, Object>> resultMapFromMySQL, LocalDate startDate, LocalDate endDate){
        List<LocalDate> weekDateList = getWeekDateList(startDate, endDate);
        List<String> key = new ArrayList<>();
        weekDateList.forEach(date->key.add(LocalDateParserDelegate.getStartAndEndOfWeekByDate(date)));
        int[] value = new int[weekDateList.size()];
        Map<String, Object> resultMap = new HashMap<>();
        if (CollectionUtils.isEmpty(resultMapFromMySQL)) {
            resultMap.put("dateArray", key);
            resultMap.put("countArray", value);
        }
        resultMapFromMySQL.forEach(map -> {
            String weekStamp = map.get("weekStamp").toString();
            for (int i = 0; i < weekDateList.size(); i++) {
                LocalDate localDate = weekDateList.get(i);
                if (LocalDateParserDelegate.isSameWeek(localDate, weekStamp)) {
                    int count = Integer.parseInt(map.get("count").toString());
                    value[i] = count;
                }
            }
        });
        resultMap.put("dateArray", key);
        resultMap.put("countArray", value);
        return resultMap;
    }

    public static Map<String, Object> getMonthResultMap(List<Map<String, Object>> resultMapFromMySQL, LocalDate startDate, LocalDate endDate) {
        Integer[] monthArray = getMonthArray(startDate, endDate);
        int[] value = new int[monthArray.length];
        Map<String, Object> resultMap = new HashMap<>();
        if (CollectionUtils.isEmpty(resultMapFromMySQL)) {
            resultMap.put("dateArray", monthArray);
            resultMap.put("countArray", value);
        }
        resultMapFromMySQL.forEach(map -> {
            String weekStamp = map.get("monthStamp").toString();
            Integer month = Integer.valueOf(weekStamp.substring(weekStamp.lastIndexOf("-") + 1));
            int count = Integer.parseInt(map.get("count").toString());
            for (int i = 0; i < monthArray.length; i++) {
                if (Objects.equals(month, monthArray[i])) {
                    value[i] = count;
                }
            }
        });
        resultMap.put("dateArray", monthArray);
        resultMap.put("countArray", value);
        return resultMap;
    }

    public static LocalDate parseDateToLocalDate(Date date){
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public static LocalDateTime parseDateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime;
    }
}
