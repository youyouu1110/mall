package com.youyouu.mall.model.vo.orders;

import com.youyouu.mall.model.vo.spec.OrderSpecInfoVO;

import java.util.List;

public class OrderInfoVO {
    private Integer id;
    private Double amount;
    private Integer num;
    private Integer goodsDetailId;
    private Integer state;
    private String goods;
    private List<OrderSpecInfoVO> spec;
    private List<StatesVO> states;
    private CurState curState;
    private CurSpec curSpec;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public List<OrderSpecInfoVO> getSpec() {
        return spec;
    }

    public void setSpec(List<OrderSpecInfoVO> spec) {
        this.spec = spec;
    }

    public List<StatesVO> getStates() {
        return states;
    }

    public void setStates(List<StatesVO> states) {
        this.states = states;
    }

    public CurState getCurState() {
        return curState;
    }

    public void setCurState(CurState curState) {
        this.curState = curState;
    }

    public CurSpec getCurSpec() {
        return curSpec;
    }

    public void setCurSpec(CurSpec curSpec) {
        this.curSpec = curSpec;
    }

    public OrderInfoVO() {
    }

    public OrderInfoVO(Integer id, Double amount, Integer num, Integer goodsDetailId, Integer state, String goods, List<OrderSpecInfoVO> spec, List<StatesVO> states, CurState curState, CurSpec curSpec) {
        this.id = id;
        this.amount = amount;
        this.num = num;
        this.goodsDetailId = goodsDetailId;
        this.state = state;
        this.goods = goods;
        this.spec = spec;
        this.states = states;
        this.curState = curState;
        this.curSpec = curSpec;
    }
}
