package com.maolin.thread;

import org.junit.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2020-09-24 14:46
 */
public class ThreadSafeTest {

    private Set<String> set = new ConcurrentSkipListSet<>();

    @Test
    public void test() {
        Runnable r1 = () -> {
            String s = "a";
            if (set.contains(s)) {
                return;
            } else {
                set.add(s);
            }
        };
        Runnable r2 = () -> {
            String s = "a";
            if (set.contains(s)) {
                return;
            } else {
                set.add(s);
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();

        System.out.println("");
    }
}
