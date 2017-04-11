package com.aolei.spider.entity;

import java.util.Date;

public class SearchRecordEntity {
    private Integer id;

    private String key;

    private String username;

    private Date createtime;

    public SearchRecordEntity(Integer id, String key, String username, Date createtime) {
        this.id = id;
        this.key = key;
        this.username = username;
        this.createtime = createtime;
    }

    public SearchRecordEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}