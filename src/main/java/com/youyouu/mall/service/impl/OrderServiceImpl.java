package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.OrderDao;
import com.youyouu.mall.dao.impl.OrderDaoImpl;
import com.youyouu.mall.model.bean.Orders;
import com.youyouu.mall.model.bo.orders.ChangeOrderBO;
import com.youyouu.mall.model.bo.orders.PageOrderBO;
import com.youyouu.mall.model.vo.orders.*;
import com.youyouu.mall.model.vo.spec.OrderSpecInfoVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public PageOrdersVO ordersByPage(PageOrderBO orderBO) {
        int total = orderDao.getTotalCounts(orderBO);
        List<PageOrderInfoVO> orderInfoVOS = orderDao.ordersByPage(orderBO);
        PageOrdersVO pageOrdersVO = new PageOrdersVO();
        pageOrdersVO.setTotal(total);
        pageOrdersVO.setOrders(orderInfoVOS);
        return pageOrdersVO;
    }

    @Override
    public void deleteOrderById(String id) {
        orderDao.deleteOrderById(id);
    }

    @Override
    public OrderInfoVO orderById(String id) {
        Orders order = orderDao.getOrderById(id);
        Integer goodsId = order.getGoodsId();
        List<OrderSpecInfoVO> specsList = orderDao.getSpecsByGoodsId(goodsId);
        List<StatesVO> states = new ArrayList<>();
        StatesVO state1 = new StatesVO(0,"未付款");
        StatesVO state2 = new StatesVO(1,"未发货");
        StatesVO state3 = new StatesVO(2,"已发货");
        StatesVO state4 = new StatesVO(3,"已完成订单");
        states.add(state1);
        states.add(state2);
        states.add(state3);
        states.add(state4);
        CurState curState = new CurState(order.getStateId());
        CurSpec curSpec = new CurSpec(order.getGoodsDetailId());
        OrderInfoVO orderInfoVO = new OrderInfoVO(order.getId(),order.getAmount(),order.getNum(),
                order.getGoodsDetailId(),order.getStateId(),order.getGoods(),specsList,states,curState,curSpec);
        return orderInfoVO;
    }

    @Override
    public void changeOrder(ChangeOrderBO orderBO) {
        Integer id = orderBO.getId();
        Orders order = orderDao.getOrderById(String.valueOf(id));
        order.setStateId(orderBO.getState());
        orderDao.updateOrder(order);
    }
}
