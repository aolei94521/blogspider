package com.aolei.spider.entity;

import java.util.Date;

public class SearchRecordEntity {
    private Integer id;

    private String word;

    private String username;

    private Date createtime;

    public SearchRecordEntity(Integer id, String word, String username, Date createtime) {
        this.id = id;
        this.word = word;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
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