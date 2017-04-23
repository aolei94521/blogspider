package com.aolei.spider.entity;

public class CodeCeoEntity {
    private Integer id;

    private String title;

    private String content;

    private String link;

    private String imagelink;

    private String tbName="tb_manong";

    public CodeCeoEntity(Integer id, String title, String content, String link, String imagelink) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.link = link;
        this.imagelink = imagelink;
    }

    public CodeCeoEntity() {
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

    public String getIamgelink() {
        return imagelink;
    }

    public void setIamgelink(String iamgelink) {
        this.imagelink = iamgelink == null ? null : iamgelink.trim();
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    @Override
    public String toString() {
        return "CodeCeoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", iamgelink='" + imagelink + '\'' +
                '}';
    }
}