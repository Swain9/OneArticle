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
    public void test1() {
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

    @Test
    public void test2() {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.putIfAbsent("key1", 1);
        System.out.println(countMap);

        countMap.merge("key1", 1, Integer::sum);
        System.out.println(countMap);

        countMap.merge("key2", 1, Integer::sum);
        System.out.println(countMap);

        Integer test1 = countMap.computeIfPresent("key1", (key, value) -> {
            if (value > 1) {
                return -1;
            }
            return 0;
        });
        Integer test2 = countMap.computeIfPresent("key2", (key, value) -> {
            if (value > 1) {
                return -1;
            }
            return 0;
        });
        Integer test3 = countMap.computeIfPresent("key3", (key, value) -> {
            System.out.println(key + value);
            if (value > 1) {
                return -1;
            }
            return 0;
        });
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }

}
