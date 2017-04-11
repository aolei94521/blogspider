package com.aolei.spider.entity;

import java.util.Date;

public class AnswerEntity {
    private Integer id;

    private Integer questionid;

    private String answerusername;

    private String replayusername;

    private String answercontent;

    private String replaycontent;

    private Integer status;

    private Date createtime;

    private Date replaytime;

    public AnswerEntity(Integer id, Integer questionid, String answerusername, String replayusername, String answercontent, String replaycontent, Integer status, Date createtime, Date replaytime) {
        this.id = id;
        this.questionid = questionid;
        this.answerusername = answerusername;
        this.replayusername = replayusername;
        this.answercontent = answercontent;
        this.replaycontent = replaycontent;
        this.status = status;
        this.createtime = createtime;
        this.replaytime = replaytime;
    }

    public AnswerEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getAnswerusername() {
        return answerusername;
    }

    public void setAnswerusername(String answerusername) {
        this.answerusername = answerusername == null ? null : answerusername.trim();
    }

    public String getReplayusername() {
        return replayusername;
    }

    public void setReplayusername(String replayusername) {
        this.replayusername = replayusername == null ? null : replayusername.trim();
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent == null ? null : answercontent.trim();
    }

    public String getReplaycontent() {
        return replaycontent;
    }

    public void setReplaycontent(String replaycontent) {
        this.replaycontent = replaycontent == null ? null : replaycontent.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getReplaytime() {
        return replaytime;
    }

    public void setReplaytime(Date replaytime) {
        this.replaytime = replaytime;
    }
}