```
-- findList
select * from user_base
where {@sql findListWhereSql}
```

```
-- findListWhereSql
user_name = #{userName} and 1=1
and create_time  < #{createTime}
```