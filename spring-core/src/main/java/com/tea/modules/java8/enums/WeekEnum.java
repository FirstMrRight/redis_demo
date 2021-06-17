package com.tea.modules.java8.enums;

/**
 * com.tea.modules.java8.enums <br>
 * 使用枚举类来表示星期
 *
 * @author jaymin
 * @since 2021/6/9
 */
public enum WeekEnum implements EnumInfoService{
    /**
     * 周一
     */
    MON,
    /**
     * 周二
     */
    TUE,
    /**
     * 周三
     */
    WEB,
    /**
     * 周四
     */
    THUR,
    /**
     * 周五
     */
    FRI,
    /**
     * 周六
     */
    SAT,
    /**
     * 周日
     */
    SUN;

    @Override
    public void printName() {
        System.out.println(this.name());
    }
}
