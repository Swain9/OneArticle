package com.maolin.javascript.extents;

/**
 * @author zhangmaolin
 * @date 2020-07-01 23:00
 * @since 0.0.1
 */
public class Father {
    private int a;
    private int b;

    public Father() {
    }

    public Father(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void count() {
        System.out.println(a + b);
    }
}
