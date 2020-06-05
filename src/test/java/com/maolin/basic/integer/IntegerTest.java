package com.maolin.basic.integer;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangmaolin
 * @date 2018-10-28 13:57
 * @since 0.0.1
 */
public class IntegerTest {

    @Test
    public void test(){
        int i = 1;
        int b = ++i;
        System.out.println(b);

    }


    @Test
    public void test2(){

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
    public void test3(){
        BigDecimal bigDecimal = new BigDecimal("160000");
        count(BigDecimal.valueOf(0.03), BigDecimal.valueOf(0.1), bigDecimal);
    }

    private void count(BigDecimal a, BigDecimal b, BigDecimal all){
        double v = all.multiply(a).divide(b.add(a), 4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(v);
    }
}
