package com.youyouu.mall.model.vo.spec;

public class OrderSpecInfoVO {
    private Integer id;
    private String specName;
    private double unitPrice;

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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderSpecInfoVO() {
    }

    public OrderSpecInfoVO(Integer id, String specName) {
        this.id = id;
        this.specName = specName;
        this.unitPrice = 0.0;
    }


}
