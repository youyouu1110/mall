package com.youyouu.mall.model.vo.goods;

import com.youyouu.mall.model.vo.user.UserMessageBO;

import java.sql.Date;

public class MessageReplyBO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String content;
    private String replyContent;
    private Integer state;
    private Date createtime;
    private GoodsMessageVO goods;
    private UserMessageBO user;

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

    public GoodsMessageVO getGoods() {
        return goods;
    }

    public void setGoods(GoodsMessageVO goods) {
        this.goods = goods;
    }

    public UserMessageBO getUser() {
        return user;
    }

    public void setUser(UserMessageBO user) {
        this.user = user;
    }

    public MessageReplyBO(Integer id, Integer userId, Integer goodsId, String content, String replyContent, Integer state, GoodsMessageVO goods, UserMessageBO user) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.replyContent = replyContent;
        this.state = state;
        this.goods = goods;
        this.user = user;
    }
}
