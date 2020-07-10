package com.youyouu.mall.model.bean;

import java.sql.Date;

public class Orders {
    private Integer id;
    private Integer userId;
    private String nickname;
    private String name;
    private String address;
    private String phone;
    private String goods;
    private Integer goodsId;
    private String spec;
    private Integer goodsDetailId;
    private Integer num;
    private Double amount;
    private Integer stateId;
    private Integer hasComment;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getHasComment() {
        return hasComment;
    }

    public void setHasComment(Integer hasComment) {
        this.hasComment = hasComment;
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

    public Orders() {
    }

    public Orders(Integer id, Integer userId, String nickname, String name, String address, String phone, String goods, Integer goodsId, String spec, Integer goodsDetailId, Integer num, Double amount, Integer stateId, Integer hasComment) {
        this.id = id;
        this.userId = userId;
        this.nickname = nickname;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.goods = goods;
        this.goodsId = goodsId;
        this.spec = spec;
        this.goodsDetailId = goodsDetailId;
        this.num = num;
        this.amount = amount;
        this.stateId = stateId;
        this.hasComment = hasComment;
    }
}
