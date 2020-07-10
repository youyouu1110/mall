package com.youyouu.mall.controller.fe;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.Message;
import com.youyouu.mall.model.bo.goods.AskGoodsBO;
import com.youyouu.mall.model.vo.goods.*;
import com.youyouu.mall.model.vo.question.QuestionVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.service.GoodsService;
import com.youyouu.mall.service.OrderService;
import com.youyouu.mall.service.impl.GoodsServiceImpl;
import com.youyouu.mall.service.impl.OrderServiceImpl;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/mall/goods/*")
public class GoodsServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/goods/", "");
        if("askGoodsMsg".equals(action)){
            askGoodsMsg(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/goods/", "");
        if("getGoodsByType".equals(action)){
            getGoodsByType(request,response);
        }else if("getGoodsInfo".equals(action)){
            getGoodsInfo(request,response);
        }else if("getGoodsMsg".equals(action)){
            getGoodsMsg(request,response);
        }else if("getGoodsComment".equals(action)){
            getGoodsComment(request,response);
        }else if("searchGoods".equals(action)){
            searchGoods(request,response);
        }
    }


    private void askGoodsMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AskGoodsBO askGoodsBO = gson.fromJson(requestBody, AskGoodsBO.class);
        goodsService.askGoodsMsg(askGoodsBO);
        response.getWriter().println(gson.toJson(Result.ok()));

    }

    private void getGoodsComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsId = request.getParameter("goodsId");
        GoodsMsgFe goodsMsgFe = goodsService.getGoodsComment(goodsId);
        response.getWriter().println(gson.toJson(Result.ok(goodsMsgFe)));
    }

    private void getGoodsMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        List<QuestionVO> questionList = goodsService.getGoodsMsg(id);
        response.getWriter().println(gson.toJson(Result.ok(questionList)));
    }

    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("typeId");
        List<GoodsVO> goodsByType = goodsService.getGoodsByType(id);
        response.getWriter().println(gson.toJson(Result.ok(goodsByType)));
    }

    private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        List<SpecInfoVO> specs = goodsService.getSpecsByGoodsId(id);
        GoodsSearchVO goodsVO = goodsService.getGoodsByGoodsId(id);
        GoodsInfoFeVO goods = new GoodsInfoFeVO(goodsVO.getImg(),goodsVO.getName(),goodsVO.getDesc(),goodsVO.getTypeId(),specs);
        response.getWriter().println(gson.toJson(Result.ok(goods)));
    }


    private void searchGoods(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");

    }
}
