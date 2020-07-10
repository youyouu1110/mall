package com.youyouu.mall.model.vo.question;

import java.sql.Date;

public class ReplyVO {
    private String content;
    private Date time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ReplyVO() {
    }

    public ReplyVO(String content, Date time) {
        this.content = content;
        this.time = time;
    }
}
