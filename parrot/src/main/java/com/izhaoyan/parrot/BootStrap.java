package com.izhaoyan.parrot; /**
 * Created by zhaoyan on 15-6-24.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class BootStrap {


    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }


}