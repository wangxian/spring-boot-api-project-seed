package com.company.project.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PageException implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageException.class);

    // @Override
    public String getErrorPath() {

        return "/error";
    }

    // 与 WebMvcConfigurer.configureHandlerExceptionResolvers 处理不同，这里主要是静态文件
    @RequestMapping("/error")
    public String handleError(HttpServletResponse response) {
        // 获取statusCode:401,404,500
        Integer statusCode = response.getStatus();
        LOGGER.debug("PageException.handleError()", "status=" + statusCode);
        if (statusCode == 404) {
            return "/static/404.html";
        } else {
            return "/static/50x.html";
        }
    }
}