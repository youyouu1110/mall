package com.youyouu.mall.model.bo;

public class SpecBO {

    private String specName;
    private Integer stockNum;
    private double unitPrice;

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

    public SpecBO() {
    }

    public SpecBO(String specName, Integer stockNum, double unitPrice) {
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }
}
