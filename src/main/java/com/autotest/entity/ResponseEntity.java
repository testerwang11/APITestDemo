package com.autotest.entity;

public class ResponseEntity {

    private boolean success;

    private Object resStr;

    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResStr() {
        return resStr;
    }

    public void setResStr(Object resStr) {
        this.resStr = resStr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
