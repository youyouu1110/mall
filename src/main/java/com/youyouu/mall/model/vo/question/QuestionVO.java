package com.youyouu.mall.model.vo.question;

import java.sql.Date;

public class QuestionVO {
    private Integer id;
    private String content;
    private String asker;
    private Date time;
    private ReplyVO reply;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ReplyVO getReply() {
        return reply;
    }

    public void setReply(ReplyVO reply) {
        this.reply = reply;
    }

    public QuestionVO() {
    }

    public QuestionVO(Integer id, String content, String asker, Date time, ReplyVO reply) {
        this.id = id;
        this.content = content;
        this.asker = asker;
        this.time = time;
        this.reply = reply;
    }
}
