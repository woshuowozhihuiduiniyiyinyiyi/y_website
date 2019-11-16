-- 1.建表语句
CREATE TABLE `video_category` (
`id`  int(11) NOT NULL AUTO_INCREMENT FIRST ,
`title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL  DEFAULT '' COMMENT '分类标题' ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分类名称' ,
`description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分类描述' ,
`has_delete`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否被删除，0未删除，1已删除' ,
`created_at`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`created_by`  int(11) NOT NULL DEFAULT 0 COMMENT '创建人' ,
`updated_at`  datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP ,
`updated_by`  int(11) NOT NULL DEFAULT 0 COMMENT '更新人' ,
PRIMARY KEY (`id`)
)
;

-- 2.视频表
CREATE TABLE `video` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`category_id`  int(11) NOT NULL DEFAULT 0 COMMENT '所属分类id' ,
`name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称' ,
`title`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标题' ,
`description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述' ,
`file_path`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文件所在路径' ,
`has_top`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否置顶，0否1是',
`has_delete`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否被删除，0未删除，1已删除' ,
`created_at`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`created_by`  int(11) NOT NULL DEFAULT 0 COMMENT '创建人' ,
`updated_at`  datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP ,
`updated_by`  int(11) NOT NULL DEFAULT 0 COMMENT '更新人' ,
PRIMARY KEY (`id`)
)
;


-- 3.用户表
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`nick_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称' ,
`mobile`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号' ,
`username`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名' ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码' ,
`remain_video_num`  int(11) NOT NULL DEFAULT 0 COMMENT '剩余电影数',
`has_vip`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否会员，0否1是',
`vip_expired`  datetime NULL DEFAULT NULL COMMENT '会员过期时间',
`has_delete`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否被删除，0未删除，1已删除' ,
`created_at`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`created_by`  int(11) NOT NULL DEFAULT 0 COMMENT '创建人' ,
`updated_at`  datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP ,
`updated_by`  int(11) NOT NULL DEFAULT 0 COMMENT '更新人' ,
PRIMARY KEY (`id`)
)
;



