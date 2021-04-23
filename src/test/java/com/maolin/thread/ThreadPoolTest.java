package com.maolin.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
//
//    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,
//            new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(false).build());

    public static void main(String[] args) {
        //executorService.scheduleAtFixedRate()
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() throws Exception {
        int poolSize = 5;
        ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);

        List<Callable<String>> list = new ArrayList<>();

        Callable<String> a = () -> {
            Thread.sleep(10000);
            return "a";
        };
        Callable<String> b = () -> {
            Thread.sleep(10000);
            return "b";
        };
        Callable<String> c = () -> {
            Thread.sleep(10000);
            return "c";
        };
        Callable<String> d = () -> {
            Thread.sleep(10000);
            return "d";
        };
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        List<Future<String>> futures ;
        try {
            futures= threadPool.invokeAll(list);

        } catch (Exception e) {
            throw e;
        }finally {
            threadPool.shutdownNow();
        }
        List<String> results = new ArrayList<>();
        if(futures != null){
            for(Future<String> future : futures){
                if(future != null){

                    String result = future.get();
                    if(result != null){
                        results.add(result);
                    }
                }
            }
        }
        System.out.println(results);
    }
}
