package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.GoodsDao;
import com.youyouu.mall.dao.OrderDao;
import com.youyouu.mall.dao.UserDao;
import com.youyouu.mall.dao.impl.GoodsDaoImpl;
import com.youyouu.mall.dao.impl.OrderDaoImpl;
import com.youyouu.mall.dao.impl.UserDaoImpl;
import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Orders;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.message.MessageBO;
import com.youyouu.mall.model.bo.orders.*;
import com.youyouu.mall.model.vo.goods.GoodsFeVo;
import com.youyouu.mall.model.vo.orders.*;
import com.youyouu.mall.model.vo.spec.OrderSpecInfoVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();

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

    @Override
    public List<OrdersFeVO> getOrderByState(String state, String token) {
        List<Orders> orders = orderDao.getOrderByStateAndToken(state,token);
        List<OrdersFeVO> list = new ArrayList<>();
        for (Orders order : orders) {
            Goods goods = orderDao.getGoodsById(order.getGoodsId());
            Spec spec = orderDao.getSpecByIdAndGoodsId(order.getGoodsId(),order.getGoodsDetailId());
            double amount = order.getNum() * spec.getUnitPrice();
            GoodsFeVo goodsVo = new GoodsFeVo(goods.getId(),goods.getImg(),goods.getName(),spec.getId(),spec.getSpecName(),spec.getUnitPrice());
            OrdersFeVO orderFe = new OrdersFeVO(order.getId(),order.getStateId(),order.getNum(),amount,
                    order.getGoodsDetailId(),order.getCreatetime(),order.getHasComment(),goodsVo);
            list.add(orderFe);
        }
        return list;
    }

    @Override
    public void pay(String id) {
        orderDao.pay(id);
    }

    @Override
    public void confirmReceive(String id) {
        orderDao.confirmReceive(id);
    }

    @Override
    public void sendComment(MessageBO messageBO) {
        User user = orderDao.getUserByToken(messageBO.getToken());
        orderDao.sendComment(user.getId(),messageBO);
        orderDao.changeOrderState(messageBO.getOrderId());
    }

    @Override
    public void addOrder(AddOrderBO addOrderBO) {
        User user = userDao.getUserByToken(addOrderBO.getToken());
        Spec spec = goodsDao.getSpecById(addOrderBO.getGoodsDetailId());
        String goodsName = goodsDao.getGoodsNameByGoodsId(spec.getGoodsId());
        Orders orders = new Orders(null,user.getId(),user.getNickname(),addOrderBO.getToken(),user.getAddress(),user.getPhone(),
                goodsName,spec.getGoodsId(),spec.getSpecName(),addOrderBO.getGoodsDetailId(),addOrderBO.getNum(),addOrderBO.getAmount(),addOrderBO.getState(),0);
        orderDao.addOrder(orders);
    }

    @Override
    public void settleAccounts(ListCartBO cartList) {
        List<CartItemBO> list = cartList.getCartList();
        for (CartItemBO cartItemBO : list) {
            goodsDao.settleAccounts(cartItemBO);
        }
    }
}
