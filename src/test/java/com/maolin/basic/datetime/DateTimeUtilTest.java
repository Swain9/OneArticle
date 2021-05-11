package com.maolin.basic.datetime;

import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2020-09-16 09:30
 */
public class DateTimeUtilTest {

    @Test
    public void test() {
        LocalTime begin = LocalTime.of(18, 0);
        LocalTime end = LocalTime.of(23, 59);
        LocalDateTime now = LocalDateTime.now();
        boolean before = now.isBefore(LocalDateTime.of(LocalDate.now(), begin));
        boolean after = now.isAfter(LocalDateTime.of(LocalDate.now(), end));
        System.out.println(before);
        System.out.println(after);
    }

    @Test
    public void test2() {

        int size = 500;
        // 18点-24点， 共7天
        int totalTime = 6 * 60 * 7;
        // 平均到每个任务可用的时间间隔
        int intervals = totalTime / size;
        // 从星期一
        int weekDay = 1;
        LocalTime begin = LocalTime.of(18, 0);
        // 时间表达式：0 0 0 ? * 1
        String cron = "0 {0} {1} ? * {2}";
        int reset = 0;
        for (int i = 0; i < size; i++) {
            LocalTime nextTime = begin.plusMinutes(intervals * reset);
            if (nextTime.getHour() < 18) {
                nextTime = begin;
                weekDay++;
                reset = 0;
            }
            reset++;
            System.out.println(MessageFormat.format(cron, nextTime.getMinute(), nextTime.getHour(), weekDay));

        }
    }

    @Test
    public void test3(){
        LocalDateTime time1 = LocalDateTime.parse("2021-04-15 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime time2 = LocalDateTime.parse("2021-04-16 00:00:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDate time3 = LocalDate.parse("2021-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate time4 = LocalDate.parse("2021-04-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date date1 = Date.from(time1.atZone(ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from(time2.atZone(ZoneId.systemDefault()).toInstant());

        long l = (date1.getTime() - date2.getTime()) / 1000 / 3600 / 24;
        System.out.println(l);

        long between = ChronoUnit.DAYS.between(time1, time2);
        System.out.println(between);

        long between2 = ChronoUnit.DAYS.between(time3, time4);
        System.out.println(between2);

        int days = Period.between(time1.toLocalDate(), time2.toLocalDate()).getDays();
        System.out.println(days);

        time3.getDayOfYear();
    }
}
