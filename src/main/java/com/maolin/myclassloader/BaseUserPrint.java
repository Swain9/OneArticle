package com.maolin.myclassloader;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-12-07 14:26
 */
public class BaseUserPrint implements IUserPrint {
    @Override
    public void print() {
        System.out.println("默认加载对象");
    }
}
