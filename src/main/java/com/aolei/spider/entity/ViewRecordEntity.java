package com.aolei.spider.entity;

import java.util.Date;

public class ViewRecordEntity {
    private Integer id;

    private String username;

    private Integer blogid;

    private String tbname;

    private Date viewtime;

    public ViewRecordEntity(Integer id, String username, Integer blogid, String tbname, Date viewtime) {
        this.id = id;
        this.username = username;
        this.blogid = blogid;
        this.tbname = tbname;
        this.viewtime = viewtime;
    }

    public ViewRecordEntity() {
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

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname == null ? null : tbname.trim();
    }

    public Date getViewtime() {
        return viewtime;
    }

    public void setViewtime(Date viewtime) {
        this.viewtime = viewtime;
    }
}