package com.maolin.entity;

/**
 * @author zhangmaolin
 * @date 2018-10-09 11:13
 * @since 0.0.1
 */
public class PwInfo {

    public PwInfo(String apw, String zpw) {
        this.apw = apw;
        this.zpw = zpw;
    }

    private String apw;
    private String zpw;

    public String getApw() {
        return apw;
    }

    public void setApw(String apw) {
        this.apw = apw;
    }

    public String getZpw() {
        return zpw;
    }

    public void setZpw(String zpw) {
        this.zpw = zpw;
    }

    @Override
    public String toString() {
        return "PwInfo{" +
                "apw='" + apw + '\'' +
                ", zpw='" + zpw + '\'' +
                '}';
    }
}
