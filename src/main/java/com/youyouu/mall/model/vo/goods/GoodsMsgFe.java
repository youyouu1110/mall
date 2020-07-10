package com.youyouu.mall.model.vo.goods;

import com.youyouu.mall.model.vo.user.UserFeVO;

import java.util.List;

public class GoodsMsgFe {
    private List<ContentFeVO> commentList;
    private Double rate;

    public List<ContentFeVO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<ContentFeVO> commentList) {
        this.commentList = commentList;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public GoodsMsgFe() {
    }

    public GoodsMsgFe(List<ContentFeVO> commentList, Double rate) {
        this.commentList = commentList;
        this.rate = rate;
    }
}
