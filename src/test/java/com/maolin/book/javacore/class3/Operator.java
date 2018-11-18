package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.PrintUtil;
import org.junit.Test;

/**
 * 3.5 运算符
 *
 * @author zhangmaolin
 * @date 2018-11-17 20:33
 * @since 0.0.1
 */
public class Operator extends PrintUtil {

    /**
     * +，-，*，/，%
     * 加，减，乘，除，取余
     * <p>
     * 2个整数的除法表示整数除法；否则，表示浮点除法
     * <p>
     * 整数除以0，会出现异常
     * <p>
     * 浮点数除以0，会表示正/负无穷大
     */
    @Test
    public void test1() {
        print(10 / 2);
        print(11 / 2);

        print(15.5 / 5);

        print(10 % 5);
        print(12 % 5);

        print(1.1 / 0);
        print(-1.1 / 0);

        print(1 / 0);
    }

    /**
     * 3.5.1 数学函数与常量
     */
    @Test
    public void test2() {
        double x = 4;
        double y = Math.sqrt(x);
        print("{0}的平方根等于{1}", x, y);

        y = Math.pow(x, 2);
        print("{0}的二次幂(平方)等于{1}", x, y);

        int currentPosition = 10; //当前时钟时针为10点位置
        int changeHours = -16; //拨动的小时数
        int clockType = 12; // 时钟的范围
        int floorMod = Math.floorMod(currentPosition + changeHours, clockType);
        print("一个时针范围为{0}的钟表，当前时针位置为{1}，拨动{2}小时，结果为：{3}", clockType, currentPosition, changeHours, floorMod);

        //三角函数，https://baike.baidu.com/item/%E4%B8%89%E8%A7%92%E5%87%BD%E6%95%B0%E5%85%AC%E5%BC%8F/4374733?fr=aladdin
        double pi = Math.PI;
        print(pi);
        double sin = Math.sin(pi);
        print(sin);
        double cos = Math.cos(pi);
        print(cos);
        double tan = Math.tan(pi);
        print(tan);
        double atan = Math.atan(pi);
        print(atan);

        //指数函数和他们的反函数
        double log = Math.log(2);
        print(log);
        double exp = Math.exp(2);
        print(exp);
        double v = Math.log10(2);
        print(v);

        print(Math.E);
    }

    /**
     * 3.5.2 数值之间的转换
     * <p>
     * 当整数和浮点数进行计算时：
     * 1).如果2个操作数中有一个是double类型，另一个也会转为double类型
     * 2).否则，其中一个是float类型，另一个也会转为float类型
     * 3).否则，其中一个是long类型，另一个也会转为long类型。
     * 4).否则，2个操作数都将被转为int类型
     * <p>
     * -> 表示自动转换时不会丢失精度，=> 表示可能会丢失精度
     * byte -> short -> int -> long
     * char -> int -> double
     * int => float -> double
     * long => double
     * long => float
     */
    @Test
    public void test3() {
        byte byte1 = 10;
        short short1 = byte1;
        int int1 = short1;
        long long1 = int1;

        char char1 = '张';
        int int2 = char1;
        print(int2);
    }

    /**
     * 强制类型转换
     */
    @Test
    public void test4() {
        double x = 9.997D;
        int intX = (int) x;
        print(intX); //强制类型转换通过【截断小数部分】将浮点值转换为整型

        intX = (int) Math.round(x); //四舍五入方法，因为转换结果为long类型，所以需要 强制转换，可能存在精度丢失
        print(intX);

        byte y = (byte) 444;
        byte z = (byte) 300;
        print("{0},{1}", y, z);

        int intY = 32768;
        short shortY = (short) intY;
        print(shortY);
    }

    /**
     * 3.5.4 结合赋值和运算符
     */
    @Test
    public void test5() {
        int x = 10;
        x += 2; //等于 x=x+2
        print(x += 4); //16

        print(x *= 2); //32
        print(x %= 5); //2

        print(x += 1.5);// 等同于 x = (int)(x+1.5) == 3
    }

    /**
     * 3.5.5 自增与自减运算符
     */
    @Test
    public void test6() {
        int x = 10;
        x++;
        print(x);
        x--;
        print(x);

        int m = 10;
        int n = 10;
        int y = 2 * ++m; // 前缀++优先级更高，先计算变量的值，再于其他数字计算
        int z = 2 * n++; // 后缀++优先级低
        print("{0},{1}", y, z);
    }

    /**
     * 3.5.6 关系和 boolean 运算符
     */
    @Test
    public void test7() {
        int x = 10;
        int y = 10;
        int z = 5;

        print(x == y);
        print(x != z);

        print(x > z);
        print(z < y);
        print(x >= y);
        print(z <= y);

        print((x > z) && (x > y)); // && 逻辑【与】，并且的意思，即2者为真即为真，其他都是假
        print((x > z) || (x > y)); // || 逻辑【或】，或者的意思，即2者为假即为假，其他都是真
        //&& 和 || 都是短路运算符，当第一个表达式满足条件之后，后面则不会计算
        //即&& 第一个表达式为假时，第二个不会计算，始终为假；即|| 第一个表达式为真时，第二个不会计算，始终为真；
        print(!(x > z)); // ! 逻辑【非】，取反

        print(x > z ? x : z); // condition ? expression1 : expression2 三元运算符
    }

    /**
     * 3.5.7 位运算符
     * &("and") |("or") ^("XOr") ~("not")
     * <p>
     * >> 和 << 运算符将位模式左移或右移
     */
    @Test
    public void test8() {
        String binaryString = Integer.toBinaryString(10);
        print(binaryString);
        //int占4个字节，1个字节有8位，10二进制表示位：1010
        //00000000 00000000 00000000 00001010
        int n = 10;
        //00000000 00000000 00000000 00001000
        int intAnd = (n & 0B1000); //或运算，位都是1，则位1，反之为0
        int m = 0B1000;
        print("{0}进行&{1}时，结果为{2}，除以{3}等于{4}", n, m, intAnd, m, intAnd / m);

        int intOr = (n | 0B101); //或运算，位任意为1，都为1
        m = 0B1111;
        print(intOr / m);

        int intXOr = (n ^ 0B101);//异或运算， 位都为1，则位0，任意为1，则为1，反之为0
        print(intXOr / 0B1111);
        intXOr = (n ^ 0B1111);
        print(intXOr / 0B101);
        //规律：一个整数异或一个整数2次等于他自身
        print("当一个整数{0}，异或{1}两次时，结果为{2}", n, 0B1111, (n ^ 0B1111) ^ 0B1111);

        //11111111 11111111 11111111 11110101
        int intNot = ~n;
        print(intNot);
        print(0B11111111_11111111_11111111_11110101);

        int x = 10;
        int y = 10;
        int z = 5;
        boolean booleanOrOr = (x == y) || (y < z++);
        print("使用||为短路计算，所以当第一个为true时，第二个表达式不会计算，Z等于{0}，表达式结果为{1}", z, booleanOrOr);
        boolean booleanOr = (x == y) | (y < z++);
        print("使用|为非短路计算，所以当第一个为true时，第二个表达式依旧计算，Z等于{0},表达式结果为{1}", z, booleanOr);

        // 00000000 00000000 00000000 00001010
        // 00000000 00000000 00000000 00000001
        int intLeft = n >> 3;//位右移3位，看箭头方向
        // 00000000 00000000 00000000 01010000
        int intRight = n << 3;//位左移3位，看箭头方向
        print("{0},{1}；{2},{3}", intLeft, intLeft / 0B1, intRight, intRight / 0B1010000);
    }

    /**
     * 3.5.8 括号与运算符级别
     */
    @Test
    public void test9() {
        //方法的链式调用，从左向右
        //!， ~， ++， --， +， -， ()强制类型转换， new         : 从右向左
        // *， /， %                                          ：从左向右
        // +， -                                             ：从左向右
        // <<， >>， >>>                                      ： 从左向右
        // <， <=， >， >=， instanceof                         ： 从左向右
        // ==， !=                                             ：从左向右
        // &                                                    从左向右
        // ^                                                    从左向右
        // |                                                   从左向右
        // &&                                                   从左向右
        // ||                                                   从左向右
        // ?:                                                   从右向左
        // =，+=，-=，*=，/=，==，&=，|=，^=，<<=，>>=，>>>=       从右向左
    }

    /**
     * 3.5.9 枚举类型
     */
    @Test
    public void test10() {
        Size s = Size.MEDIUM;
    }

    enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }
}
