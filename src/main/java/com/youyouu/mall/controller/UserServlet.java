package com.youyouu.mall.controller;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.service.UserService;
import com.youyouu.mall.service.impl.UserServiceImpl;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/*")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");


    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/user/", "");
        if("allUser".equals(action)){
            allUser(request,response);
        }else if("deleteUser".equals(action)){
            deleteUser(request,response);
        }else if("searchUser".equals(action)){
            searchUser(request,response);
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String word = request.getParameter("word");
        List<User> userList = userService.searchUserByWord(word);
        response.getWriter().println(gson.toJson(Result.ok(userList)));
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        userService.deleteUserById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void allUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userService.allUser();
        response.getWriter().println(gson.toJson(Result.ok(userList)));
    }
}
