package com.maolin.basic.string;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2021-01-12 09:40
 */
public class Demo extends Thread  {

    public void run() {

        System.out.println("In run");

        yield();

        System.out.println("Leaving run");

    }

    public static void main(String []argv) {

        (new Demo()).start();

    }

}