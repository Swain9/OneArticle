package com.maolin.staticinit;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-01-30 18:47
 */
public class StaticInit {
    private static int i = 0;
    static {
        print();
    }

    public static void print() {
        System.out.println(++i);
    }
}
