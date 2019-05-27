package com.maolin.entity;

import java.util.List;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-15 10:09
 */
public class ListTestObj {

    private List<String> list;
    private List<PwInfo> pwInfoList;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<PwInfo> getPwInfoList() {
        return pwInfoList;
    }

    public void setPwInfoList(List<PwInfo> pwInfoList) {
        this.pwInfoList = pwInfoList;
    }

    @Override
    public String toString() {
        return "ListTestObj{" +
                "list=" + list +
                ", pwInfoList=" + pwInfoList +
                '}';
    }
}
