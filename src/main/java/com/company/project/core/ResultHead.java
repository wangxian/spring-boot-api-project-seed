package com.company.project.core;

public class ResultHead {
    ResultCode code;
    String msg;

    public int getCode() {
        return this.code.code();
    }

    public ResultHead setCode(ResultCode code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultHead setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
