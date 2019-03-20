package com.maolin.basic.staticinit;

import com.maolin.staticinit.SubStaticInit;
import org.junit.Test;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-01-30 18:48
 */
public class StaticInitTest {

    /**
     * 静态代码块的初始化
     */
    @Test
    public void test1(){
        SubStaticInit.print();
    }

}
