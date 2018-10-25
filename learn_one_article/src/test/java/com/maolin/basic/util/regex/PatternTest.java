package com.maolin.basic.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */
public class PatternTest {

    @Test
    public void testMatch() {
        String s = "id:1;name:zhangmaolin;";
        String reg = "id:(?<id>\\d+);name:(?<name>\\D+);";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(s);
        //matches：全部匹配
        if (matcher.matches()) {
            String id = matcher.group("id");
            String name = matcher.group("name");
            System.out.printf("id:%s;name:%s", id, name);
        }
    }

    @Test
    public void testMatcher() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        //find：部分匹配
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }


}
