package com.maolin.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-22 11:46
 */
public class ThreadPoolTest {

    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,
            new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(false).build());

    public static void main(String[] args) {
        //executorService.scheduleAtFixedRate()
    }

}
