package com.maolin.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author zhangmaolin
 * @date 2018-09-06 18:20
 * @since 0.0.1
 */
public class GenericTest {

    @Test
    public void testGeneric() {
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
        //实际上，这里的Demo泛型是ObjectJson对象，非真正的泛型对象
        //  /com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.java
        Request<Demo> request2 = JSONObject.<Request<Demo>>parseObject(jsonStr, Request.class);
        Request<Demo> request3 = JSONObject.<Request<Demo>>parseObject(jsonStr2, Request.class);
        //JSONObject.parseObject(jsonStr, Request.class);
        System.out.println(request2);
        System.out.println(request3);


    }

    /**
     * Static member 'com.maolin.generic.GenericTest.getDemoInfo(java.lang.String, java.lang.reflect.Type)'
     * accessed via instance reference
     * Inspection info:
     * Shows references to static methods and fields via class instance rather than a class itself.
     * Explicit type arguments can be inferred
     * Inspection info:
     * This inspection reports all calls to parametrized methods where explicit argument types can be omitted,
     * since they will be unambiguously inferred by compiler. Such usages make code excessive and thus less readable.
     * For example if you have a call to parametrized method like:
     *     this.<String>addItem("");
     * - the usage of <String> will be highlighted.
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String jsonStr = "你好";
        Request<Demo> demoInfo = GenericTest.getDemoInfo(jsonStr, Request.class);
        System.out.println(demoInfo);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getDemoInfo(String json, Type clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String typeName = clazz.getTypeName();
        Class<?> clz = Class.forName(typeName);
        Field[] fields = clz.getFields();
        for (Field field : fields) {
            System.out.println(field.getType());
        }
        System.out.println(json);
        return (T) newClazz(clz);
    }

    @SuppressWarnings("unchecked")
    private static <T> T newClazz(Class<?> clz) throws IllegalAccessException, InstantiationException {
        return (T) clz.newInstance();
    }

}
