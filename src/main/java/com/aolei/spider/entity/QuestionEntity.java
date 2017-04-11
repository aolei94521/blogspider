package com.aolei.spider.entity;

import java.util.Date;

public class QuestionEntity {
    private Integer id;

    private String applyusername;

    private Integer status;

    private Integer likecount;

    private String questiontitle;

    private Date createtime;

    private String questioncontent;

    public QuestionEntity(Integer id, String applyusername, Integer status, Integer likecount, String questiontitle, Date createtime, String questioncontent) {
        this.id = id;
        this.applyusername = applyusername;
        this.status = status;
        this.likecount = likecount;
        this.questiontitle = questiontitle;
        this.createtime = createtime;
        this.questioncontent = questioncontent;
    }

    public QuestionEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyusername() {
        return applyusername;
    }

    public void setApplyusername(String applyusername) {
        this.applyusername = applyusername == null ? null : applyusername.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public String getQuestiontitle() {
        return questiontitle;
    }

    public void setQuestiontitle(String questiontitle) {
        this.questiontitle = questiontitle == null ? null : questiontitle.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent == null ? null : questioncontent.trim();
    }
}