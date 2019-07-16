package com.maolin.zerenlian.model;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-15 17:46
 */
public class BizRequest {

    private String bizId;
    private String bizName;
    private Map<String, String> params = new HashMap<>();

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "BizRequest{" +
                "bizId='" + bizId + '\'' +
                ", bizName='" + bizName + '\'' +
                ", params=" + params +
                '}';
    }
}
