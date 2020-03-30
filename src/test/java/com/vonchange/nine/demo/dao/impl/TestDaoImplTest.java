package com.vonchange.nine.demo.dao.impl;

import com.vonchange.nine.demo.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDaoImplTest {

    @Resource
    private TestDao testDao;
    @Test
    public void test1() {
        testDao.test();
    }
}