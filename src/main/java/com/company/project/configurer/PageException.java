package com.company.project.configurer;

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
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format(
                "<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                        + "<div>Exception Message: <b>%s</b></div><body></html>",
                statusCode,
                exception == null ? "N/A" : exception.getMessage()
        );
    }
}