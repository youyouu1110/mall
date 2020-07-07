package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.GoodsDao;
import com.youyouu.mall.dao.impl.GoodsDaoImpl;
import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.Type;
import com.youyouu.mall.model.bo.goods.GoodsBO;
import com.youyouu.mall.model.bo.spec.AddSpecBO;
import com.youyouu.mall.model.bo.spec.DeleteSpecBO;
import com.youyouu.mall.model.bo.spec.SpecBO;
import com.youyouu.mall.model.bo.spec.UpdateSpecBO;
import com.youyouu.mall.model.bo.type.TypeBO;
import com.youyouu.mall.model.vo.goods.GoodsVO;
import com.youyouu.mall.model.vo.goods.GoodsSearchVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.service.GoodsService;

import java.util.ArrayList;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<Type> getType() {
        return goodsDao.getType();
    }

    @Override
    public List<GoodsVO> getGoodsByType(String typeId) {
        return goodsDao.getGoodsByType(typeId);
    }

    @Override
    public void addGoods(GoodsBO goodsBO) {
        List<SpecBO> specList = goodsBO.getSpecList();
        double price = specList.get(0).getUnitPrice();
        int stockNum = specList.get(0).getStockNum();
        for (int i = 1; i < specList.size(); i++) {
            if(price > specList.get(i).getUnitPrice()){
                price = specList.get(i).getUnitPrice();
            }
            if(stockNum < specList.get(i).getStockNum()){
                stockNum = specList.get(i).getStockNum();
            }
        }
        Goods goods = new Goods(null,goodsBO.getImg(),goodsBO.getName(),price,goodsBO.getTypeId(),stockNum,goodsBO.getDesc());
        goodsDao.addGoods(goods);
        int id = goodsDao.lastInsertId();
        for (SpecBO specBO : specList) {
            Spec spec = new Spec(null, specBO.getSpecName(), specBO.getStockNum(), specBO.getUnitPrice(), id);
            goodsDao.addSpec(spec);
        }
    }

    @Override
    public void addType(TypeBO typeBO) {
        Type type = new Type(null,typeBO.getName());
        goodsDao.addType(type);
    }

    @Override
    public List<SpecInfoVO> getSpecsByGoodsId(String id) {
        List<Spec> specList = goodsDao.getSpecsByGoodsId(id);
        List<SpecInfoVO> specInfoVOList = new ArrayList<>();
        for (Spec spec : specList) {
            SpecInfoVO specInfoVO = new SpecInfoVO(spec.getId(), spec.getSpecName(), spec.getStockNum(), spec.getUnitPrice());
            specInfoVOList.add(specInfoVO);
        }
        return specInfoVOList;
    }

    @Override
    public GoodsSearchVO getGoodsByGoodsId(String id) {
        Goods good = goodsDao.getGoodsById(id);
        GoodsSearchVO goods = new GoodsSearchVO(good.getId(),good.getImg(),good.getName(),good.getDesc(),good.getTypeId()
        ,0.0);
        return goods;
    }

    @Override
    public void deleteSpec(DeleteSpecBO deleteSpecBO) {
        goodsDao.deleteSpec(deleteSpecBO);
    }

    @Override
    public Spec addSpec(AddSpecBO addSpecBO) {
        Spec spec = new Spec(null,addSpecBO.getSpecName(),addSpecBO.getStockNum(),addSpecBO.getUnitPrice(),addSpecBO.getGoodsId());
        goodsDao.addSpec(spec);
        return spec;
    }

    @Override
    public void updateGoods(Goods updateGoods) {
        goodsDao.updateGoods(updateGoods);
    }

    @Override
    public void updateSpecs(List<UpdateSpecBO> specList) {
        for (UpdateSpecBO spec : specList) {
            if(spec.getId() != null){
                goodsDao.updateSpec(spec);
            }else{
                goodsDao.insertSpec(spec);
            }
        }
    }

    @Override
    public void deleteTypeByTypeId(String typeId) {
        goodsDao.deleteTypeByTypeId(typeId);
    }

    @Override
    public void deleteGoodsById(String id) {
        goodsDao.deleteGoodsById(id);
    }
}
