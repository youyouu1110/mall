package com.youyouu.mall.model.bo.admin;

public class AdminLoginBO {
    /*
    bo: business object
        请求报文中需要的对象
    vo:view object
         响应报文中需要的对象
    */

    private String email;
    private String pwd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "AdminLoginBO{" +
                "email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
