package com.aolei.spider.entity;

public class UserEntity {
    private Integer id;

    private String username;

    private String userpwd;

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
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public UserEntity(Integer id, String username, String userpwd) {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
    }

    public UserEntity() {
    }
}