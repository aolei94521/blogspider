package com.aolei.spider.entity;

import java.util.Date;

public class UserLikeAndCollectionEntity {
    private Integer id;

    private String userName;

    private Integer blogId;

    private Integer type;

    private Date createTime;

    private Integer status;

    private String tbName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTbname() {
        return tbName;
    }

    public void setTbname(String tbName) {
        this.tbName = tbName;
    }

    public UserLikeAndCollectionEntity(Integer id, String userName, Integer blogId, Integer type, Date createTime, Integer status, String tbName) {
        this.id = id;
        this.userName = userName;
        this.blogId = blogId;
        this.type = type;
        this.createTime = createTime;
        this.status = status;
        this.tbName = tbName;
    }

    public UserLikeAndCollectionEntity() {
    }
}