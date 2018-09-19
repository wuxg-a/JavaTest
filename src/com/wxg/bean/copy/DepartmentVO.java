package com.wxg.bean.copy;

import java.util.Date;

public class DepartmentVO {

    private String id;

    private String name;

    private String parentId;

    private String orgId;

    private String creatorId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public DepartmentVO() {
    }

    public DepartmentVO(String id, String name, String parentId, int index, String orgId, String creatorId, Date createTime) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.orgId = orgId;
        this.creatorId = creatorId;
        this.createTime = createTime;
    }
}