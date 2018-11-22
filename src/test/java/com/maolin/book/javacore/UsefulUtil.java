package com.maolin.book.javacore;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangmaolin
 * @date 2018-11-17 18:59
 * @since 0.0.1
 */
public class UsefulUtil {

    public void print(String formatStr, Object... params) {
        String format = MessageFormat.format(formatStr, params);
        System.out.println(format);
    }

    public void printf(String formatStr, Object... params) {
        System.out.printf(formatStr, params);
        print("");
    }

    public void print(Object object) {
        System.out.println(object);
    }

    public int randomInt(int min, int max) {
        if (max - min < 0) return 0;
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public int randomInt(int max) {
        return randomInt(0, max);
    }

    public List<Integer> randomList(int min, int max) {
        int length = max - min;
        if (length < 0) return Collections.emptyList();

        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        for (int i = min; i <= max; i++) {
            Integer a = list.get(randomInt(0, length));
            Integer b = list.get(randomInt(0, length));
            list.remove(a);
            list.remove(b);
            list.add(a);
            list.add(b);
        }
        return list;
    }

    /**
     * min:0
     * max:9
     * length:9-0+1 = 10
     *
     * @param min 最小数
     * @param max 最大数
     * @return 随机数组
     */
    public int[] randomInts(int min, int max) {
        int length = max - min + 1;
        if (length < 1) return new int[0];

        int[] n = new int[length];
        for (int i = 0; i < length; i++) {
            n[i] = min + i;
        }

        int[] k = new int[length];
        for (int i = 0; i < n.length; i++) {
            int r = randomInt(length - 1);
            k[i] = n[r];
            n[r] = n[length - 1];
            length--;
        }
        return k;
    }
}
