package com.maolin.basic.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    @Test
    public void testSubString() {
        String s = "Virtual-Ethernet4/0/1.2010";
        String substring = s.substring(0, s.lastIndexOf("."));
        System.out.println(substring);

    }
    @Test
    public void testSubString2(){
        String ss = "nihao zhangmaolin";
        String sub = ss.substring(0, ss.lastIndexOf(" "));
        System.out.println(sub);
    }

    /**
     * 声明a变量
     * 声明b变量等于a变量的地址
     * 改变a变量的地址
     */
    @Test
    public void testChange() {
        String a = "123";
        String b = a;
        a = "456";
        System.out.println(b);
    }

    @Test
    public void testChange2() {
        List<String> list1 = new ArrayList<>();
        list1.add("nihao");
        List<String> list2 = list1;
        list1.add("list2");
        list2.forEach(System.out::println);
    }

    @Test
    public void testEquelt(){
        String a = "#";
        String b = "#";
        System.out.println(a.equals(b));

    }

    @Test
    public void testIndexOf(){
        String s = "===脚本参数不全";
        int i = s.indexOf("===脚本参数不全");
        int j = s.indexOf("脚本参数不全");

        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void testSubPort(){
        String p1 = "gigaethernet1/1/1.99";
        String p2 = "gigaethernet1/2/1";
        String p3 = "port-channel16";
        String p4 = "loopback2";
        String p5 = "gigaethernet 1/1/1.99";

        System.out.println(changePortName(p1));
        System.out.println(changePortName(p2));
        System.out.println(changePortName(p3));
        System.out.println(changePortName(p4));
        System.out.println(changePortName(p5));
    }

    Pattern namePat = Pattern.compile("^(\\S+?)([\\d/.]+)$");
    private String changePortName(String name) {
        Matcher matcher = namePat.matcher(name);
        if (matcher.find()) {
            String portName = matcher.group(1);
            String portNum = matcher.group(2);
            return portName + " " + portNum;
        }
        return "";
    }

    @Test
    public void testEndWith(){
        String name = "广州-A-NRS-NR";
        if (name.endsWith("NR")) {
            System.out.println("以NR结尾");
        }

    }

    @Test
    public void test(){
        String a = "你好，张三";
        String b = "nihao,$NAME$";
        String name = "李四";
        String areal = a.replace("$NAME$", name);
        System.out.println(areal);
        String breal = b.replace("$NAME$", name);
        System.out.println(breal);
    }

    @Test
    public void test2(){
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        for (int i = 0; i < a.size()-1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                boolean flag = false;
                if (i == a.size() - 2) {
                    flag = true;
                }
                System.out.println(flag + ":" + i + "-" + j);
            }

        }
    }

}
