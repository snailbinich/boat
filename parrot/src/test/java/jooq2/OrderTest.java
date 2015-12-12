package com.izhaoyan.jooq2;

import com.izhaoyan.jooq2.exception.BusinessLogicException;
import com.izhaoyan.jooq2.services.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zhaoyan on 15-11-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {BootStrap.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public void test1(){
        try {
            orderService.makeOrder(1);
        } catch (BusinessLogicException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        orderService.updateOrderState(1, 0);
    }


}
