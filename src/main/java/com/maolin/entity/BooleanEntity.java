package com.maolin.entity;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-03-20 17:30
 */
public class BooleanEntity {

    private Boolean preview;

    public Boolean getPreview() {
        return preview;
    }

    public void setPreview(Boolean preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "BooleanEntity{" +
                "preview=" + preview +
                '}';
    }
}
