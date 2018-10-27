package com.maolin.basic.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    @Test
    public void testSubString() {
        String s = "Virtual-Ethernet4/0/1.2010";
        String substring = s.substring(0, s.lastIndexOf("."));
        System.out.println(substring);

    }
    @Test
    public void testSubString2(){
        String ss = "nihao zhangmaolin";
        String sub = ss.substring(0, ss.lastIndexOf(" "));
        System.out.println(sub);
    }

    /**
     * 声明a变量
     * 声明b变量等于a变量的地址
     * 改变a变量的地址
     */
    @Test
    public void testChange() {
        String a = "123";
        String b = a;
        a = "456";
        System.out.println(b);
    }

    @Test
    public void testChange2() {
        List<String> list1 = new ArrayList<>();
        list1.add("nihao");
        List<String> list2 = list1;
        list1.add("list2");
        list2.forEach(System.out::println);
    }

}
