package com.youyouu.mall.controller;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.AdminLoginBO;

import com.youyouu.mall.model.bo.AdminSearchBO;

import com.youyouu.mall.service.AdminService;
import com.youyouu.mall.service.impl.AdminServiceImpl;
import com.youyouu.mall.model.vo.AdminLoginVO;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        if("login".equals(action)){
            login(request,response);
        }
        if("getSearchAdmins".equals(action)){
            getSearchAdmins(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        if("allAdmins".equals(action)){
            allAdmins(request,response);
        }
    }

    //管理员登陆
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AdminLoginBO loginBo = gson.fromJson(requestBody, AdminLoginBO.class);
        Admin login = adminService.login(loginBo);
        Result result = new Result();
        if(login != null){
            AdminLoginVO loginVO = new AdminLoginVO();
            loginVO.setToken(login.getNickname());
            loginVO.setName(login.getNickname());
            response.getWriter().println(gson.toJson(Result.ok(loginVO)));
        }else{
            response.getWriter().println(gson.toJson(Result.error("用户名或密码错误")));
        }

    }

    //获取所有管理员
    private void allAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Admin> adminList = adminService.allAdmins();
        Result result = new Result();
        response.getWriter().println(gson.toJson(Result.ok(0,adminList)));
    }


    //根据email和nickname模糊查询管理员
    private void getSearchAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AdminSearchBO searchBO = gson.fromJson(requestBody, AdminSearchBO.class);
        List<Admin> adminList = adminService.getSearchAdmins(searchBO);
        response.getWriter().println(gson.toJson(Result.ok(adminList)));
    }

}
