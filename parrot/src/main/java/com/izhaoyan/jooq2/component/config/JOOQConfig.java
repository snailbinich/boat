package com.izhaoyan.jooq2.component.config;

import com.izhaoyan.jooq2.component.ExceptionTranslator;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * Created by zhaoyan on 15-12-12.
 */
@Configuration
public class JOOQConfig {

    @Bean
    public DataSourceConnectionProvider connectionProvider(DataSource dataSource){
        return new DataSourceConnectionProvider(transactionAwareDataSource(dataSource));
    }

    @Bean
    public ExceptionTranslator exceptionTranslator(){
        return new ExceptionTranslator();
    }

    @Bean
    DataSourceTransactionManager transactionManager (DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    public TransactionAwareDataSourceProxy transactionAwareDataSource(DataSource dataSource){
        return new TransactionAwareDataSourceProxy(dataSource);
    }


    @Bean
    public DefaultConfiguration config(DataSourceConnectionProvider connectionProvider,
                                       ExceptionTranslator exceptionTranslator){
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.setSQLDialect(SQLDialect.MYSQL);
        defaultConfiguration.setConnectionProvider(connectionProvider);
        defaultConfiguration.setExecuteListenerProvider(new DefaultExecuteListenerProvider(exceptionTranslator));
        return defaultConfiguration;
    }

    @Bean
    public DefaultDSLContext dsl(DefaultConfiguration config){
        return new DefaultDSLContext(config);
    }
}
