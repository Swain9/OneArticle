package com.maolin.myclassloader;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-12-07 14:54
 */
public class LoadUserPrint implements IUserPrint {
    @Override
    public void print() {
        System.out.println("手动加载的打印信息2");
    }
}
