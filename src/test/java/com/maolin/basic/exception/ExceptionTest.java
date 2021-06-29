package com.maolin.basic.exception;

import org.junit.Test;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2021-06-29 13:55
 */
public class ExceptionTest {
    @Test
    public void test1(){
        try {
            throw new RuntimeException("捕获自定义异常");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
