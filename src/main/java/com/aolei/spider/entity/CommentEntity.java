package com.aolei.spider.entity;

public class CommentEntity {
    private Integer id;

    private Integer blogid;

    private String tbname;

    private String commentusername;

    private String commentcontent;

    private String replayusername;

    private String replaycontent;

    public CommentEntity(Integer id, Integer blogid, String tbname, String commentusername, String commentcontent, String replayusername, String replaycontent) {
        this.id = id;
        this.blogid = blogid;
        this.tbname = tbname;
        this.commentusername = commentusername;
        this.commentcontent = commentcontent;
        this.replayusername = replayusername;
        this.replaycontent = replaycontent;
    }

    public CommentEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname == null ? null : tbname.trim();
    }

    public String getCommentusername() {
        return commentusername;
    }

    public void setCommentusername(String commentusername) {
        this.commentusername = commentusername == null ? null : commentusername.trim();
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    public String getReplayusername() {
        return replayusername;
    }

    public void setReplayusername(String replayusername) {
        this.replayusername = replayusername == null ? null : replayusername.trim();
    }

    public String getReplaycontent() {
        return replaycontent;
    }

    public void setReplaycontent(String replaycontent) {
        this.replaycontent = replaycontent == null ? null : replaycontent.trim();
    }
}