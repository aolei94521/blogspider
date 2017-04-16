package com.aolei.spider.entity;

import java.util.Date;

public class UserLikeAndCollectionEntity {
    private Integer id;

    private String username;

    private Integer blogid;

    private Integer type;

    private Date createtime;

    private Integer status;

    private String tbname;

    public UserLikeAndCollectionEntity(Integer id, String username, Integer blogid, Integer type, Date createtime, Integer status, String tbname) {
        this.id = id;
        this.username = username;
        this.blogid = blogid;
        this.type = type;
        this.createtime = createtime;
        this.status = status;
        this.tbname = tbname;
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

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
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
}