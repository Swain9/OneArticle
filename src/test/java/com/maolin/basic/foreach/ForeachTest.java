package com.maolin.basic.foreach;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-06-19 14:02
 */
public class ForeachTest {



    @Test
    public void test1(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        list2.add("e");
        list2.add("d");
        list2.add("c");
        list2.add("b");
        list2.add("a");

        for (String s1 : list1) {
            for (String s2 : list2) {

                if (s1.equals(s2)) {
                    System.out.println(s1 + "," + s2);
                    break;
                }
                System.out.print(s2);
            }
        }
    }

}
