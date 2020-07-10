package com.youyouu.mall.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.youyouu.mall.dao.OrderDao;
import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Orders;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.message.MessageBO;
import com.youyouu.mall.model.bo.orders.PageOrderBO;
import com.youyouu.mall.model.enumaration.OrderState;
import com.youyouu.mall.model.vo.orders.PageOrderInfoVO;
import com.youyouu.mall.model.vo.orders.PageOrdersVO;
import com.youyouu.mall.model.vo.spec.OrderSpecInfoVO;
import com.youyouu.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public List<PageOrderInfoVO> ordersByPage(PageOrderBO orderBO) {
        Map<String,Object> result = getDynamicSql(orderBO);
        String sql = (String) result.get("sql");
        List<Object> params = (List<Object>) result.get("params");
        String prefix_sql = "select id,userId,goodsDetailId,goods,spec,num as goodsNum,amount,stateId," +
                "nickname,name,address,phone";
        params.add(orderBO.getPagesize());
        params.add((orderBO.getCurrentPage()-1) * orderBO.getPagesize());
        List<PageOrderInfoVO> query = null;
        try {
            query = queryRunner.query(prefix_sql + sql + " limit ? offset ?", new BeanListHandler<PageOrderInfoVO>(PageOrderInfoVO.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int getTotalCounts(PageOrderBO orderBO) {
        Map<String, Object> result = getDynamicSql(orderBO);
        String sql = (String) result.get("sql");
        List<Object> params = (List<Object>) result.get("params");
        String prefix_sql = "select count(id)";
        Long query = null;
        try {
            query = queryRunner.query(prefix_sql + sql, new ScalarHandler<>(), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.intValue();
    }

    @Override
    public void deleteOrderById(String id) {
        try {
            queryRunner.update("delete from orders where id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders getOrderById(String id) {
        Orders order = null;
        try {
            order = queryRunner.query("select * from orders where id = ?", new BeanHandler<Orders>(Orders.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<OrderSpecInfoVO> getSpecsByGoodsId(Integer goodsId) {
        List<OrderSpecInfoVO> specsList = null;
        try {
            specsList = queryRunner.query("select id,specName from spec where goodsId = ?", new BeanListHandler<OrderSpecInfoVO>(OrderSpecInfoVO.class), goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specsList;
    }

    @Override
    public void updateOrder(Orders order) {
        try {
            queryRunner.update("update orders set stateId = ? where id = ?",order.getStateId(),order.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> getOrderByStateAndToken(String state, String token) {
        Map<String,Object> map = getDynamicSql_2(state,token);
        String sql = (String) map.get("sql");
        List<String> params = (List<String>) map.get("params");
        List<Orders> orders = null;
        try {
            orders = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Spec getSpecByIdAndGoodsId(Integer goodsId, Integer goodsDetailId) {
        Spec spec = null;
        try {
            spec = queryRunner.query("select * from spec where id = ? and goodsId = ?", new BeanHandler<Spec>(Spec.class),
                    goodsDetailId,goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        Goods goods  = null;
        try {
            goods = queryRunner.query("select * from goods where id = ?", new BeanHandler<Goods>(Goods.class), goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public void pay(String id) {
        try {
            queryRunner.update("update orders set stateId = ? where id = ?", OrderState.UN_SHIPED.getCode(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void confirmReceive(String id) {
        try {
            queryRunner.update("update orders set stateId = ? where id = ?", OrderState.RECEIVED.getCode(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByToken(String token) {
        User user = null;
        try {
            user = queryRunner.query("select * from user where nickname = ?", new BeanHandler<User>(User.class), token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void sendComment(Integer id, MessageBO messageBO) {
        try {
            queryRunner.update("update message set content = ?, score = ? where userId = ? and goodsId = ? and specId = ? and orderId = ?",
                    messageBO.getContent(),messageBO.getScore(),id,messageBO.getGoodsId(),messageBO.getGoodsDetailId(),messageBO.getOrderId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeOrderState(Integer orderId) {
        try {
            queryRunner.update("update orders set stateId = ? where id = ?", -1,orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder(Orders orders) {
        try {
            queryRunner.update("insert into orders(id,userId,nickname,name,address,phone,goods,goodsId,spec,goodsDetailId,num,amount,stateId,hasComment) values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    orders.getUserId(),orders.getNickname(),orders.getName(),orders.getAddress(),orders.getPhone(),orders.getGoods(),orders.getGoodsId(),orders.getSpec(),
                    orders.getGoodsDetailId(),orders.getNum(),orders.getAmount(),orders.getStateId(),orders.getHasComment());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getDynamicSql_2(String state, String token) {
        String base = "select * from orders where 1 = 1 ";
        List<String> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        if("-1".equals(state)){
            base += " and nickname = ?";
            list.add(token);
        }
        if("0".equals(state) || "1".equals(state) || "2".equals(state) || "3".equals(state)){
            base += " and stateId = ? and nickname = ?";
            list.add(state);
            list.add(token);
        }
        map.put("sql",base);
        map.put("params",list);
        return map;
    }

    private Map<String, Object> getDynamicSql(PageOrderBO orderBO) {
        String base = " from orders where 1 = 1";
        List<Object> list = new ArrayList<>();
        if(orderBO.getState() != -1){
            base += " and stateId = ? ";
            list.add(orderBO.getState());
        }
        if(!StringUtils.isEmpty(orderBO.getMoneyLimit1())){
            base += " and amount <= ?";
            list.add(Double.parseDouble(orderBO.getMoneyLimit1()));
        }
        if(!StringUtils.isEmpty(orderBO.getMoneyLimit2())){
            base += " and amount >= ?";
            list.add(Double.parseDouble(orderBO.getMoneyLimit2()));
        }
        if(!StringUtils.isEmpty(orderBO.getGoods())){
            base += " and goods like ?";
            list.add("%"+orderBO.getGoods()+"%");
        }
        if(!StringUtils.isEmpty(orderBO.getAddress())){
            base += " and address like ?";
            list.add("%"+orderBO.getAddress()+"%");
        }
        if(!StringUtils.isEmpty(orderBO.getName())){
            base += " and name like ?";
            list.add("%"+orderBO.getName()+"%");
        }
        if(!StringUtils.isEmpty(orderBO.getId())){
            base += " and id = ?";
            list.add(Integer.parseInt(orderBO.getId()));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("sql",base);
        map.put("params",list);
        return map;
    }
}
