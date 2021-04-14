package com.tea.modules.java8.local.date;

import com.tea.modules.java8.thread.ThreadPoolUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * @author jaymin<br>
 * 讲解SimpleDateFormat的坑，以及如果使用Java8的时间<br>
 * 2020/11/5 23:52
 */
public class LocalDateDemo{

    /**
     * 可以解析比它定义的时间精度大的String,但是小于就会报错
     * @throws Exception
     */
    private static void formatProblem() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "2020-11";
        String dateTime = "2020-11-05 00:00:00";
        Date parseDateTime = simpleDateFormat.parse(dateTime);
        System.out.println(parseDateTime);
        Date parseDate = simpleDateFormat.parse(date);
        System.out.println(parseDate);
    }

    /**
     * SimpleDateFormat线程不安全的问题<br>
     * 造成原因:java.text.DateFormat#calendar 这个类的引用被共享，本身线程不安全
     */
    private static void threadSafeProblem(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ThreadPoolExecutor threadPool = ThreadPoolUtil.getThreadPool();
        AtomicInteger executeCount = new AtomicInteger(0);
        int shutDownCount = 10;
        while (executeCount.get() < shutDownCount) {
            threadPool.execute(() -> {
                String date = "2020-11-06 00:39:00";
                try {
                    Date parse = simpleDateFormat.parse(date);
                    String format = simpleDateFormat.format(parse);
                    System.out.println(Objects.equals(parse, format));
                } catch (ParseException e) {
                    Logger.getGlobal().info("解析日期出错,error:"+e);
                }
            });
            System.out.println("执行次数:"+executeCount.incrementAndGet());
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) throws Exception {
//        threadSafeProblem();

        LocalDate start = LocalDate.of(2020, 10, 1);
        LocalDate end = start.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate startOfYear = start.with(TemporalAdjusters.firstDayOfYear());
        LocalDate endOfYear = start.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(start + "---" + end);
        System.out.println(startOfYear + "---" + endOfYear);

    }
}
