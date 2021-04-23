package com.maolin.basic.integer;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @author zhangmaolin
 * @date 2018-10-28 13:57
 * @since 0.0.1
 */
public class IntegerTest {

    @Test
    public void test() {
        int i = 1;
        int b = ++i;
        System.out.println(b);
    }


    @Test
    public void test2() {

        byte a = 127;
        byte b = 1;
        byte c = (byte) (a + b);
        System.out.println(c);
    }

    /**
     * x+y=160000
     * x*a=y*b
     * 160000*a+ay = by
     * 160000a/(b+a) = y
     */
    @Test
    public void test3() {
        BigDecimal bigDecimal = new BigDecimal("160000");
        count(BigDecimal.valueOf(0.03), BigDecimal.valueOf(0.1), bigDecimal);
    }

    private void count(BigDecimal a, BigDecimal b, BigDecimal all) {
        double v = all.multiply(a).divide(b.add(a), 4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(v);
    }

    @Test
    public void test4() {
        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        int color = 0xFF000000;
        color = color | red << 16 | green << 8 | blue;
        System.out.println("red = " + Integer.toHexString(red) + ", green = "
                + Integer.toHexString(green) + ", blue = "
                + Integer.toHexString(blue));
        System.out.println("color in Hex = " + Integer.toHexString(color));

    }
    @Test
    public void test5(){
        int a = 0xfc00;
        int x = 0x13;
        System.out.println(Integer.toString(a));
        System.out.println(x);
        int b = a << 0x13;
        System.out.println(b);
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(536870912));

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toBinaryString(x));
    }

    /**
     *
     */
    @Test
    public void test6(){
        //00000000000000001111110000000000
        int a = 0b1111110000000000;
        System.out.println(Integer.toBinaryString(a).length());
        int b = 0b10011;
        int x = a << b;
        System.out.println(Integer.toHexString(x));
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x).length());
    }

    @Test
    public void test7(){
        int s = 3400;
        long a = s & 0xfffffffffffffc00L;
//        long x = ((a << 19) << 19) << 6;
        long a1 = a << 19;
        long a2 = a1 << 19;
        long x = a2 << 6;
        System.out.println(x);
        System.out.println(Long.toBinaryString(x));
        System.out.println(Long.toHexString(x));
        System.out.println(Long.toBinaryString(x).length());
    }

    @Test
    public void test8(){
        Integer i = 2;
        processInt(i);
        System.out.println(i);
    }

    private void processInt(Integer i) {
        i = 4;
    }
}
