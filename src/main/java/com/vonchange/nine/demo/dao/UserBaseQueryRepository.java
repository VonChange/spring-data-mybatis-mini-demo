package com.vonchange.nine.demo.dao;

import com.vonchange.nine.demo.domain.UserBaseDO;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.support.BaseQueryRepository;

import java.util.Date;
import java.util.List;



public interface UserBaseQueryRepository extends BaseQueryRepository {

  List<UserBaseDO> findList(@org.apache.ibatis.annotations.Param("userName") String userName,
                            @org.apache.ibatis.annotations.Param("createTime") Date createTime);
}