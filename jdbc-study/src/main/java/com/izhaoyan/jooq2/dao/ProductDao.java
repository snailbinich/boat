package com.izhaoyan.jooq2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaoyan on 15-11-20.
 */
@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int decreaseStock(int productId, int amount){
        String sql = "update products set stock = stock - ? where id = ? and stock >= ?";
        return jdbcTemplate.update(sql, amount, productId, amount);
    }
}
