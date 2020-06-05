package com.maolin.classload;

import org.junit.Test;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2020-05-27 17:34
 */
public class ClassLoadTest {

    @Test
    public void test(){
        System.out.println(ClassLoadTest.class.getClassLoader().getResource("."));
    }

}
