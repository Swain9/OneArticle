package com.maolin.basic.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-19 14:50
 */
public class MapTest {

    @Test
    public void test1(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");

        String s = map.get(1);
        System.out.println(s);

        String s1 = "aa";
        boolean equals = s1.equals(null);

        Map<String, Object> ss = new HashMap<>();
        ss.put("a", null);
        String a = String.valueOf(ss.get("a"));
        System.out.println(a);
        Object c = null;
        String s2 = String.valueOf(c);

        String b = String.valueOf(null);
        System.out.println(b);
    }
}
