package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.UsefulUtil;
import org.junit.Test;

/**
 * 3.6 字符串
 *
 * @author zhangmaolin
 * @date 2018-11-18 13:10
 * @since 0.0.1
 */
public class StringCode extends UsefulUtil {

    /**
     * java字符串就是Unicode字符串序列，例如串”Java\u2122“，由5个Unicode字符：J，a，v，a和™
     * java没有内置的字符串类型，而是在标准Java类库中提供了一个预定义类，即String。
     * 每一个用双引号括起来的字符串都是一个String类的一个实例
     */
    @Test
    public void test0() {
        String e = "java\u2122";
        print(e);
    }

    /**
     * 3.6.1 子串
     */
    @Test
    public void test1() {
        String greeting = "Hello";
        int beginIndex = 0; //要截取的起始下标位置，并包含该位置
        int endIndex = 3;  //要截取的结束下标位置，不包含该位置
        String substring = greeting.substring(beginIndex, endIndex);
        print("{0}截取下标从{1}到{2}的字符串为{3}，截取长度为{4}", greeting, beginIndex, endIndex, substring, endIndex - beginIndex); //Hel
    }

    /**
     * 3.6.2 拼接
     */
    @Test
    public void test2() {
        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;

        int age = 13;
        String rating = "PG" + age; //当字符串与非字符串拼接时，后者会转为字符串，任何一个java对象都阔以转成字符串

        String all = String.join(" / ", "S", "M", "L", "XL");//拼接所有字符串并用一个定界符分隔
        print(all);
    }

    /**
     * 3.6.3 不可变字符串
     */
    @Test
    public void test3() {
        //String类没有提供用于【修改】字符串的方法。所以Java文档中，将String类对象称为【不可变字符串】
        //当声明一个变量【greeting】的字符串为【Hello】时，字符串【Hello】永远无法改变，但是可以改变变量【greeting】的值
        String greeting = "Hello";
        //以下操作：java虚拟机会新建一个字符串【Hello,Z】并将greeting变量的引用地址指向它，并回收【Hello】字符串
        greeting = "Hello, Z";
        //不可变字符串却有一个优点：编译器可以让字符串共享。
    }

    /**
     * 3.6.4 检测字符串是否相等
     * <p>
     * 字符串常量：通过声明一个String对象并直接赋值的变量
     */
    @Test
    public void test4() {
        String greeeting = "Hello";
        String hello = "Hello";
        print(greeeting.equals("Hello"));
        print("hello".equalsIgnoreCase(greeeting));
        print(greeeting.equals(hello));
        print(greeeting == hello);

        String substring = greeeting.substring(0, 3);
        print(substring == "Hel"); // == 只检测2个变量的地址是否一致
        print(greeeting.substring(0, 3) + "lo" == "Hello");
        //如果虚拟机始终将相同的字符串共享， 就可以使用==运算符检测是否相等。但实际上
        //【只有字符串常量是共享】的，而 + 或 substring 等操作产生的结果并不是共享的。因此，千万不
        //要使用== 运算符测试字符串的相等性， 以免在程序中出现糟糕的 bug。从表面上看， 这
        //bug 很像随机产生的间歇性错误。
    }

    /**
     * 3.6.5 空 串 与 Null串
     */
    @Test
    public void test5() {
        String emptyStr = ""; //""是一个String对象，长度为0，内容为空
        String nullStr = null; // null是一个特殊的值，表示该变量没有关联任何的对象
        print(nullStr != null);
        print(emptyStr.length() != 0); //如果调用nullStr.length()，会出现空指针异常，因为null不能调用任何的方法
    }

    /**
     * 3.6.6 码点与代码单元
     * <p>
     * java字符串由char值序列组成。
     * 而char类型是一个采用 UTF-16编码表示的 Unicode码点的代码单元。
     */
    @Test
    public void test6() {
        String greeting = "Hello";
        int length = greeting.length(); //5
        print(length);

        //要想得到实际的长度，即码点数量，可以调用：
        int codePointCount = greeting.codePointCount(0, greeting.length());
        print(codePointCount);

        //返回位置 n 的代码单元， n介于0 ~ s.length() -1 之间，即下标位置
        char c = greeting.charAt(0);
        char c1 = greeting.charAt(4);
        print("{0},{1}", c, c1);

        int i = 2;
        int index = greeting.offsetByCodePoints(0, i);
        int cp = greeting.codePointAt(index);
        print("{0},{1}", index, cp);

        int s = 0X1D546;
        char[] chars = Character.toChars(s);
        String s1 = new String(chars);
        print(s1);

        String str = "𝕆 is the set of octonions";
        print("{0}的长度为{1}，码点长度为{2}", str, str.length(), str.codePointCount(0, str.length()));
        print("{0}的第一个字符为{1},第一个码点为{2}", str, str.substring(0, 1), str.substring(0, 2));

        int x = 0;
        while (x < str.length()) {
            int codePointAtX = str.codePointAt(x);
            print("码点{0}的字符为：{1}", codePointAtX, new String(Character.toChars(codePointAtX)));
            if (Character.isSupplementaryCodePoint(codePointAtX)) {
                //如果codePoint所在的位置是代码点的第一部分，执行此处
                x += 2;
            } else {
                x++;
            }
        }
        //更简单的办法是：转为int的流，然后遍历转换
        str.codePoints().forEach(codepoint -> {
            print("码点{0}的字符为：{1}", codepoint, new String(Character.toChars(codepoint)));
        });
        int[] cps = str.codePoints().toArray();
        print(new String(cps, 0, cps.length));
    }

    /**
     * 3.6.7 String API
     */
    @Test
    public void test7() {
        //在 API 注释中， 有一些 CharSequence 类型的参数这是一种接口类型， 所有字符
        //串都属于这个接口 第 6 章将介绍更多有关接口类型的内容。现在只需要知道只要看到
        //一个 CharSequence 形参， 完全可以传入 String 类型的实参,，
    }

    //3.6.8 阅读联机文档
    @Test
    public void test8() {

    }

    /**
     * 3.6.9 构 建 字 符 串
     */
    @Test
    public void test9() {
        //在 JDK5.0 中引入 StringBuilder 类。 这个类的前身是 StringBuffer, 其效率稍有些
        //低， 但允许采用多线程的方式执行添加或删除字符的操作 。 如果所有字符串在一个单线
        //程中编辑 （通常都是这样，) ， 则应该用 StringBuilder 替代它。 这两个类的 API 是相同的。

        //在循环中使用+来拼接字符串的时候，会生成很多String对象，导致性能低下。
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(i).append(",");
        }
        print(builder.toString());
        String douhao = ",";
        String nihao = "nihao";
        String s = nihao + douhao + nihao + douhao + nihao;
        print(s);
    }
}
