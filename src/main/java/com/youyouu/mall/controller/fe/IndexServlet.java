package com.youyouu.mall.controller.fe;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.Type;
import com.youyouu.mall.model.vo.goods.GoodsVO;
import com.youyouu.mall.service.GoodsService;
import com.youyouu.mall.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/mall/index/*")
public class IndexServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/index/", "");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/index/", "");
        if("getType".equals(action)){
            getType(request,response);
        }
    }


    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Type> type = goodsService.getType();
        response.getWriter().println(gson.toJson(Result.ok(type)));
    }
}
