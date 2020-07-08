package com.youyouu.mall.model.vo.goods;

public class GoodsVO {
    private Integer id;
    private String img;
    private String name;
    private double price;
    private Integer typeId;
    private Integer stockNum;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public GoodsVO() {
    }

    public GoodsVO(Integer id, String img, String name, double price, Integer typeId, Integer stockNum) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
        this.stockNum = stockNum;
    }
}
