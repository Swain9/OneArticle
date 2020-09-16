package com.maolin.javascript;

import com.maolin.javascript.extents.Father;
import com.maolin.javascript.extents.Son;
import org.junit.Test;

/**
 * @author zhangmaolin
 * @date 2020-07-01 23:10
 * @since 0.0.1
 */
public class ExtendsTest {

    @Test
    public void test(){
        Son f = new Son(10, 5);
        f.count();
        f.plus();
    }
}
