package com.izhaoyan.jooq2.controller;

import com.izhaoyan.jooq2.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaoyan on 15-11-19.
 */
@Controller
@RequestMapping("/order")
public class DefaultController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping("/create")
    @ResponseBody
    public int createOrder(){
      return orderDao.createOrder(1);
    }
}
