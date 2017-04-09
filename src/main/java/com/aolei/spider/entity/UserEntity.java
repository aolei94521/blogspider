package com.aolei.spider.entity;

public class UserEntity {
    private Integer id;

    private String userName;

    private String userPwd;

    public UserEntity(Integer id, String username, String userpwd) {
        this.id = id;
        this.userName = username;
        this.userPwd = userpwd;
    }

    public UserEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userPwd;
    }

    public void setUserpwd(String userpwd) {
        this.userPwd = userpwd == null ? null : userpwd.trim();
    }
}