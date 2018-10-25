package com.maolin.basic.pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangmaolin
 * @version 0.0.1
 * @since 2018-08-23 16:31
 */
public class PatternTest {

    @Test
    public void testPattern() {
        String s = "(\\d+)([G|M])";
        Pattern pattern = Pattern.compile(s);
        String test = "1213123G";
        Matcher matcher = pattern.matcher(test);

        if (matcher.find()) {
            String all = matcher.group(0);
            String speed = matcher.group(1);
            String type = matcher.group(2);
            System.out.println(speed + ":" + type);
        }
    }

}
