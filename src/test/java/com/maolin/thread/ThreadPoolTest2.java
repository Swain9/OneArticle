package com.maolin.thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2021-03-19 18:07
 */
public class ThreadPoolTest2 {
    // 固定大小的线程池，同时只能接受5个任务
    static ExecutorService mExecutor = Executors.newFixedThreadPool(5);

    /**
     * 计算价格的任务
     *
     * @author hadoop
     */
    private class QuoteTask implements Callable<BigDecimal> {
        public final double price;
        public final int num;

        public QuoteTask(double price, int num) {
            this.price = price;
            this.num = num;
        }

        @Override
        public BigDecimal call() throws Exception {
            Random r = new Random();
            long time = (r.nextInt(10) + 1) * 1000;
            Thread.sleep(time);

            BigDecimal d = BigDecimal.valueOf(price * num).setScale(2);
            System.out.println("耗时：" + time / 1000 + "s,单价是：" + price + ",人数是："
                    + num + "，总额是：" + d);
            return d;
        }
    }

    /**
     * 在预定时间内请求获得旅游报价信息
     *
     * @return
     */
    public void getRankedTravelQuotes() throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<QuoteTask>();
        // 模拟10个计算旅游报价的任务
        for (int i = 1; i <= 20; i++) {
            tasks.add(new QuoteTask(200, i));
        }

        /**
         * 使用invokeAll方法批量提交限时任务任务 预期15s所有任务都执行完,没有执行完的任务会自动取消
         *
         */
        List<Future<BigDecimal>> futures;
        try {
            futures = mExecutor.invokeAll(tasks, 10, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw e;
        }finally {
            mExecutor.shutdownNow();
        }
        // 报价合计集合
        List<BigDecimal> totalPriceList = new ArrayList<BigDecimal>();

        Iterator<QuoteTask> taskIter = tasks.iterator();

        for (Future<BigDecimal> future : futures) {
            QuoteTask task = taskIter.next();
            try {
                totalPriceList.add(future.get());
            } catch (ExecutionException e) {
                // 返回计算失败的原因
                // totalPriceList.add(task.getFailureQuote(e.getCause()));
                totalPriceList.add(BigDecimal.valueOf(-1));
                System.out.println("任务执行异常,单价是" + task.price + "，人数是：" + task.num);
                e.printStackTrace();
            } catch (CancellationException e) {
                // totalPriceList.add(task.getTimeoutQuote(e));
                totalPriceList.add(BigDecimal.ZERO);
                System.out.println("任务超时，取消计算,单价是" + task.price + "，人数是：" + task.num);
                e.printStackTrace();
            }
        }
        for (BigDecimal bigDecimal : totalPriceList) {
            System.out.println(bigDecimal);
        }
        mExecutor.shutdown();
    }


    public static void main(String[] args) {
        try {
            ThreadPoolTest2 it = new ThreadPoolTest2();
            it.getRankedTravelQuotes();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
