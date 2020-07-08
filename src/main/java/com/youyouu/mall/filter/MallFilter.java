package com.youyouu.mall.filter;

import com.google.gson.Gson;
import com.youyouu.mall.model.Result;
import com.youyouu.mall.model.bean.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/mall/*")
public class MallFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String requestURI = request.getRequestURI();
        /*if(!request.getMethod().equals("OPTION")){
            if (auth(requestURI)) {
                Admin admin = (Admin) request.getSession().getAttribute("admin");
                if (admin == null) {
                    response.getWriter().println(new Gson().toJson(Result.error("当前接口仅登陆后可以访问")));
                    return;
                }
            }
        }*/
        chain.doFilter(req, resp);
    }

    private boolean auth(String requestURI) {
        if ("/api/admin/admin/login".equals(requestURI) || "/api/admin/admin/logoutAdmin".equals(requestURI)) {
            return false;
        }
        return true;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
