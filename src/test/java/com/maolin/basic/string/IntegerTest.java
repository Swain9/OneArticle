package com.maolin.basic.string;

import org.junit.Test;

public class IntegerTest {

    //expected = NumberFormatException.class
    @Test()
    public void testValueOf() {
        String s = "你好";
        Integer value = Integer.valueOf(s);
        System.out.println(value.intValue());
    }

    @Test
    public void testParseInt() {
        String a = "222 ";
        Integer integer = Integer.valueOf(a);
        System.out.println(integer);

        String s = "你好";
        int i = Integer.parseInt(s);
        System.out.println(i);
    }

}
