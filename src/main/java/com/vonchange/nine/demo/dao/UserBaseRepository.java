package com.vonchange.nine.demo.dao;

import com.vonchange.nine.demo.domain.UserBaseDO;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.query.BatchUpdate;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.query.ConfigLocation;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.query.DataSourceKey;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.query.ReadDataSource;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.support.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@ConfigLocation("sql.sql")
@DataSourceKey("dataSourceRead")
public interface UserBaseRepository extends BaseRepository<UserBaseDO, Long> {

  @ReadDataSource
  List<UserBaseDO> findList(@Param("userName") String userName,
                          @Param("createTime") Date createTime);
  Page<UserBaseDO> findList(Pageable pageable, @Param("userName") String userName,@Param("createTime") Date createTime);
  String findUserName(@Param("userName") String userName);

  List<UserBaseDO> findListByIds(@Param("userName") String userName,
                           @Param("createTime") Date createTime,@Param("idList")List<Long> idList);

  int updateIsDelete(@Param("isDelete") Integer isDelete,@Param("id") Long id);

  @BatchUpdate
  int batchUpdate(List<UserBaseDO> list);

  int updateTest(@Param("list")List<UserBaseDO> list);
}