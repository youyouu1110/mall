package com.youyouu.mall.service;

import com.youyouu.mall.model.bo.orders.ChangeOrderBO;
import com.youyouu.mall.model.bo.orders.PageOrderBO;
import com.youyouu.mall.model.vo.orders.OrderInfoVO;
import com.youyouu.mall.model.vo.orders.PageOrderInfoVO;
import com.youyouu.mall.model.vo.orders.PageOrdersVO;

import java.util.List;

public interface OrderService {
    PageOrdersVO ordersByPage(PageOrderBO orderBO);

    void deleteOrderById(String id);

    OrderInfoVO orderById(String id);

    void changeOrder(ChangeOrderBO orderBO);
}
