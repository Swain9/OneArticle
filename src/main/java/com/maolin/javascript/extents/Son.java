package com.maolin.javascript.extents;

/**
 * @author zhangmaolin
 * @date 2020-07-01 23:08
 * @since 0.0.1
 */
public class Son extends Father {
    private int a;
    private int b;

    public Son(int a, int b) {
        //super(a, b);
        this.a = a;
        this.b = b;
    }

    public void plus() {
        System.out.println(a - b);
    }
}
