package com.maolin.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author zhangmaolin
 * @date 2018-09-06 18:20
 * @since 0.0.1
 */
public class GenericTest {

    @Test
    public void testGeneric(){
        Request<Demo> request = new Request<>();
        request.setId("aaaa");
        Demo demo = new Demo();
        demo.setName("nihao");
        request.setObj(demo);
        System.out.println(request);

        String json = JSON.toJSONString(request);
        System.out.println(json);

        String jsonStr = "{\"id\":\"aaaa\",\"obj\":{\"name\":\"nihao\"}}";
        String jsonStr2 = "{\"id\":\"aaaa\",\"obj\":{\"name1\":\"nihao\"}}";
        //Class<Demo> demoClass = request.showClass();
        //Class<Request<Demo>> aClass = (Class<Request<Demo>>) request.showEntityClass();
        Request<Demo> request2 = JSONObject.<Request<Demo>>parseObject(jsonStr, Request.class);
        Request<Demo> request3 = JSONObject.<Request<Demo>>parseObject(jsonStr2, Request.class);
        //JSONObject.parseObject(jsonStr, Request.class);
        System.out.println(request2);
        System.out.println(request3);
    }

}
