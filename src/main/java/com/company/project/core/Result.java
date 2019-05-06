package com.company.project.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result<T> {

    private ResultHead head = new ResultHead();

    private T body;

    public void setHead(ResultHead head) {
        this.head = head;
    }

    public ResultHead getHead() {
        return this.head;
    }

    public T getBody() {
        return this.body;
    }

    public Result setBody(T body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
