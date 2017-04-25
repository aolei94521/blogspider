package com.aolei.spider.entity;

public class CNBlogsEntity {
    private Integer id;

    private String title;

    private String author;

    private String content;

    private String link;

    private String tbName="tb_cnblogs";

    private int collectionStatus = 0;//默认未收藏
    public int getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(int collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public CNBlogsEntity(Integer id, String title, String author, String content, String link) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.link = link;
    }

    public CNBlogsEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    @Override
    public String toString() {
        return "CNBlogsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}