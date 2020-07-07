package com.youyouu.mall.controller;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bo.orders.ChangeOrderBO;
import com.youyouu.mall.model.bo.orders.PageOrderBO;
import com.youyouu.mall.model.vo.orders.OrderInfoVO;
import com.youyouu.mall.model.vo.orders.PageOrdersVO;
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

@WebServlet("/api/admin/order/*")
public class OrderServlet extends HttpServlet {

    private Gson gson = new Gson();

    private OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/order/", "");
        if("ordersByPage".equals(action)){
            ordersByPage(request,response);
        }else if("changeOrder".equals(action)){
            changeOrder(request,response);
        }


    }

    private void changeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        ChangeOrderBO orderBO = gson.fromJson(requestBody, ChangeOrderBO.class);
        orderService.changeOrder(orderBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/order/", "");
        if("deleteOrder".equals(action)){
            deleteOrder(request,response);
        }else if("order".equals(action)){
            order(request,response);
        }
    }

    private void order(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        OrderInfoVO orderInfoVO = orderService.orderById(id);
        response.getWriter().println(gson.toJson(Result.ok(orderInfoVO)));
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        orderService.deleteOrderById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void ordersByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        PageOrderBO orderBO = gson.fromJson(requestBody, PageOrderBO.class);
        PageOrdersVO orders = orderService.ordersByPage(orderBO);
        response.getWriter().println(gson.toJson(Result.ok(orders)));
    }

}
