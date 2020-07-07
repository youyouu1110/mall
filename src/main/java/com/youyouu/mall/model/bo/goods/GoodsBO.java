package com.youyouu.mall.model.bo.goods;

import com.youyouu.mall.model.bo.spec.SpecBO;

import java.util.List;

public class GoodsBO {
    private String name;
    private Integer typeId;
    private String img;
    private String desc;
    private List<SpecBO> specList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SpecBO> getSpecList() {
        return specList;
    }

    public void setSpecBOList(List<SpecBO> specBOList) {
        this.specList = specBOList;
    }

    public GoodsBO() {
    }

    public GoodsBO(String name, Integer typeId, String img, String desc, List<SpecBO> specList) {
        this.name = name;
        this.typeId = typeId;
        this.img = img;
        this.desc = desc;
        this.specList = specList;
    }
}
