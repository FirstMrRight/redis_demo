package com.tea.modules.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jaymin
 * 2020/11/5 22:41
 */
@Getter
public enum WeekEnum {
    MON("Monday", 1),
    TUE("Tuesday", 2),
    WED("Wednesday", 3),
    THU("Thursday", 4),
    FRI("Friday", 5),
    SAT("Saturday", 6),
    SUN("Sunday", 7);

    /**
     * 枚举map
     */
    private static final Map<String, WeekEnum> weekEnums = new HashMap<>(WeekEnum.values().length);

    private String weekDay;

    private Integer index;

    /**
     * 通过静态代码块来让枚举初始化到map中
     */
    static {
        System.out.println("验证初始化");
        weekEnums.values().forEach(weekEnum -> weekEnums.put(weekEnum.name(), weekEnum));
    }

    WeekEnum(String weekDay, Integer index) {
        this.weekDay = weekDay;
        this.index = index;
    }

    /**
     * 通过枚举名称找到对应的枚举
     *
     * @param weekDay
     * @return
     */
    public static WeekEnum findWeekEnumByWeekDay(String weekDay) {
        WeekEnum resultEnum = Arrays.stream(WeekEnum.values())
                .filter(weekEnum -> Objects.equals(weekDay, weekEnum.name()))
                .findFirst()
                .orElse(null);
        return resultEnum;
    }

    public static WeekEnum getEnum(String weekDay) {
        return weekEnums.get(weekDay);
    }


}
