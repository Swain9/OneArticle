package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.UsefulUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 3.10 数 组
 * 数组是一种数据结构， 用来存储同一类型值的集合。通过一个整型下标可以访问数组中
 * 的每一个值。例如， 如果 a 是一个整型数组， a[i] 就是数组中下标为 i 的整数
 * <p>
 * 在声明数组变量时， 需要指出数组类型 （ 数据元素类型紧跟 []) 和数组变量的名字。下
 * 面声明了整型数组 a: int[] a;
 * <p>
 * 不过， 这条语句只声明了变量 a， 并没有将 a 初始化为一个真正的数组。应该使用 new 运算
 * 符创建数组。
 * <p>
 * int[] a = new int[100];这条语句创建了一个可以存储 100 个整数的数组。
 * 数组长度不要求是常量： new int[n] 会创建一个长度为 n 的数组
 * <p>
 * 创建一个数字数组时， 所有元素都初始化为 【0】。boolean 数组的元素会初始化为 【false】 对
 * 象数组的元素则初始化为一个特殊值 【null】, 这表示这些元素（还）未存放任何对象。
 * <p>
 * 一旦创建了数组， 就【不能】再改变它的大小（尽管可以改变每一个数组元素）。 如果经常需
 * 要在运行过程中扩展数组的大小， 就应该使用另一种数据结构—数组列表（ array list)
 *
 * @author zhangmaolin
 * @date 2018-11-21 23:58
 * @since 0.0.1
 */
public class ArrayType extends UsefulUtil {

    /**
     * 3.10.1 for each 循环
     * foreach 循环语句的循环变量将会遍历数组中的每个元素， 而不需要使用下标值
     * <p>
     * for (variable : collection) statement
     * <p>
     * collection 这一集合表达式必须是一个【数组】或者是一个实现了【Iterable 接口】的类对象
     */
    @Test
    public void test1() {
        //for (variable : collection) statement
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i : a) {
            print(i);
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 3.10.2 数组初始化以及匿名数组
     */
    @Test
    public void test2() {
        //创建数组对象并同时赋予初始值的简化书写形式
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};

        //初始化一个匿名的数组
        print(new int[]{17, 19, 23, 29, 31, 37});

        //这种表示法将【创建一个新数组】并利用【括号中提供的值】进行【初始化】，
        // 数组的大小就是【初始值的个数】

        //使用这种语法形式可以在【不创建新变量】的情况下【重新初始化】一个数组
        smallPrimes = new int[]{17, 19, 23, 29, 31, 37};

        //在 Java 中， 允许数组长度为 0。在编写一个结果为数组的方法时， 如果碰巧结果
        //为【空】， 则这种语法形式就显得非常有用。
        //注意， 数组长度为 0 与 null 不同。
        smallPrimes = new int[0];

    }

    /**
     * 3.10.3 数组拷贝
     */
    @Test
    public void test3() {
        //在 Java 中，允许将一个数组变量拷贝给另一个数组变量。
        // 这时， 两个变量将引用同一个数组：
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};
        int[] luckyNumbers = smallPrimes; //将引用同一个堆中的地址
        luckyNumbers[5] = 99;
        print(smallPrimes[5]);

        //如果希望将一个数组的所有值拷贝到一个新的数组中去，
        //就要使用 Arrays 类的 copyOf方法
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);

        //第 2 个参数是新数组的长度。这个方法通常用来增加数组的大小
        //如果数组元素是数值型，那么多余的元素将被赋值为 0 ; 如果数组元素是布尔型，则将赋值
        //为 false。相反，如果长度小于原始数组的长度，则只拷贝最前面的数据元素。
        luckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length * 2);

        for (int i : luckyNumbers) {
            print(i);
        }
    }

    /**
     * 3.10.4 命令行参数
     *
     * @param args
     */
    public static void main(String[] args) {
        //java [class] [arguments]
        System.out.println(args);
    }

    /**
     * 3.10.5 数组排序
     */
    @Test
    public void test5() {
        //Random random = new Random();
        List<Integer> list = randomList(0, 100);
        int[] a = new int[101];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        //使用了优化的快速排序算法
        //快速排序算法对于大多数数据集合来说都是效率比较高的
        print(Arrays.toString(a));
        Arrays.sort(a);
        print(Arrays.toString(a));

        int[] ints = randomInts(0, 10000);
        int[] copy = new int[10001];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = i;
        }
        print(Arrays.toString(ints));
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != copy[i]) {
                print("false");
            }
        }
    }

    /**
     * 3.10.6 多维数组
     * 多维数组将使用多个下标访问数组元素， 它适用于表示表格或更加复杂的排列形式。
     */
    @Test
    public void test6() {
        //声明一个二维数组
        double[][] balances;
        int NYEARS = 10;
        int NRATES = 10;
        //初始化
        balances = new double[NYEARS][NRATES];

        //简写
        int[][] magicSquare =
                {
                        {16, 3, 2, 13},
                        {5, 10, 11, 8},
                        {9, 6, 7, 12},
                        {4, 15, 14, 1}
                };
        print(magicSquare[1][1]);
        //遍历二位数组
        //for (double[] row : a)
        //  for (double value : row)
        //      do something with value

        //快速地打印一个二维数组的数据元素列表
        print(Arrays.deepToString(magicSquare));
    }

    /**
     * 3.10.7 不规则数组
     * Java 实际上没有多维数组，只有一维数组。多维数组被解释为 “数组的数组”
     */
    @Test
    public void test7() {

        final int NMAX = 10;
        int[][] odds = new int[NMAX + 1][];//只有一个括号没有长度是不行的，但是2个括号，第二个括号可以不指定
        for (int n = 0; n <= NMAX; n++)
            odds[n] = new int[n + 1];

        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;

                odds[n][k] = lotteryOdds;
            }
        }
        for (int[] row : odds) {
            for (int odd : row)
                System.out.printf("%4d", odd);
            print("");
        }
    }
}
