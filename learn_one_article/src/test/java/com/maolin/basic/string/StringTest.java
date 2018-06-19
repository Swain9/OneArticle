package com.maolin.basic.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void testSubString(){
        String s = "Virtual-Ethernet4/0/1.2010";
        String substring = s.substring(0, s.lastIndexOf("."));
        System.out.println(substring);

    }
}
