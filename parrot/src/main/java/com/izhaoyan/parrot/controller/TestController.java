package com.izhaoyan.parrot.controller;

import com.izhaoyan.parrot.component.JsonResult;
import com.izhaoyan.parrot.vo.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyan on 15-12-14.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "views/test/index";
    }

    // BindingResult 要紧跟在被 Valid 注解的后面
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginTest(
            @ModelAttribute("form") @Valid LoginForm loginForm,
            BindingResult br,
            HttpServletRequest request

    ){
//        Map<String ,Object> data = new HashMap<>();
//        data.put("loginForm", loginForm);
//        data.put("userAgent", userAgent);
            if(br.hasErrors()){
                System.out.println(br);
                StringBuffer errorMsg = new StringBuffer();
                br.getAllErrors().stream().forEach(i->{
                    errorMsg.append(i.getCode()+i.getDefaultMessage());
                });
                return  new JsonResult(HttpStatus.BAD_REQUEST.value(),errorMsg);
            }

        return new JsonResult(HttpStatus.OK.value(),loginForm);
    }
}
