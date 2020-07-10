package com.youyouu.mall.model.vo.user;

public class UserFeVO {
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserFeVO() {
    }

    public UserFeVO(String nickname) {
        this.nickname = nickname;
    }
}
