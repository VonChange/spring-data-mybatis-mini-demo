package com.vonchange.nine.demo.config;


import com.vonchange.jdbc.abstractjdbc.model.DataSourceWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DBConfig implements InitializingBean {
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceRead")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    public DataSourceWrapper readDataSourceWrapper(DataSource dataSourceRead) {
        return new DataSourceWrapper(dataSourceRead,"dataSourceRead");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*DataSource dataSource=mainDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        DataSourceUtils.releaseConnection(connection,dataSource);*/
    }

}