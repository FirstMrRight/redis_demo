package com.tea.modules.java8.abstracts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * com.tea.modules.java8.abstracts <br>
 * 每一个worker最基本的属性
 *
 * @author jaymin
 * @since 2021/6/3
 */
public abstract class BaseWorker {
    /**
     * 起床时间
     */
    protected LocalTime wakeupTime = LocalTime.of(8, 30);

    /**
     * 上班打卡
     */
    protected abstract void clockIn();

    /**
     * 下班打卡
     */
    protected abstract void clockOut();
}
