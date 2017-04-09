package com.aolei.spider.entity;

import java.util.Date;

public class TuiKuEntity {
    private Integer id;

    private String title;

    private String auther;

    private Date time;

    private String url;

    private String imgurl;

    public TuiKuEntity(Integer id, String title, String auther, Date time, String url, String imgurl) {
        this.id = id;
        this.title = title;
        this.auther = auther;
        this.time = time;
        this.url = url;
        this.imgurl = imgurl;
    }

    public TuiKuEntity() {
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    @Override
    public String toString() {
        return "TuiKuEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", time=" + time +
                ", url='" + url + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}