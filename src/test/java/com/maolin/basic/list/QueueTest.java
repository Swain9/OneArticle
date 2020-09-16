package com.maolin.basic.list;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2020-07-21 16:58
 */
public class QueueTest {

    @Test
    public void test(){
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            queue.add(i + "");
        }
        System.out.println(queue);
        String poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue);
    }
}
