package com.maolin.test.fastjson.model;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-06-21 09:46
 */
public class JsonSubBean {


    private String name;
    private Boolean flag;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "JsonSubBean{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                ", num=" + num +
                '}';
    }
}
