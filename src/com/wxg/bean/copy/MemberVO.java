package com.wxg.bean.copy;

import java.util.Date;

public class MemberVO {

    private String id;

    private String userId;

    private String orgId;

    private String name;

    private String title;

    private Byte status;

    private Byte role;

    private String creatorId;

    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
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

    public MemberVO() {
    }

    public MemberVO(String id, String userId, String orgId, String name, String title, Byte status, Byte role, String creatorId, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.orgId = orgId;
        this.name = name;
        this.title = title;
        this.status = status;
        this.role = role;
        this.creatorId = creatorId;
        this.createTime = createTime;
    }
}