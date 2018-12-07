package com.maolin.myfree;

import com.maolin.myeasyfree.Configuration;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-27 14:08
 */
public class MyEasyFreeTest {

    @Test
    public void test1(){
        Configuration cfg = new Configuration();
        Map<String, Object> root = new HashMap<>();
        root.put("user", "Big Joe");

        Map<String, Object> latest = new HashMap<>();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");
    }

}
