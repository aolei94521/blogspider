package com.aolei.spider.entity;

import java.util.Date;

public class UserLikeAndCollectionEntity {
    private Integer id;

    private String username;

    private Integer type;

    private Date createtime;

    private Integer status;

    private String tbname;

    private String blogid;

    public UserLikeAndCollectionEntity(Integer id, String username, Integer type, Date createtime, Integer status, String tbname, String blogid) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.createtime = createtime;
        this.status = status;
        this.tbname = tbname;
        this.blogid = blogid;
    }

    public UserLikeAndCollectionEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname == null ? null : tbname.trim();
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid == null ? null : blogid.trim();
    }
}