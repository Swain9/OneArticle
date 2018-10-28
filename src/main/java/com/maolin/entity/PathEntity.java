package com.maolin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangmaolin
 * @date 2018-10-28 11:39
 * @since 0.0.1
 */
public class PathEntity implements Serializable {

    private int id;
    private String name;
    private String createDate;
    private String updateDate;
    private boolean folder;
    private String href;
    private String icon;
    private PathEntity parent;
    private List<PathEntity> childs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public PathEntity getParent() {
        return parent;
    }

    public void setParent(PathEntity parent) {
        this.parent = parent;
    }

    public List<PathEntity> getChilds() {
        return childs;
    }

    public void setChilds(List<PathEntity> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "PathEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", folder=" + folder +
                ", href='" + href + '\'' +
                ", icon='" + icon + '\'' +
                ", childs=\n" + childs +
                '}';
    }
}
