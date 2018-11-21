package com.maolin.book.javacore.class3;

import org.junit.Test;

import java.math.BigInteger;

/**
 * 3.9 大 数 值
 *
 * @author zhangmaolin
 * @date 2018-11-21 23:47
 * @since 0.0.1
 */
public class BigNumber {

    /**
     * 如果基本的整数和浮点数精度不能够满足需求， 那么可以使用jaVa.math 包中的两个
     * 很有用的类：Biglnteger 和 BigDecimaL 这两个类可以处理包含任意长度数字序列的数值。
     * Biglnteger 类实现了任意精度的整数运算， BigDecimal 实现了任意精度的浮点数运算
     */
    @Test
    public void test1() {
        BigInteger bigA = BigInteger.valueOf(100);
        BigInteger bigB = BigInteger.valueOf(1000);

        //+加运算,c=a+b
        BigInteger bigC = bigA.add(bigB);
        //d= c* (b+2)
        BigInteger bigD = bigC.multiply(bigB.add(BigInteger.valueOf(2)));

    }

}
