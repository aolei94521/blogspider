package com.aolei.spider.entity;

/**
 * Created by Administrator on 2017/5/11.
 */
public class QiuBaiEntity {
    private String imageLink;
    private String userName;
    private String content;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QiuBaiEntity() {
        super();
    }

    public QiuBaiEntity(String imageLink, String userName, String content) {
        this.imageLink = imageLink;
        this.userName = userName;
        this.content = content;
    }

    @Override
    public String toString() {
        return "QiuBaiEntity{" +
                "imageLink='" + imageLink + '\'' +
                ", userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
