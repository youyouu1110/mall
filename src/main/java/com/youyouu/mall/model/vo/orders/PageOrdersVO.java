package com.youyouu.mall.model.vo.orders;

import java.util.List;

public class PageOrdersVO {
    private Integer total;

    private List<PageOrderInfoVO> orders;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<PageOrderInfoVO> getOrders() {
        return orders;
    }

    public void setOrders(List<PageOrderInfoVO> orders) {
        this.orders = orders;
    }
}
