package com.aolei.spider.entity;

public class UserEntity {
    private Integer id;

    private String userName;

    private String userPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getUserpwd() {
        return userPwd;
    }

    public void setUserpwd(String userpwd) {
        this.userPwd = userpwd;
    }

    public UserEntity(Integer id, String username, String userpwd) {
        this.id = id;
        this.userName = username;
        this.userPwd = userpwd;
    }

    public UserEntity() {
    }
}