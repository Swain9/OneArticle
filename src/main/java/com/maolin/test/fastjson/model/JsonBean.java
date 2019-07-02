package com.maolin.test.fastjson.model;

import java.util.List;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-06-21 09:46
 */
public class JsonBean {

    private String name;
    private List<JsonSubBean> list;

    private JsonSubBean jsonSubBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JsonSubBean> getList() {
        return list;
    }

    public void setList(List<JsonSubBean> list) {
        this.list = list;
    }

    public JsonSubBean getJsonSubBean() {
        return jsonSubBean;
    }

    public void setJsonSubBean(JsonSubBean jsonSubBean) {
        this.jsonSubBean = jsonSubBean;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", jsonSubBean=" + jsonSubBean +
                '}';
    }
}
