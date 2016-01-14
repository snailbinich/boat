package com.izhaoyan.bear.web.compent;

import com.izhaoyan.bear.web.vo.JsonResult;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaoyan on 15-12-17.
 */
public class BaseController {

    public static int DEFAULT_PAGESIZE = 20;

    public JsonResult success() {
        return new JsonResult(HttpStatus.OK.value());
    }

    public JsonResult success(Object data) {
        return new JsonResult(HttpStatus.OK.value(), data);
    }

    public JsonResult badRequest(String message) {
        return new JsonResult(HttpStatus.BAD_REQUEST.value(), message);
    }

    public JsonResult serverError(String message) {
        return new JsonResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public String redirect(String url) {
        return "redirect:" + url;
    }

    public static String getString(HttpServletRequest request, String name) {
        return request.getParameter(name);
    }


}
