package com.maolin.generic;

import java.lang.reflect.ParameterizedType;

/**
 * @author zhangmaolin
 * @date 2018-09-06 18:18
 * @since 0.0.1
 */
public class Request<T> {

    private String id;
    private T obj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", obj=" + obj +
                '}';
    }

 /*   *//**
     * 创建一个Class的对象来获取泛型的class
     *//*
    private Class<T> clz;

    @SuppressWarnings("unchecked")
    public Class<T> showClass() {
        if (clz == null) {
            clz = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
        return clz;
    }

    public Class<?> showEntityClass() {
        return GenericSuperclassUtil.getActualTypeArgument(this.getClass());
    }*/
}
