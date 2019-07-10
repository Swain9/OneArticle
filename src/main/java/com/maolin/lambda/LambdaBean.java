package com.maolin.lambda;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-04 09:27
 */
public class LambdaBean {

    private String ifName;
    private String manufacturer;
    private String model;
    private Integer timeout;

    public LambdaBean(String ifName, String manufacturer, String model, Integer timeout) {
        this.ifName = ifName;
        this.manufacturer = manufacturer;
        this.model = model;
        this.timeout = timeout;
    }

    public String getIfName() {
        return ifName;
    }

    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "TopoFindTimeOut{" +
                "ifName='" + ifName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", timeout=" + timeout +
                '}';
    }
}
