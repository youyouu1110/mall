package com.youyouu.mall.model.enumaration;

public enum MessageState {

    NO_REPLY(1,"未回复"),
    REPLIED(0,"已回复");

    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    MessageState() {
    }

    MessageState(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
