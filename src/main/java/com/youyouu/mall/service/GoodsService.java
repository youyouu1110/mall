package com.youyouu.mall.service;


import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Message;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.Type;
import com.youyouu.mall.model.bo.goods.AskGoodsBO;
import com.youyouu.mall.model.bo.goods.GoodsBO;
import com.youyouu.mall.model.bo.spec.AddSpecBO;
import com.youyouu.mall.model.bo.spec.DeleteSpecBO;
import com.youyouu.mall.model.bo.spec.UpdateSpecBO;
import com.youyouu.mall.model.bo.type.TypeBO;
import com.youyouu.mall.model.vo.goods.*;
import com.youyouu.mall.model.vo.question.QuestionVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    List<MessageBO> noReplyMsg();

    List<MessageReplyBO> repliedMsg();

    void reply(ContentBO contentBO);

    GoodsMsgFe getGoodsComment(String goodsId);

    void askGoodsMsg(AskGoodsBO askGoodsBO);

    List<QuestionVO> getGoodsMsg(String id);
}
