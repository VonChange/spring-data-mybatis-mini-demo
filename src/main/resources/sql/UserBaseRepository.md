> 查询用户列表
```
-- findListX

select * from user_base
where user_name = #{userName}
and create_time  <= #{createTime}
```

> 查询用户列表 含sql 片段

```
-- findList
select * from user_base
where {@sql findListWhereSql}
```

> sql 片段
```
-- findListWhereSql
user_name = #{userName} and 1=1
{@and create_time  < createTime}
```

> 查询用户名 返回1个字段的情况 比如查询行数等
```
-- findUserName
SELECT first_phone FROM user_base WHERE user_name = #{userNamex}
```


> 根据Id列表查询列表 
```
-- findListByIds
SELECT * FROM user_base 
<where>
<if test="null!=userName"> and user_name <> #{userName} </if>
<if test="null!=idList and idList.size>0">  and id in <foreach collection="idList" index="index" item="item" open="(" separator="," close=")">#{item}</foreach></if>
<if test="null!=createTime">  and create_time < #{createTime}  </if>
</where>

```

> 根据Id列表查询列表 简写if 和in查询
```
-- findListByIds
SELECT * FROM user_base <where> 
{@and user_name <> userName}
{@and id in idList}
{@and create_time < createTime}
</where>
```

> 更新方法 update 开头

```
-- updateIsDelete
update user_base set is_delete = #{isDelete} where id =#{id}
```

```
-- batchUpdate
update user_base set is_delete = IFNULL(#{isDelete},is_delete),user_name =#{userName} where id =#{id}
```

```
-- updateTest
<foreach collection="list" index="index" item="item" >
insert into user_base(`user_name`,`first_phone`) values (#{item.userName},#{item.firstPhone});
</foreach>

```