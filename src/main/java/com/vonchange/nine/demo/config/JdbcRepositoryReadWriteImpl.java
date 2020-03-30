package com.vonchange.nine.demo.config;

import com.vonchange.jdbc.abstractjdbc.core.JdbcRepository;
import com.vonchange.jdbc.abstractjdbc.model.DataSourceWrapper;
import com.vonchange.jdbc.springjdbc.repository.AbstractJbdcRepositoryMysql;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//@Component
public    class JdbcRepositoryReadWriteImpl  extends AbstractJbdcRepositoryMysql implements JdbcRepository {
    @Resource
    private DataSource dataSource;
    @Resource
    private DataSource dataSourceRead;
    private static final Random RANDOM = new Random();
    @Override
    public DataSourceWrapper getReadDataSource() {
        //含 读库
        System.out.println("IIIIII");
        List<DataSourceWrapper> dataSourceWrapperList =
                Arrays.asList(new DataSourceWrapper(dataSource,"dataSource"),
                        new DataSourceWrapper(dataSourceRead,"dataSourceRead"));
        return dataSourceWrapperList.get(RANDOM.nextInt(dataSourceWrapperList.size()));
    }

    @Override
    protected DataSourceWrapper getWriteDataSource() {
        return new DataSourceWrapper(dataSource,"dataSource");
    }

    @Override
    protected int batchSize() {
        return 5000;
    }

    @Override
    protected boolean logRead() {
        return false;
    }

    @Override
    protected boolean logWrite() {
        return false;
    }

    @Override
    protected boolean logFullSql() {
        return false;
    }


}
