package com.maolin.basic.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
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
    public void testSubString2() {
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
    public void testEquelt() {
        String a = "#";
        String b = "#";
        System.out.println(a.equals(b));

    }

    @Test
    public void testIndexOf() {
        String s = "===脚本参数不全";
        int i = s.indexOf("===脚本参数不全");
        int j = s.indexOf("脚本参数不全");

        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void testSubPort() {
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
    public void testEndWith() {
        String name = "广州-A-NRS-NR";
        if (name.endsWith("NR")) {
            System.out.println("以NR结尾");
        }

    }

    @Test
    public void test() {
        String a = "你好，张三";
        String b = "nihao,$NAME$";
        String name = "李四";
        String areal = a.replace("$NAME$", name);
        System.out.println(areal);
        String breal = b.replace("$NAME$", name);
        System.out.println(breal);
    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                boolean flag = false;
                if (i == a.size() - 2) {
                    flag = true;
                }
                System.out.println(flag + ":" + i + "-" + j);
            }

        }
    }

    @Test
    public void test3() {
        String a = "1.1.1.1";
        String b = "255.255.255.255";
        System.out.println(strAppendStr(a, 16) + ":");
        System.out.println(strAppendStr(b, 16) + ":");
    }

    /**
     * https://segmentfault.com/a/1190000019350486?utm_source=tag-newest
     *
     * @param str
     * @return
     */
    public static String strAppendStr(String str, int length) {
        String format = "%-" + length + "s";
//        return String.format("%-12s", str);
        return String.format(format, str);
    }

    /**
     * 设置字符长度  不足者 右侧添加 指定字符
     *
     * @param str1  元字符
     * @param lenth 指定长度
     * @param st2   指定字符
     * @return
     * @throws Exception
     */
    public static String strAppendStr(String str1, int lenth, String st2) throws Exception {
        StringBuilder strb1 = new StringBuilder(str1);
        lenth = lenth - getChineseLength(str1, "utf-8");
        while (lenth >= 0) {
            lenth--;
            strb1.append(st2);
        }
        return strb1.toString();
    }

    /**
     * 计算中文字符长度
     *
     * @param name      字符
     * @param endcoding 编码方式
     * @return
     * @throws Exception
     */
    public static int getChineseLength(String name, String endcoding) throws Exception {
        int len = 0; //定义返回的字符串长度
        int j = 0;
        //按照指定编码得到byte[]
        byte[] b_name = name.getBytes(endcoding);
        do {
            short tmpst = (short) (b_name[j] & 0xF0);
            if (tmpst >= 0xB0) {
                if (tmpst < 0xC0) {
                    j += 2;
                    len += 2;
                } else if ((tmpst == 0xC0) || (tmpst == 0xD0)) {
                    j += 2;
                    len += 2;
                } else if (tmpst == 0xE0) {
                    j += 3;
                    len += 2;
                } else {
                    short tmpst0 = (short) (((short) b_name[j]) & 0x0F);
                    if (tmpst0 == 0) {
                        j += 4;
                        len += 2;
                    } else if (tmpst0 < 12) {
                        j += 5;
                        len += 2;
                    } else {
                        j += 6;
                        len += 2;
                    }
                }
            } else {
                j += 1;
                len += 1;
            }
        } while (j <= b_name.length - 1);
        return len;
    }

    @Test
    public void testName(){
        String name = "文若";
        byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes);
    }

    @Test
    public void testSub(){
        String url = "192.168.110.10:9900,";
        String[] split = StringUtils.split(url, ",");
        System.out.println(split);
    }
    @Test
    public void testSub2(){
        String s = "10.24.140.31,10.24.140.53,10.24.140.59,";
        String[] split = StringUtils.split(s, ",");
        System.out.println(split.length);
    }
}
