package com.youyouu.mall.controller.fe;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bo.message.MessageBO;
import com.youyouu.mall.model.bo.orders.AddOrderBO;
import com.youyouu.mall.model.bo.orders.ListCartBO;
import com.youyouu.mall.model.vo.goods.GoodsFeVo;
import com.youyouu.mall.model.vo.goods.GoodsInfoVO;
import com.youyouu.mall.model.vo.goods.GoodsSearchVO;
import com.youyouu.mall.model.vo.orders.OrdersFeVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.service.OrderService;
import com.youyouu.mall.service.impl.OrderServiceImpl;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/mall/order/*")
public class OrderServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/order/", "");
        if("sendComment".equals(action)){
            sendComment(request,response);
        }else if("addOrder".equals(action)){
            addOrder(request,response);
        }else if("settleAccounts".equals(action)){
            settleAccounts(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/order/", "");
        if("getOrderByState".equals(action)){
            getOrderByState(request,response);
        }else if("pay".equals(action)){
            pay(request,response);
        }else if("deleteOrder".equals(action)){
            deleteOrder(request,response);
        }else if("confirmReceive".equals(action)){
            confirmReceive(request,response);
        }
    }


    private void confirmReceive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        orderService.confirmReceive(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        orderService.deleteOrderById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        orderService.pay(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void getOrderByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String state = request.getParameter("state");
        String token = request.getParameter("token");
        List<OrdersFeVO> orders = orderService.getOrderByState(state,token);
        response.getWriter().println(gson.toJson(Result.ok(orders)));
    }


    private void sendComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        MessageBO messageBO = gson.fromJson(requestBody, MessageBO.class);
        orderService.sendComment(messageBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }


    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AddOrderBO addOrderBO = gson.fromJson(requestBody, AddOrderBO.class);
        orderService.addOrder(addOrderBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }


    private void settleAccounts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        ListCartBO cartList = gson.fromJson(requestBody, ListCartBO.class);
        orderService.settleAccounts(cartList);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

}
