package com.maolin.basic.string;

import org.junit.Test;

/**
 * @author zhangmaolin
 * @date 2018-10-16 11:21
 * @since 0.0.1
 */
public class MatchTest {

    @Test
    public void testStringMatch() {
        String ip = "8.8.8.8";
        boolean flag1 = ip.matches("\\d+");
        System.out.println("测试结果1：" + flag1);

        boolean flag2 = ip.matches("[\\d.]+");
        System.out.println("测试结果2：" + flag2);

    }

}
