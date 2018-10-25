package com.maolin.basic.set;

import com.maolin.generic.Demo;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangmaolin
 * @date 2018-09-14 10:30
 * @since 0.0.1
 */
public class HashSetTest {
    /**
     * https://blog.csdn.net/weixin_39241397/article/details/79687789
     */
    @Test
    public void testSetToString(){
        Set<String> s = new HashSet<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        String s1 = s.toString();
        System.out.println(s1);

        if (s.contains("a")) {
            System.out.println("有a");
        }
    }

    @Test
    public void testSetClone(){
        Set<Demo> list1 = new HashSet<>();
        Demo demo1 = new Demo();
        demo1.setName("张三");
        Demo demo2 = new Demo();
        demo2.setName("李四");
        list1.add(demo1);
        list1.add(demo2);

        Set<Demo> list2 = new HashSet<>(list1);
        list2.forEach(demo -> {
            if (demo.getName().equals("张三")) {
                demo.setName("张帅");
            }
        });

        list1.forEach(System.out::println);
    }
    @Test
    public void testSetCloneString(){
        Set<String> list1 = new HashSet<>();
        list1.add("张三");
        list1.add("李四");

        Set<String> list2 = new HashSet<>(list1);
        list2.removeIf(next -> next.equals("张三"));

        list1.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
}
