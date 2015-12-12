package com.izhaoyan.jooq2.services;

import com.izhaoyan.jooq2.dao.OrderDao;
import com.izhaoyan.jooq2.dao.ProductDao;
import com.izhaoyan.jooq2.exception.BusinessLogicException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhaoyan on 15-11-20.
 */
@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Transactional(rollbackFor = Exception.class)
    public void makeOrder(int amount) throws BusinessLogicException {

        //扣减库存
        orderDao.updateState(1,1);
        int effectRows = productDao.decreaseStock(1,amount);
        logger.info("effectRows is {}",effectRows);
        if(0 == effectRows){
           throw new BusinessLogicException("更新库存失败");
        }



    }

    public void updateOrderState(int orderId, int state){
        orderDao.updateState(orderId, state);
    }
}
