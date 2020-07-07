package com.youyouu.mall.model.vo.orders;

public class StatesVO {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatesVO() {
    }

    public StatesVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
