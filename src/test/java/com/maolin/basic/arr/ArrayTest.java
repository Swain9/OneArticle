package com.maolin.basic.arr;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangmaolin
 * @date 2020-06-04 00:01
 * @since 0.0.1
 */
public class ArrayTest {

    @Test
    public void test() {
        int[] a = new int[]{};
        int length = a.length;

        String[] aaa = new String[5];
        aaa[2] = "你好";
        System.out.println(aaa.length);
        System.out.println(Array.get(aaa, 2));

        Object instance = Array.newInstance(String.class, 10);
        System.out.println(instance instanceof String[]);

        List<String> list = new ArrayList<>();
        list.indexOf("");
        list.size();

        Set<String> set = new HashSet<>();
    }

}
