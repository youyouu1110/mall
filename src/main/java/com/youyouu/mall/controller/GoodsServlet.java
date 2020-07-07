package com.youyouu.mall.controller;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.Goods;
import com.youyouu.mall.model.bean.Spec;
import com.youyouu.mall.model.bean.Type;
import com.youyouu.mall.model.bo.goods.GoodsBO;
import com.youyouu.mall.model.bo.goods.UpdateGoodsBO;
import com.youyouu.mall.model.bo.spec.AddSpecBO;
import com.youyouu.mall.model.bo.spec.DeleteSpecBO;
import com.youyouu.mall.model.bo.spec.UpdateSpecBO;
import com.youyouu.mall.model.bo.type.TypeBO;
import com.youyouu.mall.model.vo.goods.GoodsInfoVO;
import com.youyouu.mall.model.vo.goods.GoodsVO;
import com.youyouu.mall.model.vo.goods.GoodsSearchVO;
import com.youyouu.mall.model.vo.spec.SpecInfoVO;
import com.youyouu.mall.service.GoodsService;
import com.youyouu.mall.service.impl.GoodsServiceImpl;
import com.youyouu.mall.utils.FileUploadUtils;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/api/admin/goods/*")
public class GoodsServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/goods/", "");
        if("imgUpload".equals(action)){
            imgUpload(request,response);
        }else if("addGoods".equals(action)){
            addGoods(request,response);
        }else if("addType".equals(action)){
            addType(request,response);
        }else if("deleteSpec".equals(action)){
            deleteSpec(request,response);
        }else if("addSpec".equals(action)){
            addSpec(request,response);
        }else if("updateGoods".equals(action)){
            updateGoods(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/goods/", "");
        if("getType".equals(action)){
            getType(request,response);
        }else if("getGoodsByType".equals(action)){
            getGoodsByType(request,response);
        }else if("getGoodsInfo".equals(action)){
            getGoodsInfo(request,response);
        }else if("deleteType".equals(action)){
            deleteType(request,response);
        }else if("deleteGoods".equals(action)){
            deleteGoods(request,response);
        }

    }


    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String typeId = request.getParameter("typeId");
        List<GoodsVO> goodsList = goodsService.getGoodsByType(typeId);
        response.getWriter().println(gson.toJson(Result.ok(goodsList)));
    }

    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Type> typeList = goodsService.getType();
        response.getWriter().println(gson.toJson(Result.ok(typeList)));
    }

    private void imgUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = FileUploadUtils.parseRequest(request);
        String file = (String) map.get("file");
        String domain = (String) getServletContext().getAttribute("domain");
        response.getWriter().println(gson.toJson(Result.ok(domain + file)));
    }

    private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        GoodsBO goodsBO = gson.fromJson(requestBody, GoodsBO.class);
        goodsService.addGoods(goodsBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void addType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        TypeBO typeBO = gson.fromJson(requestBody, TypeBO.class);
        goodsService.addType(typeBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        List<SpecInfoVO> specs = goodsService.getSpecsByGoodsId(id);
        GoodsSearchVO goods = goodsService.getGoodsByGoodsId(id);
        GoodsInfoVO goodsInfoVO = new GoodsInfoVO(specs,goods);
        response.getWriter().println(gson.toJson(Result.ok(goodsInfoVO)));
    }


    private void deleteSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        DeleteSpecBO deleteSpecBO = gson.fromJson(requestBody, DeleteSpecBO.class);
        goodsService.deleteSpec(deleteSpecBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void addSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AddSpecBO addSpecBO = gson.fromJson(requestBody, AddSpecBO.class);
        Spec spec = goodsService.addSpec(addSpecBO);
        response.getWriter().println(gson.toJson(Result.ok(spec)));
    }

    private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        UpdateGoodsBO updateGoodsBO = gson.fromJson(requestBody, UpdateGoodsBO.class);
        Goods updateGoods = new Goods(updateGoodsBO.getId(),updateGoodsBO.getName(),updateGoodsBO.getTypeId(),updateGoodsBO.getImg(),updateGoodsBO.getDesc());
        goodsService.updateGoods(updateGoods);
        List<UpdateSpecBO> specList = updateGoodsBO.getSpecList();
        goodsService.updateSpecs(specList);
        response.getWriter().println(gson.toJson(Result.ok()));
    }


    private void deleteType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String typeId = request.getParameter("typeId");
        goodsService.deleteTypeByTypeId(typeId);
        response.getWriter().println(gson.toJson(Result.ok()));
    }


    private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        goodsService.deleteGoodsById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }
}
