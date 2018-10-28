package com.maolin.basic.string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangmaolin
 * @date 2018-10-24 23:07
 * @since 0.0.1
 */
public class StringCode {
    String[] code1 = {"33cd95", "33f12", "8f0cc", "fb519", "f195c", "5abaf"};
    String[] code2 = {"570f0", "c91f0", "d44706", "e67dc1", "16a7b3", "b2fa7"};
    String[] code3 = {"df90a5", "ec68d", "9610ce", "2718c", "2f416", "d3126"};

    @Test
    public void test(){
        Set<String> code = new HashSet<>();

        for (String c1 : code1) {
            for (String c2 : code2) {
                for (String c3 : code3) {
                    String call = c1+c2+c3;
                    code.add(call);
                }
            }
        }
        code.forEach(System.out::println);

    }

}
