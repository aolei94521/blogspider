package com.aolei.spider.entity;

public class JueJinEntity {
    private Integer id;

    private String title;

    private String author;

    private String link;

    private String imagelink;

    public JueJinEntity(Integer id, String title, String author, String link, String imagelink) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.link = link;
        this.imagelink = imagelink;
    }

    public JueJinEntity() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink == null ? null : imagelink.trim();
    }

    @Override
    public String toString() {
        return "JueJinEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", link='" + link + '\'' +
                ", imagelink='" + imagelink + '\'' +
                '}';
    }
}