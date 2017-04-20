package com.aolei.spider.entity;

public class SDEntity {
    private Integer id;

    private String url;

    private String title;

    private String time;

    private String readcount;

    private String recomment;

    private String pereview;

    public SDEntity(Integer id, String url, String title, String time, String readcount, String recomment, String pereview) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.time = time;
        this.readcount = readcount;
        this.recomment = recomment;
        this.pereview = pereview;
    }

    public SDEntity() {
        super();
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
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getReadcount() {
        return readcount;
    }

    public void setReadcount(String readcount) {
        this.readcount = readcount == null ? null : readcount.trim();
    }

    public String getRecomment() {
        return recomment;
    }

    public void setRecomment(String recomment) {
        this.recomment = recomment == null ? null : recomment.trim();
    }

    public String getPereview() {
        return pereview;
    }

    public void setPereview(String pereview) {
        this.pereview = pereview == null ? null : pereview.trim();
    }
}