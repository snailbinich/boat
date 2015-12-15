package com.izhaoyan.parrot.controller;

import com.izhaoyan.parrot.component.JsonResult;
import com.izhaoyan.parrot.vo.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
            @ModelAttribute("contentModel") LoginForm loginForm,
            HttpServletRequest request
    ){
        request.getSession(true).setAttribute("userid", 60166);
        return "redirect:/";
    }


}
