package com.maolin.book.javacore;

import java.text.MessageFormat;

/**
 * @author zhangmaolin
 * @date 2018-11-17 18:59
 * @since 0.0.1
 */
public class PrintUtil {

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
}
