package com.aolei.spider.entity;

public class userEntity {
    private Integer id;

    private String username;

    private String userpwd;

    public userEntity(Integer id, String username, String userpwd) {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
    }

    public userEntity() {
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

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }
}