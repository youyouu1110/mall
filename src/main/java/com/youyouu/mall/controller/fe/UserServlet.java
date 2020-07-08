package com.youyouu.mall.controller.fe;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.user.UserLoginBO;
import com.youyouu.mall.model.bo.user.UserSignUpBO;
import com.youyouu.mall.model.vo.user.UserLoginVO;
import com.youyouu.mall.model.vo.user.UserSignUpVO;
import com.youyouu.mall.service.GoodsService;
import com.youyouu.mall.service.UserService;
import com.youyouu.mall.service.impl.GoodsServiceImpl;
import com.youyouu.mall.service.impl.UserServiceImpl;
import com.youyouu.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/mall/user/*")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/mall/user/", "");
        if("signup".equals(action)){
            signUp(request,response);
        }else if("login".equals(action)){
            login(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        UserSignUpBO userSignUpBO = gson.fromJson(requestBody, UserSignUpBO.class);
        UserSignUpVO user = userService.signUp(userSignUpBO);
        response.getWriter().println(gson.toJson(Result.ok(user)));
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        UserLoginBO loginBO = gson.fromJson(requestBody, UserLoginBO.class);
        User login = userService.login(loginBO);
        if(login != null){
            UserLoginVO loginVO = new UserLoginVO();
            loginVO.setToken(login.getNickname());
            loginVO.setName(login.getNickname());
            request.getSession().setAttribute("user",login);
            response.getWriter().println(gson.toJson(Result.ok(loginVO)));
        }else{
            response.getWriter().println(gson.toJson(Result.error("用户名或密码错误")));
        }
    }

}
