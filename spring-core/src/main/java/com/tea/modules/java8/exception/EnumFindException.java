package com.tea.modules.java8.exception;


import com.google.common.base.Enums;
import com.tea.modules.enums.WeekEnum;

/**
 * @author jaymin<br>
 *     枚举查找异常:valueOf传入的String在枚举类中找不到
 * 2020/11/5 22:49
 */
public class EnumFindException {
    public static void main(String[] args) {
        WeekEnum mon = WeekEnum.valueOf("MON");
        System.out.println(mon.getWeekDay());
        // error
//        WeekEnum xxx = WeekEnum.valueOf("XXX");
        // 通过自定义方法来解决
        WeekEnum weekEnum = WeekEnum.getEnum("MON");
        WeekEnum guavaEnum = Enums.getIfPresent(WeekEnum.class, "MON").orNull();
        System.out.println(guavaEnum);

    }
}
