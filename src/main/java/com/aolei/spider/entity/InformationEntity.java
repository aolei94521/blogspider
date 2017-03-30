package com.aolei.spider.entity;

import java.util.Date;

public class InformationEntity {
    private Integer id;

    private String url;

    private String title;

    private Date time;

    private String readcount;

    private String recomment;

    private String pereview;

    public InformationEntity(Integer id, String url, String title, Date time, String readcount, String recomment, String pereview) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.time = time;
        this.readcount = readcount;
        this.recomment = recomment;
        this.pereview = pereview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReadcount() {
        return readcount;
    }

    public void setReadcount(String readcount) {
        this.readcount = readcount;
    }

    public String getRecomment() {
        return recomment;
    }

    public void setRecomment(String recomment) {
        this.recomment = recomment;
    }

    public String getPereview() {
        return pereview;
    }

    public void setPereview(String pereview) {
        this.pereview = pereview;
    }

    @Override
    public String toString() {
        return "InformationEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", readcount='" + readcount + '\'' +
                ", recomment='" + recomment + '\'' +
                ", pereview='" + pereview + '\'' +
                '}';
    }

    public InformationEntity() {
        super();
    }
}