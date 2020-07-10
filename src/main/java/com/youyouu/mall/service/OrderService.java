package com.youyouu.mall.service;

import com.youyouu.mall.model.bo.message.MessageBO;
import com.youyouu.mall.model.bo.orders.AddOrderBO;
import com.youyouu.mall.model.bo.orders.ChangeOrderBO;
import com.youyouu.mall.model.bo.orders.ListCartBO;
import com.youyouu.mall.model.bo.orders.PageOrderBO;
import com.youyouu.mall.model.vo.orders.OrderInfoVO;
import com.youyouu.mall.model.vo.orders.OrdersFeVO;
import com.youyouu.mall.model.vo.orders.PageOrdersVO;

import java.util.List;

public interface OrderService {
    PageOrdersVO ordersByPage(PageOrderBO orderBO);

    void deleteOrderById(String id);

    OrderInfoVO orderById(String id);

    void changeOrder(ChangeOrderBO orderBO);

    List<OrdersFeVO> getOrderByState(String state, String token);

    void pay(String id);

    void confirmReceive(String id);

    void sendComment(MessageBO messageBO);

    void addOrder(AddOrderBO addOrderBO);

    void settleAccounts(ListCartBO cartList);
}
