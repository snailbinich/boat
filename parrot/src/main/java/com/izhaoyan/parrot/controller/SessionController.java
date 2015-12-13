package com.izhaoyan.parrot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaoyan on 15-12-13.
 */
@Controller
public class SessionController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "views/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authenticate(
            HttpServletRequest request
    ){
        request.getSession(true).setAttribute("userid", 60166);
        return "redirect:/";
    }
}
