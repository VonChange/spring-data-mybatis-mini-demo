package com.vonchange.nine.demo.dao;

import com.vonchange.spring.data.mybatis.mini.jdbc.repository.support.BaseQueryRepository;


public interface TestDao extends BaseQueryRepository {
    void test();
}
