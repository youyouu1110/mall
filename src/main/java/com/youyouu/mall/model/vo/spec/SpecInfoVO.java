package com.youyouu.mall.model.vo.spec;

public class SpecInfoVO {
    private Integer id;
    private String specName;
    private Integer stockNum;
    private Double unitPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SpecInfoVO() {
    }

    public SpecInfoVO(Integer id, String specName, Integer stockNum, Double unitPrice) {
        this.id = id;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }
}
