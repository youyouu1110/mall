package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.GoodsDao;
import com.youyouu.mall.dao.impl.GoodsDaoImpl;
import com.youyouu.mall.model.bean.*;
import com.youyouu.mall.model.bo.goods.AskGoodsBO;
import com.youyouu.mall.model.bo.goods.GoodsBO;
import com.youyouu.mall.model.bo.spec.AddSpecBO;
import com.youyouu.mall.model.bo.spec.DeleteSpecBO;
import com.youyouu.mall.model.bo.spec.SpecBO;
import com.youyouu.mall.model.bo.spec.UpdateSpecBO;
import com.youyouu.mall.model.bo.type.TypeBO;
import com.youyouu.mall.model.enumaration.MessageState;
import com.youyouu.mall.model.vo.goods.*;
import com.youyouu.mall.model.vo.question.QuestionVO;
import com.youyouu.mall.model.vo.question.ReplyVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.model.vo.user.UserFeVO;
import com.youyouu.mall.model.vo.user.UserMessageBO;
import com.youyouu.mall.service.GoodsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            goodsDao.updateSpec(spec);
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

    @Override
    public List<MessageBO> noReplyMsg() {
        List<MessageBO> list = new ArrayList<>();
        List<Message> messageList = goodsDao.getMessageByState(MessageState.NO_REPLY.getCode());
        for (int i = 0; i < messageList.size(); i++) {
            Message cur = messageList.get(i);
            Integer userId = cur.getUserId();
            String userName = goodsDao.getUserNameByUserId(userId);
            UserMessageBO user = new UserMessageBO(userName);
            Integer goodsId = cur.getGoodsId();
            String goodsName = goodsDao.getGoodsNameByGoodsId(goodsId);
            GoodsMessageVO goods = new GoodsMessageVO(goodsName);
            MessageBO message = new MessageBO(cur.getId(), userId, goodsId, cur.getContent(), cur.getState(), goods, user);
            list.add(message);
        }
        return list;
    }


    @Override
    public List<MessageReplyBO> repliedMsg() {
        List<MessageReplyBO> list = new ArrayList<>();
        List<Message> messageList = goodsDao.getMessageByState(MessageState.REPLIED.getCode());
        for (int i = 0; i < messageList.size(); i++) {
            Message cur = messageList.get(i);
            Integer userId = cur.getUserId();
            String userName = goodsDao.getUserNameByUserId(userId);
            UserMessageBO user = new UserMessageBO(userName);
            Integer goodsId = cur.getGoodsId();
            String goodsName = goodsDao.getGoodsNameByGoodsId(goodsId);
            GoodsMessageVO goods = new GoodsMessageVO(goodsName);
            MessageReplyBO messageReplyBO = new MessageReplyBO(cur.getId(),userId,goodsId,cur.getContent(),cur.getReplyContent(),cur.getState(),goods,user);
            list.add(messageReplyBO);
        }
        return list;
    }

    @Override
    public void reply(ContentBO contentBO) {
        goodsDao.reply(contentBO);
    }

    @Override
    public GoodsMsgFe getGoodsComment(String goodsId) {
        List<ContentFeVO> commentList = new ArrayList<>();
        List<Message> messageList = goodsDao.getMessagesByGoodsId(goodsId);
        for (Message message : messageList) {
            String nickname = goodsDao.getUserNameByUserId(message.getUserId());
            UserFeVO user = new UserFeVO(nickname);
            String specName = goodsDao.getSpecNameBySpecId(message.getSpecId());
            ContentFeVO content = new ContentFeVO(user,message.getScore(),message.getId(),specName,message.getContent(),message.getCreatetime(),message.getUserId());
            commentList.add(content);
        }
        double sum = 0;
        for (int i = 0; i < messageList.size(); i++) {
            sum += Double.parseDouble(messageList.get(i).getScore());
        }
        double rate = sum / messageList.size();
        GoodsMsgFe goodsMsgFe = new GoodsMsgFe(commentList,rate);
        return goodsMsgFe;
    }

    @Override
    public void askGoodsMsg(AskGoodsBO askGoodsBO) {
        Integer userId = goodsDao.getUserByToken(askGoodsBO.getToken());
        goodsDao.askGoodsMsg(userId,askGoodsBO);
    }

    @Override
    public List<QuestionVO> getGoodsMsg(String id) {
        List<QuestionVO> result = new ArrayList<>();
        List<Question> questionList = goodsDao.getQuestionByGoodsId(id);
        for (Question question : questionList) {
            ReplyVO replyVO = new ReplyVO(question.getReply(),question.getUpdatetime());
            QuestionVO questionVO = new QuestionVO(question.getId(),question.getContent(),question.getAsker(),question.getCreatetime(),replyVO);
            result.add(questionVO);
        }
        return result;
    }

}
