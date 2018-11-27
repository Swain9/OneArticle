package com.maolin.myfree.core;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 17:22
 */
public abstract class ArithmeticEngine {

    public static final BigDecimalEngine BIGDECIMAL_ENGINE = new BigDecimalEngine();
    public static class BigDecimalEngine extends ArithmeticEngine{

    }
}
