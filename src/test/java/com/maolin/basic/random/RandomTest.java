package com.maolin.basic.random;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2020-08-26 10:05
 */
public class RandomTest {

    @Test
    public void test(){

        for (int i = 0; i < 100; i++) {
            int j = RandomUtils.nextInt(0, 2);
            System.out.println(j);
        }
    }

}
