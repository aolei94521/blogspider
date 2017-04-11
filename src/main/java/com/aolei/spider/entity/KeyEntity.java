package com.aolei.spider.entity;

public class KeyEntity {
    private Integer id;

    private String key;

    public KeyEntity(Integer id, String key) {
        this.id = id;
        this.key = key;
    }

    public KeyEntity() {
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
}