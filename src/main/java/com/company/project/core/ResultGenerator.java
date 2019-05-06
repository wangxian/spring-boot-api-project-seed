package com.company.project.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 响应成功消息
     *
     * @return Result
     */
    public static Result genSuccessResult() {
        Result<String> result = new Result();
        result.getHead().setCode(ResultCode.SUCCESS).setMsg(DEFAULT_SUCCESS_MESSAGE);
        result.setBody("");
        return result;
    }

    /**
     * 响应成功消息 - 含有body
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
     * 响应失败消息
     *
     * @param message 失败消息
     *
     * @return Result
     */
    public static Result genFailResult(String message) {
        Result<String> result = new Result();
        result.getHead().setCode(ResultCode.FAIL).setMsg(message);
        result.setBody("");
        return result;
    }

    /**
     * 响应失败消息 - 可自定义失败code
     *
     * @param message 错误消息
     * @param code 错误码
     *
     * @return Result
     */
    public static Result genFailResult(String message, ResultCode code) {
        Result<String> result = new Result();
        result.getHead().setCode(code).setMsg(message);
        result.setBody("");
        return result;
    }
}
