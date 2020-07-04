package com.youyouu.mall.model;

public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Result ok(){
        return new Result(0);
    }

    public static Result ok(Integer code,Object data){
        return new Result(code,data);
    }

    public static Result ok(Object o){
        return new Result(0,o);
    }

    public static Result error(String msg){
        return new Result(10000,msg);
    }



}
