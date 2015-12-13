package com.izhaoyan.parrot.controller;

import com.izhaoyan.parrot.component.JsonResult;
import com.izhaoyan.parrot.component.Pager;
import com.izhaoyan.parrot.vo.Message;
import org.jooq.util.derby.sys.Sys;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyan on 15-11-19.
 */
@Controller
public class DefaultController {


    @RequestMapping("/")
    public String index(){

        return "views/index";
    }

    @RequestMapping("/message/list")
    @ResponseBody
    public JsonResult getMessages(
            @RequestParam(required = false, defaultValue = "1") int page
    ){
//        Pager<Message> pager = new Pager<>();
        int pageSize = 10;
        int totalSize = 100;
        if(page < 1){
            page = 1;
        }




        List<Message> messageList = new ArrayList<>();
        for(int i =1; i<=totalSize;i++){
            messageList.add(new Message(i, "第"+i+"条消息"));
        }
        int startIndex = (page -1)*pageSize;
        int endIndex = startIndex+pageSize;
        if(endIndex > totalSize){
            return new JsonResult(400, "请求的数据不存在");
        }
        Pager<Message> pager = new Pager<>();
        pager.currentPage = page;
        pager.pageSize = pageSize;
        pager.totalItems = totalSize;
        pager.data = messageList.subList(startIndex, endIndex);

        return new JsonResult(200, pager);
    }
}
