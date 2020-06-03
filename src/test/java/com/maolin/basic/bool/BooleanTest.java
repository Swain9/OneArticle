package com.maolin.basic.bool;

import com.maolin.entity.BooleanEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-03-20 17:26
 */
public class BooleanTest {

    private Boolean a;
    private boolean b;


    /**
     * https://cloud.tencent.com/developer/article/1338265
     * https://cloud.tencent.com/developer/article/1336599
     */
    @Test
    public void test5(){
        boolean a = true;
        boolean b = false;

        System.out.println(a && b);
        System.out.println(a || b);
        System.out.println(a & b);
        System.out.println(b & a);
        System.out.println(a | b);
        System.out.println(b | a);
        System.out.println(a ^ b);
    }

    @Test
    public void test4(){
        if (a) {
            System.out.println(a);
        }
        if (b) {
            System.out.println(b);
        }
    }

    @Test
    public void test3(){

        Boolean type = false;
        BooleanEntity booleanEntity = new BooleanEntity();
        booleanEntity.setPreview(type);

        System.out.println(booleanEntity);

        type = true;

        System.out.println(booleanEntity);
    }

    @Test
    public void test2(){
        Boolean a = new Boolean(true);
        print(a);
        System.out.println(a);
    }

    @Test
    public void test1(){
        Boolean a = false;
        Boolean b = true;
        List<Boolean> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(list);
        a = true;
        System.out.println(list);
        print(b);
        System.out.println(b);
    }

    private void print(Boolean b) {
        b = false;
        System.out.println(b);
    }


}
