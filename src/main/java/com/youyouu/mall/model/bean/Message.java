package com.youyouu.mall.model.bean;

import java.sql.Date;

public class Message {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer specId;
    private String score;
    private Integer orderId;
    private String content;
    private String replyContent;
    private Integer state;
    private Date createtime;
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Message() {
    }

    public Message(Integer id, Integer userId, Integer goodsId, Integer specId, String score, Integer orderId, String content, String replyContent, Integer state) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.specId = specId;
        this.score = score;
        this.orderId = orderId;
        this.content = content;
        this.replyContent = replyContent;
        this.state = state;
    }
}
