package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.UsefulUtil;
import org.junit.Test;

/**
 * 3.3 基本数据类型
 * 8种基本数据类型
 *
 * @author zhangmaolin
 * @date 2018-11-17 17:39
 * @since 0.0.1
 */
public class PrimitiveType extends UsefulUtil {


    /**
     * 整型，4个字节，-2 147 483 648 ~ 2 147 483 647 (正好超过 20 亿)
     */
    private int intType;
    /**
     * 整型，2个字节，-32 768 ~ 32 767
     */
    private short shortType;
    /**
     * 整型，8个字节，-9 223 372 036 854 775 808 ~ 9 223 372 036 854 775 807
     */
    private long longType;
    /**
     * 整型，1个字节， -128 ~ 127
     */
    private byte byteType;

    @Test
    public void test1() {
        long uuid = 100L;
        int id = 100_200_300;//since java 7

        int type16 = 0X10;
        int type8 = 010;
        int type2 = 0B101;//since java 7

        byte byte1 = 127;

        String type2ToString = Integer.toBinaryString(type2);
        print("{0}的二进制是{1}", type2, type2ToString);

        String type8ToString = Integer.toOctalString(type8);
        print("{0}的八进制是{1}", type8, type8ToString);

        String type16ToString = Integer.toHexString(type16);
        print("{0}的十六进制是{1}", type16, type16ToString);

        byte to2Byte = Byte.parseByte(type2ToString, 2);
        print("{0}转换为二进制是{1}", type2ToString, to2Byte);

    }

    /**
     * 浮点型，4个字节，大约 ± 3.402 823 47E+38F (有效位数为 6 ~ 7 位）
     */
    private float floatType;

    /**
     * 浮点型，8个字节，大约 ± 1.797 693 134 862 315 70E+308 (有效位数为 15 位）
     */
    private double doubleType;

    @Test
    public void test2(){
        double naN = Double.NaN;//非数字
        print(naN);

        print(Double.isNaN(naN)); //https://www.cnblogs.com/big-xuyue/p/4106130.html

        double positiveInfinity = Double.POSITIVE_INFINITY;//正无穷大
        print(positiveInfinity);

        double negativeInfinity = Double.NEGATIVE_INFINITY;//负无穷大
        print(negativeInfinity);

        print(2-1.1); //有误差

    }

    /**
     * 字符类型，char 类型描述了 UTF-16 编码中的一个代码单元
     */
    private char charType;

    /**
     * 布尔型，true，false
     */
    private boolean booleanType;

    /**
     * Unicode 转义序列会在解析代码之前得到处理。
     */
    @Test
    public void test3(){
        char char1 = '\u2122';
        print(char1);

        print('\u03C0'); // \\u 表示转义序列，猜猜注释中写2个斜杠的原因

        print("\u00A0 is a newline");
        print("Look inside c:\\users");

        print(" \u0008 === \b"); //退格符
        print(" \u0009 === \t"); //制表符
        print(" "+\u000a"\\u000a === \n"); //换行符
        print(" "+\u000d"\\u000d === \r"); //回车符
        print(\u0022\\u0022 === \""); //双引号
        print("\u0027 === \'"); //单引号
        print("\\u005c === \\"); //反斜杠
    }
}
