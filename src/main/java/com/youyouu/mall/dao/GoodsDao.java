package com.youyouu.mall.dao;


import com.youyouu.mall.model.bean.*;
import com.youyouu.mall.model.bo.goods.AskGoodsBO;
import com.youyouu.mall.model.bo.orders.CartItemBO;
import com.youyouu.mall.model.bo.spec.DeleteSpecBO;
import com.youyouu.mall.model.bo.spec.UpdateSpecBO;
import com.youyouu.mall.model.vo.goods.ContentBO;
import com.youyouu.mall.model.vo.goods.GoodsVO;

import java.util.List;

public interface GoodsDao {
    List<Type> getType();

    List<GoodsVO> getGoodsByType(String typeId);

    void addGoods(Goods goods);

    int lastInsertId();

    void addSpec(Spec spec);

    void addType(Type type);

    List<Spec> getSpecsByGoodsId(String id);

    Goods getGoodsById(String id);

    void deleteSpec(DeleteSpecBO deleteSpecBO);

    void updateGoods(Goods updateGoods);

    void updateSpec(UpdateSpecBO spec);

    void deleteTypeByTypeId(String typeId);

    void deleteGoodsById(String id);

    List<Message> getMessageByState(Integer i);

    String getUserNameByUserId(Integer userId);

    String getGoodsNameByGoodsId(Integer goodsId);

    void reply(ContentBO contentBO);

    List<Message> getMessagesByGoodsId(String goodsId);

    String getSpecNameBySpecId(Integer specId);

    Integer getUserByToken(String token);

    void askGoodsMsg(Integer userId, AskGoodsBO askGoodsBO);

    List<Question> getQuestionByGoodsId(String id);

    Spec getSpecById(Integer goodsDetailId);

    void settleAccounts(CartItemBO cartItemBO);
}
