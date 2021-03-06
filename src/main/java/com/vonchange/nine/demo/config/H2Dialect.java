package com.vonchange.nine.demo.config;


import com.vonchange.mybatis.common.util.ConvertUtil;
import com.vonchange.mybatis.common.util.StringUtils;
import com.vonchange.mybatis.config.Constant;
import com.vonchange.mybatis.dialect.Dialect;
import com.vonchange.mybatis.dialect.LikeTemplate;


/**
 *mysql方言
 * @author von_change@163.com
 *  2015-6-14 下午12:47:21
 */
public class H2Dialect implements Dialect {

    @Override
    public String getPageSql(String sql, int beginNo, int pageSize)  {
    	return 	StringUtils.format("{0} limit {1},{2} ", sql, ConvertUtil.toString(beginNo), ConvertUtil.toString(pageSize));
    }



    @Override
    public int getBigDataFetchSize() {
        return 200;
    }

    @Override
    public int getFetchSize() {
        return -1;
    }

    @Override
    public String getDialogName() {
        return Constant.Dialog.MYSQL;
    }

    @Override
    public LikeTemplate getLikeTemplate() {
        return new LikeTemplate(" CONCAT(''%'',#'{'{0}'}',''%'') "," CONCAT(''%'',#'{'{0}'}')"," CONCAT(#'{'{0}'}',''%'') ");
    }
}
