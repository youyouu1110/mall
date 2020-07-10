package com.youyouu.mall.model.vo.user;

public class UserInfoVO {
    private Integer code;
    private Integer id;
    private String email;
    private String nickname;
    private String recipient;
    private String address;
    private String phone;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserInfoVO() {
    }

    public UserInfoVO(Integer code, Integer id, String email, String nickname, String recipient, String address, String phone) {
        this.code = code;
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.recipient = recipient;
        this.address = address;
        this.phone = phone;
    }
}
