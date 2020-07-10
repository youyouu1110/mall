package com.youyouu.mall.model.bo.orders;

import java.util.List;

public class ListCartBO {
    private List<CartItemBO> cartList;

    public List<CartItemBO> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartItemBO> cartList) {
        this.cartList = cartList;
    }
}
