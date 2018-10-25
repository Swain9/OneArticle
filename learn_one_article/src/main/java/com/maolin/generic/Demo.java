package com.maolin.generic;

import java.lang.reflect.ParameterizedType;

/**
 * @author zhangmaolin
 * @date 2018-09-06 18:19
 * @since 0.0.1
 */
public class Demo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }
}
