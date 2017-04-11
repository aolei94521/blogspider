package com.aolei.spider.entity;

import java.util.Date;

public class LikeEntity {
    private Integer id;

    private Integer blogid;

    private String tbname;

    private Integer likecount;

    private Date createtime;

    public LikeEntity(Integer id, Integer blogid, String tbname, Integer likecount, Date createtime) {
        this.id = id;
        this.blogid = blogid;
        this.tbname = tbname;
        this.likecount = likecount;
        this.createtime = createtime;
    }

    public LikeEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}