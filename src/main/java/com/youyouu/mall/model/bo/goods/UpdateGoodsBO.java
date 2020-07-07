package com.youyouu.mall.model.bo.goods;

import com.youyouu.mall.model.bo.spec.UpdateSpecBO;

import java.util.List;

public class UpdateGoodsBO {
    private Integer id;
    private String name;
    private Integer typeId;
    private String img;
    private String desc;
    private List<UpdateSpecBO> specList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<UpdateSpecBO> getSpecList() {
        return specList;
    }

    public void setSpecList(List<UpdateSpecBO> specList) {
        this.specList = specList;
    }

    public UpdateGoodsBO() {
    }

    public UpdateGoodsBO(Integer id, String name, Integer typeId, String img, String desc, List<UpdateSpecBO> specList) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.img = img;
        this.desc = desc;
        this.specList = specList;
    }
}
