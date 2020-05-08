SET MODE=MySQL;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `id` bigint(13) NOT NULL AUTO_INCREMENT COMMENT 'id序列，自增',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `mobile_phone` varchar(13) DEFAULT NULL COMMENT '手机号',
  `address` varchar(20) DEFAULT NULL COMMENT 'address',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into user_base(user_name,mobile_phone,address,create_time) values ('张三','120','xxx',now());
insert into user_base(user_name,mobile_phone,address,create_time) values ('李4','110','xxx额',now());
insert into user_base(user_name,mobile_phone,address,create_time) values ('张三日子','911','xxx是啥',now());
insert into user_base(user_name,mobile_phone,address,create_time) values ('test','333','ufo',now());