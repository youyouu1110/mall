package com.youyouu.mall.model.vo.goods;

import com.youyouu.mall.model.vo.spec.SpecInfoVO;

import java.util.List;

public class GoodsInfoFeVO {
    private String img;
    private String name;
    private String desc;
    private Integer typeId;
    private List<SpecInfoVO> specs;

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

    public List<SpecInfoVO> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecInfoVO> specs) {
        this.specs = specs;
    }

    public GoodsInfoFeVO() {
    }

    public GoodsInfoFeVO(String img, String name, String desc, Integer typeId, List<SpecInfoVO> specs) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.typeId = typeId;
        this.specs = specs;
    }
}
