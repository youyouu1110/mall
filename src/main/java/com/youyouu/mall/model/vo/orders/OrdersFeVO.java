package com.youyouu.mall.model.vo.orders;

import com.youyouu.mall.model.vo.goods.GoodsFeVo;

import java.sql.Date;
import java.util.List;

public class OrdersFeVO {
    private Integer id;
    private Integer state;
    private Integer goodsNum;
    private Double amount;
    private Integer goodsDetailId;
    private Date createtime;
    private Integer hasComment;
    private GoodsFeVo goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getHasComment() {
        return hasComment;
    }

    public void setHasComment(Integer hasComment) {
        this.hasComment = hasComment;
    }

    public GoodsFeVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsFeVo goods) {
        this.goods = goods;
    }

    public OrdersFeVO() {
    }

    public OrdersFeVO(Integer id, Integer state, Integer goodsNum, Double amount, Integer goodsDetailId, Date createtime, Integer hasComment, GoodsFeVo goods) {
        this.id = id;
        this.state = state;
        this.goodsNum = goodsNum;
        this.amount = amount;
        this.goodsDetailId = goodsDetailId;
        this.createtime = createtime;
        this.hasComment = hasComment;
        this.goods = goods;
    }
}
