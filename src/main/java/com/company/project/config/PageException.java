package com.company.project.config;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageException implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageException.class);

    // @Override
    public String getErrorPath() {
        return "/error";
    }

    // 与 WebMvcConfigurer.configureHandlerExceptionResolvers 处理不同，这里主要是静态文件
    @RequestMapping("/error")
    @ResponseBody
    public Result handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        String message = exception == null ? "null" : exception.getMessage();
        if (statusCode == 404) {
            message = "404 PAGE NOT FOUND";
        } else {
            message = String.format("未知错误(%s), %s", statusCode, message);
        }

        return ResultGenerator.genFailResult(message, ResultCode.FAIL);
    }
}