package com.youyouu.mall.model.vo.goods;

public class GoodsSearchVO {
    private Integer id;
    private String img;
    private String name;
    private String desc;
    private Integer typeId;
    private double unitPrice;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public GoodsSearchVO() {
    }

    public GoodsSearchVO(Integer id, String img, String name, String desc, Integer typeId, double unitPrice) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.typeId = typeId;
        this.unitPrice = unitPrice;
    }
}
