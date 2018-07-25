package com.market.model;

public class Result {

    public static final int fail = -1;
    public static final int success = 0;

    private int code;
    private Object msg;
    private Object data;

    public Result(int code, Object data){
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
