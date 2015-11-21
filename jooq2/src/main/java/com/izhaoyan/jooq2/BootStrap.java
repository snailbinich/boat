package com.izhaoyan.jooq2; /**
 * Created by zhaoyan on 15-6-24.
 */

import com.izhaoyan.jooq2.component.ExceptionTranslator;
import com.izhaoyan.jooq2.domain.tables.Author;
import com.izhaoyan.jooq2.domain.tables.Book;
import com.izhaoyan.jooq2.domain.tables.BookStore;
import com.izhaoyan.jooq2.domain.tables.BookToBookStore;
import org.jooq.*;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.jooq.util.derby.sys.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.ws.WebEndpoint;

import static com.izhaoyan.jooq2.domain.Tables.*;
import static org.jooq.impl.DSL.countDistinct;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class BootStrap {

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

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }


}