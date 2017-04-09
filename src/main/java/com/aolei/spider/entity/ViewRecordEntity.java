package com.aolei.spider.entity;

import java.util.Date;

public class ViewRecordEntity {
    private Integer id;

    private Integer userid;

    private Integer recordid;

    private String tbname;

    private Date viewtime;

    public ViewRecordEntity(Integer id, Integer userid, Integer recordid, String tbname, Date viewtime) {
        this.id = id;
        this.userid = userid;
        this.recordid = recordid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
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