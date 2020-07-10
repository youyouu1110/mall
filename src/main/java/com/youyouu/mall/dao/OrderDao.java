package com.youyouu.mall.dao;

import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Orders;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.message.MessageBO;
import com.youyouu.mall.model.bo.orders.PageOrderBO;
import com.youyouu.mall.model.vo.orders.PageOrderInfoVO;
import com.youyouu.mall.model.vo.orders.PageOrdersVO;
import com.youyouu.mall.model.vo.spec.OrderSpecInfoVO;

import java.util.List;

public interface OrderDao {
    List<PageOrderInfoVO> ordersByPage(PageOrderBO orderBO);

    int getTotalCounts(PageOrderBO orderBO);

    void deleteOrderById(String id);

    Orders getOrderById(String id);

    List<OrderSpecInfoVO> getSpecsByGoodsId(Integer goodsId);

    void updateOrder(Orders order);

    List<Orders> getOrderByStateAndToken(String state, String token);

    Spec getSpecByIdAndGoodsId(Integer goodsId, Integer goodsDetailId);

    Goods getGoodsById(Integer goodsId);

    void pay(String id);

    void confirmReceive(String id);

    User getUserByToken(String token);

    void sendComment(Integer id, MessageBO messageBO);

    void changeOrderState(Integer orderId);

    void addOrder(Orders orders);
}
