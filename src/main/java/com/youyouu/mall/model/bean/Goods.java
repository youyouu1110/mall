package com.youyouu.mall.model.bean;

public class Goods {
    private Integer id;
    private String img;
    private String name;
    private double price;
    private Integer typeId;
    private Integer stockNum;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods() {
    }

    public Goods(Integer id, String img, String name, double price, Integer typeId, Integer stockNum, String desc) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
        this.stockNum = stockNum;
        this.desc = desc;
    }

    public Goods(Integer id, String name,Integer typeId, String img, String desc) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.typeId = typeId;
        this.desc = desc;
    }
}
