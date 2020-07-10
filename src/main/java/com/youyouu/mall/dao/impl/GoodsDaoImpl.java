package com.youyouu.mall.dao.impl;

import com.youyouu.mall.dao.GoodsDao;
import com.youyouu.mall.model.bean.*;
import com.youyouu.mall.model.bo.goods.AskGoodsBO;
import com.youyouu.mall.model.bo.orders.CartItemBO;
import com.youyouu.mall.model.bo.spec.DeleteSpecBO;
import com.youyouu.mall.model.bo.spec.UpdateSpecBO;
import com.youyouu.mall.model.enumaration.MessageState;
import com.youyouu.mall.model.enumaration.OrderState;
import com.youyouu.mall.model.vo.goods.ContentBO;
import com.youyouu.mall.model.vo.goods.GoodsVO;
import com.youyouu.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsDaoImpl implements GoodsDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public List<Type> getType() {
        List<Type> typeList = null;
        try {
            typeList = queryRunner.query("select * from type", new BeanListHandler<Type>(Type.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }

    @Override
    public List<GoodsVO> getGoodsByType(String typeId) {
        Map<String, Object> result = getDynamicSql(typeId);
        String sql = (String) result.get("sql");
        List<String> params = (List<String>) result.get("params");
        List<GoodsVO> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<GoodsVO>(GoodsVO.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Map<String,Object> getDynamicSql(String typeId){
        String base = "select id,img,name,price,typeId,stockNum from goods where 1 = 1 ";
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if("-1".equals(typeId)){

        }else{
            base += " and typeId = ?";
            list.add(typeId);
        }
        map.put("sql",base);
        map.put("params",list);
        return map;
    }
    @Override
    public void addGoods(Goods goods) {
        try {
            queryRunner.update("insert into goods values (null,?,?,?,?,?,?)",
                    goods.getImg(),goods.getName(),goods.getPrice(),goods.getTypeId(),goods.getStockNum(),goods.getDesc());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int lastInsertId() {
        BigInteger query = null;
        try {
            query = queryRunner.query("select last_insert_id()", new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.intValue();
    }

    @Override
    public void addSpec(Spec spec) {
        try {
            queryRunner.update("insert into spec values(null,?,?,?,?)",
                    spec.getSpecName(),spec.getStockNum(),spec.getUnitPrice(),spec.getGoodsId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addType(Type type) {
        try {
            queryRunner.update("insert into type values(null,?)",type.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Spec> getSpecsByGoodsId(String id) {
        List<Spec> specs = null;
        try {
            specs = queryRunner.query("select id,specName,stockNum,unitPrice from spec where goodsId = ?",
                    new BeanListHandler<Spec>(Spec.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specs;
    }

    @Override
    public Goods getGoodsById(String id) {
        Goods goods = null;
        try {
            goods = queryRunner.query("select * from goods where id = ?", new BeanHandler<Goods>(Goods.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public void deleteSpec(DeleteSpecBO deleteSpecBO){
        try {
            queryRunner.update("delete from spec where specName = ? and goodsId = ?", deleteSpecBO.getSpecName(),deleteSpecBO.getGoodsId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGoods(Goods updateGoods) {
        try {
            queryRunner.update("update goods set img = ?, name = ?, typeId = ?, `desc` = ? where id = ?",
                    updateGoods.getImg(),updateGoods.getName(),updateGoods.getTypeId(),updateGoods.getDesc(),updateGoods.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSpec(UpdateSpecBO spec) {
        try {
            queryRunner.update("update spec set specName = ?,stockNum = ?,unitPrice = ? where id = ?",
                    spec.getSpecName(),spec.getStockNum(),spec.getUnitPrice(),spec.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTypeByTypeId(String typeId) {
        try {
            Goods goods = queryRunner.query("select * from goods where typeId = ?", new BeanHandler<Goods>(Goods.class), typeId);
            if(goods == null){
                queryRunner.update("delete from type where id = ?",typeId);
            }else{
                Integer goodsId = goods.getId();
                queryRunner.update("delete from spec where goodsId = ?",goodsId);
                queryRunner.update("delete from goods where typeId = ?",typeId);
                queryRunner.update("delete from type where typeId = ?",typeId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGoodsById(String id) {
        try {
            queryRunner.update("delete from spec where goodsId = ?",id);
            queryRunner.update("delete from goods where id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getMessageByState(Integer i) {
        List<Message> messageList = null;
        try {
            messageList = queryRunner.query("select * from message where state = ?", new BeanListHandler<Message>(Message.class), i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    @Override
    public String getUserNameByUserId(Integer userId) {
        User user = null;
        try {
            user = queryRunner.query("select nickname from user where id = ?", new BeanHandler<User>(User.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getNickname();
    }

    @Override
    public String getGoodsNameByGoodsId(Integer goodsId) {
        Goods goods = null;
        try {
            goods = queryRunner.query("select name from goods where id = ?", new BeanHandler<Goods>(Goods.class), goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods.getName();
    }

    @Override
    public void reply(ContentBO contentBO) {
        try {
            queryRunner.update("update message set replycontent = ?,state = ? where id = ?",contentBO.getContent(), MessageState.REPLIED.getCode(),contentBO.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getMessagesByGoodsId(String goodsId) {
        List<Message> messages = null;
        try {
            messages = queryRunner.query("select * from message where goodsId = ?", new BeanListHandler<Message>(Message.class), goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public String getSpecNameBySpecId(Integer specId) {
        Spec spec = null;
        try {
            spec = queryRunner.query("select * from spec where id = ?", new BeanHandler<Spec>(Spec.class), specId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec.getSpecName();
    }

    @Override
    public Integer getUserByToken(String token) {
        User user = null;
        try {
            user = queryRunner.query("select * from user where nickname = ?", new BeanHandler<User>(User.class), token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getId();

    }

    @Override
    public void askGoodsMsg(Integer userId, AskGoodsBO askGoodsBO) {
        try {
            queryRunner.update("insert into question(goodsId,userId,asker,content) values(?,?,?,?)",
                    askGoodsBO.getGoodsId(),userId,askGoodsBO.getToken(),askGoodsBO.getMsg());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Question> getQuestionByGoodsId(String id) {
        List<Question> questionList = null;
        try {
            questionList = queryRunner.query("select * from question where goodsId = ?", new BeanListHandler<Question>(Question.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    @Override
    public Spec getSpecById(Integer goodsDetailId) {
        Spec spec = null;
        try {
            spec = queryRunner.query("select * from spec where id = ?", new BeanHandler<Spec>(Spec.class), goodsDetailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec;
    }

    @Override
    public void settleAccounts(CartItemBO cartItemBO) {
        try {
            queryRunner.update("update orders set stateId = ? where id = ?",
                    OrderState.UN_SHIPED.getCode(),cartItemBO.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
