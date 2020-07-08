package com.youyouu.mall.model.vo.user;

public class UserSignUpVO {
    private Integer code;
    private String name;
    private String token;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserSignUpVO() {
    }

    public UserSignUpVO(Integer code, String name, String token) {
        this.code = code;
        this.name = name;
        this.token = token;
    }
}
