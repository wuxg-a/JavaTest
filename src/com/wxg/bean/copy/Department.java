package com.wxg.bean.copy;

import java.util.Date;

public class Department {
    private String id;

    private String name;

    private String parentId;

    private Double position;

    private String orgId;

    private String creatorId;

    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.id
     *
     * @return the value of department.id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public String getId() {
        return id;
    }

    public Department(String id, String name, String parentId, Double position, String orgId, String creatorId,
			Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.position = position;
		this.orgId = orgId;
		this.creatorId = creatorId;
		this.createTime = createTime;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.id
     *
     * @param id the value for department.id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.name
     *
     * @return the value of department.name
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.name
     *
     * @param name the value for department.name
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.parent_id
     *
     * @return the value of department.parent_id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.parent_id
     *
     * @param parentId the value for department.parent_id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.position
     *
     * @return the value of department.position
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public Double getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.position
     *
     * @param position the value for department.position
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setPosition(Double position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.org_id
     *
     * @return the value of department.org_id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.org_id
     *
     * @param orgId the value for department.org_id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.creator_id
     *
     * @return the value of department.creator_id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.creator_id
     *
     * @param creatorId the value for department.creator_id
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.create_time
     *
     * @return the value of department.create_time
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.create_time
     *
     * @param createTime the value for department.create_time
     *
     * @mbggenerated Fri Feb 17 11:07:14 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}