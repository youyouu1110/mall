package com.youyouu.mall.model.vo.goods;

import com.youyouu.mall.model.vo.spec.SpecInfoVO;

import java.util.List;

public class GoodsInfoVO {
    private List<SpecInfoVO> specs;
    private GoodsSearchVO goods;

    public List<SpecInfoVO> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecInfoVO> specs) {
        this.specs = specs;
    }

    public GoodsSearchVO getGoods() {
        return goods;
    }

    public void setGoods(GoodsSearchVO goods) {
        this.goods = goods;
    }

    public GoodsInfoVO() {
    }

    public GoodsInfoVO(List<SpecInfoVO> specs, GoodsSearchVO goods) {
        this.specs = specs;
        this.goods = goods;
    }
}
