package com.company.project.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 生成响应结构体
     *
     * @return Result
     */
    public static Result genSuccessResult() {
        Result result = new Result();
        result.getHead().setCode(ResultCode.SUCCESS).setMsg(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 生成响应结构体 - 含有body
     *
     * @param body 响应数据body
     *
     * @return Result<T>
     */
    public static <T> Result<T> genSuccessResult(T body) {
        Result<T> result = new Result();
        result.getHead().setCode(ResultCode.SUCCESS).setMsg(DEFAULT_SUCCESS_MESSAGE);
        result.setBody(body);
        return result;
    }

    /**
     * 响应错误消息
     *
     * @param message 错误消息
     *
     * @return Result
     */
    public static Result genFailResult(String message) {
        Result result = new Result();
        result.getHead().setCode(ResultCode.FAIL).setMsg(message);
        return result;
    }

    /**
     * 响应错误消息 - 自定义code
     *
     * @param message 错误消息
     * @param code 错误码
     *
     * @return Result
     */
    public static Result genFailResult(String message, ResultCode code) {
        Result result = new Result();
        result.getHead().setCode(code).setMsg(message);
        return result;
    }
}
