package com.youyouu.mall.model.bean;

import java.sql.Date;

public class Question {
    private Integer id;
    private Integer goodsId;
    private Integer userId;
    private String asker;
    private String content;
    private String reply;
    private Date createtime;
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Question() {
    }

    public Question(Integer id, Integer goodsId, Integer userId, String asker, String content, String reply) {
        this.id = id;
        this.goodsId = goodsId;
        this.userId = userId;
        this.asker = asker;
        this.content = content;
        this.reply = reply;
    }
}
