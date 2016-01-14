package com.izhaoyan.bear.web.test;

import com.izhaoyan.bear.web.compent.BaseController;
import com.izhaoyan.bear.web.greeting.Greeting;
import com.izhaoyan.bear.web.vo.JsonResult;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController extends BaseController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public JsonResult test(HttpServletRequest request) {
        ServletContext servletContext = RequestContextUtils.findWebApplicationContext(request).getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return success(context.getBeanNamesForAnnotation(RestController.class));
    }
}