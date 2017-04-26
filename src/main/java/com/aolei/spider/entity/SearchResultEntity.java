package com.aolei.spider.entity;

/**
 * Created by Administrator on 2017/4/26.
 */
public class SearchResultEntity {
    private String title;
    private String author;
    private String data;
    private String content;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SearchResultEntity(String title, String author, String data, String content, String url) {
        this.title = title;
        this.author = author;
        this.data = data;
        this.content = content;
        this.url = url;
    }

    public SearchResultEntity() {
    }

    @Override
    public String toString() {
        return "SearchResultEntity{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", data='" + data + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
