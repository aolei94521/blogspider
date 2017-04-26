package com.aolei.spider.entity;

import java.util.Date;

public class CSDNEntity {
    private Integer id;

    private String title;

    private String auther;

    private Date time;

    private String url;

    private String imagelink;

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    private String tbName="tb_cnblogs_geek";

    public CSDNEntity(Integer id, String title, String auther, Date time, String url, String imagelink) {
        this.id = id;
        this.title = title;
        this.auther = auther;
        this.time = time;
        this.url = url;
        this.imagelink = imagelink;
    }

    public CSDNEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther == null ? null : auther.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink == null ? null : imagelink.trim();
    }
}