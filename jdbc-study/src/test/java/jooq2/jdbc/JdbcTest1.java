package jooq2.jdbc;

import com.izhaoyan.jooq2.BootStrap;
import com.izhaoyan.jooq2.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


/**
 * Created by zhaoyan on 15-11-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {BootStrap.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class JdbcTest1 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
       String sql = "select count(0) from products ;";
        Integer totalCount= jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("total product count is "+totalCount);

    }

    @Test
    public void test2(){
        String sql = "select * from countries limit 1;";

//        List<Country> countryList = jdbcTemplate.queryForList(sql, Country.class);
//        List<Country> countryList = jdbcTemplate.query(sql, new BeanPropertyRowMapperCustom<Country>(clazz), args);
//        for(Country country:countryList){
//            System.out.println(country);
//        }
    }



}
