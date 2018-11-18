package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.PrintUtil;
import org.junit.Test;

/**
 * 3.4 变量
 *
 * @author zhangmaolin
 * @date 2018-11-17 19:54
 * @since 0.0.1
 */
public class Variable extends PrintUtil {

    /**
     * java的变量名必须以 字母开头， 并由字母和数字构成的序列。
     * <p>
     * 字母： A-Z, a-z, _ ,$, 以及其他语言中表示【字母】的任何 Unicode 字符，例如汉字，德语字符，日语字符
     * 数字： 0-9，以及其他语言种表示【数字】的任何 Unicode 字符。
     * <p>
     * 禁止： +，©，空格，保留关键字， 不建议使用 $
     * <p>
     * 变量名中，所有的字符都是有意义的，并且大小写敏感
     * <p>
     * 变量名的长度【基本上】没有限制
     */
    @Test
    public void test1() {

        String 你好 = "Nihao";
        print(你好);

        boolean 你 = Character.isJavaIdentifierStart('你');
        print(你);

        boolean 好 = Character.isJavaIdentifierPart('好');
        print(好);

        boolean part1 = Character.isJavaIdentifierStart('3'); //判断变量名能否以 3 开头
        print(part1);

        boolean part2 = Character.isJavaIdentifierPart('3'); //判断变量名除去开头字符外，能否包含 3
        print(part2);
    }

    private int notInit;
    private String notInits;
    /**
     * 定义在方法中的变量必须在初始化之后才能够使用
     */
    @Test
    public void test2(){
        int i;
        print(notInit);
        i = 1;
        print(i);

        String j;
        print(notInits);
        j = null;
        print(j);
    }

    /**
     * 类常量
     */
    public static final String USER_NAME = "Swain";
    /**
     * 常量
     */
    @Test
    public void test3(){
        print(USER_NAME);
        final String USER_NAME = "Swain10";
        print(USER_NAME);
    }
}
