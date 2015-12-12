package com.izhaoyan.jooq2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhaoyan on 15-11-19.
 */
@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createOrder(int productId){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO orders(state, product_id) values (?,?);";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, 0);
                ps.setInt(2,productId);
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    public int updateState(int orderId, int state){
        String sql = "update orders set state = ? where id = ? limit 1";
        return jdbcTemplate.update(sql, state, orderId);
    }
}
