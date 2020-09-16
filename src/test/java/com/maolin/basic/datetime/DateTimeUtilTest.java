package com.maolin.basic.datetime;

import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}
