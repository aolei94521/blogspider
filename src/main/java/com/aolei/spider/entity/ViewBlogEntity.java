package com.aolei.spider.entity;

import java.util.Date;

public class ViewBlogEntity {
    private Integer id;

    private Integer blogid;

    private String tbname;

    private String title;

    private String content;

    private String link;

    private Date time;

    private String imagelink;

    public ViewBlogEntity(Integer id, Integer blogid, String tbname, String title, String content, String link, Date time, String imagelink) {
        this.id = id;
        this.blogid = blogid;
        this.tbname = tbname;
        this.title = title;
        this.content = content;
        this.link = link;
        this.time = time;
        this.imagelink = imagelink;
    }

    public ViewBlogEntity() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink == null ? null : imagelink.trim();
    }
}