package com.youyouu.mall.model.bo;

public class UpdateSpecBO {
    private Integer id;
    private Integer goodsId;
    private String specName;
    private Integer stockNum;
    private double unitPrice;

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

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public UpdateSpecBO() {
    }

    public UpdateSpecBO(Integer id, Integer goodsId, String specName, Integer stockNum, double unitPrice) {
        this.id = id;
        this.goodsId = goodsId;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }
}
