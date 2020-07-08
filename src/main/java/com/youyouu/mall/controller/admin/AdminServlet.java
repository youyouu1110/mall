package com.youyouu.mall.controller.admin;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.admin.AdminBO;
import com.youyouu.mall.model.bo.admin.AdminLoginBO;

import com.youyouu.mall.model.bo.admin.AdminLogoutBO;
import com.youyouu.mall.model.bo.admin.AdminSearchBO;

import com.youyouu.mall.service.AdminService;
import com.youyouu.mall.service.impl.AdminServiceImpl;
import com.youyouu.mall.model.vo.admin.AdminLoginVO;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        }else if("getSearchAdmins".equals(action)){
            getSearchAdmins(request,response);
        }else if("updateAdminss".equals(action)){
            updateAdmin(request,response);
        }else if("changePwd".equals(action)){
            changePwd(request,response);
        }else if("logoutAdmin".equals(action)){
            logout(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        if("allAdmins".equals(action)){
            allAdmins(request,response);
        }else if("deleteAdmins".equals(action)){
            deleteAdmins(request,response);
        }else if("getAdminsInfo".equals(action)){
            getAdminsInfo(request,response);
        }
    }

    //管理员登陆
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AdminLoginBO loginBo = gson.fromJson(requestBody, AdminLoginBO.class);
        Admin login = adminService.login(loginBo);
        if(login != null){
            AdminLoginVO loginVO = new AdminLoginVO();
            loginVO.setToken(login.getNickname());
            loginVO.setName(login.getNickname());
            request.getSession().setAttribute("admin",login);
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

    private void deleteAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        adminService.deleteAdminsById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void getAdminsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Admin admin = adminService.getAdminsInfoById(id);
        response.getWriter().println(gson.toJson(Result.ok(admin)));
    }

    private void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        Admin admin = gson.fromJson(requestBody, Admin.class);
        adminService.updateAdmin(admin);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void changePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AdminBO adminBO = gson.fromJson(requestBody, AdminBO.class);
        String oldPwd = adminService.checkPwd(adminBO);
        if(!oldPwd.equals(adminBO.getOldPwd())){
            response.getWriter().println(gson.toJson(Result.error("旧密码错误!")));
            return;
        }
        if(!adminBO.getNewPwd().equals(adminBO.getConfirmPwd())){
            response.getWriter().println(gson.toJson(Result.error("两次密码输入不一致!")));
            return;
        }
        adminService.changePwd(adminBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AdminLogoutBO logoutBO = gson.fromJson(requestBody, AdminLogoutBO.class);
        response.getWriter().println(gson.toJson(Result.ok()));
    }
}
