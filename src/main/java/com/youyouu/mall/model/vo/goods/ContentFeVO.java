package com.youyouu.mall.model.vo.goods;

import com.youyouu.mall.model.vo.user.UserFeVO;

import java.sql.Date;

public class ContentFeVO {
    private UserFeVO user;
    private String score;
    private Integer id;
    private String specName;
    private String comment;
    private Date time;
    private Integer userId;

    public UserFeVO getUser() {
        return user;
    }

    public void setUser(UserFeVO user) {
        this.user = user;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ContentFeVO() {
    }

    public ContentFeVO(UserFeVO user, String score, Integer id, String specName, String comment, Date time, Integer userId) {
        this.user = user;
        this.score = score;
        this.id = id;
        this.specName = specName;
        this.comment = comment;
        this.time = time;
        this.userId = userId;
    }
}
