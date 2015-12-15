package com.izhaoyan.parrot.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zhaoyan on 15-12-13.
 */
@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if(session == null || session.getAttribute("userid") == null){
//            response.sendRedirect("/login");
//        }

//        return super.preHandle(request, response, handler);
        return true;
    }
}
