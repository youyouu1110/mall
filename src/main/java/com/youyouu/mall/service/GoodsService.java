package com.youyouu.mall.service;


import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.Type;
import com.youyouu.mall.model.bo.*;
import com.youyouu.mall.model.vo.GoodsVO;
import com.youyouu.mall.model.vo.GoodsSearchVO;
import com.youyouu.mall.model.vo.SpecInfoVO;

import java.util.List;

public interface GoodsService {

    List<Type> getType();

    List<GoodsVO> getGoodsByType(String typeId);

    void addGoods(GoodsBO goodsBO);

    void addType(TypeBO typeBO);

    List<SpecInfoVO> getSpecsByGoodsId(String id);

    GoodsSearchVO getGoodsByGoodsId(String id);

    void deleteSpec(DeleteSpecBO deleteSpecBO);

    Spec addSpec(AddSpecBO addSpecBO);

    void updateGoods(Goods updateGoods);

    void updateSpecs(List<UpdateSpecBO> specList);

    void deleteTypeByTypeId(String typeId);

    void deleteGoodsById(String id);
}
