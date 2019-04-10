package com.maolin.trycatch;

import org.junit.Test;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-03-21 17:29
 */
public class TryCatchTest {

    @Test
    public void test1() {
        boolean b = showReturn();
        System.out.println(b);

        boolean a = showReturn2();
        System.out.println(a);
    }

    private boolean showReturn() {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return false;
    }

    private boolean showReturn2() {
        boolean re = true;
        try {
            return re;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            re = false;
        }
        return false;
    }
}
