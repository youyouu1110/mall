package com.youyouu.mall.model.vo.goods;

import com.youyouu.mall.model.vo.user.UserMessageBO;

import java.sql.Date;

public class MessageBO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String content;
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

    public MessageBO() {
    }

    public MessageBO(Integer id, Integer userId, Integer goodsId, String content, Integer state, GoodsMessageVO goods, UserMessageBO user) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.state = state;
        this.goods = goods;
        this.user = user;
    }
}
