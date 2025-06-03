DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `my` tinyint NOT NULL DEFAULT 0 COMMENT '是否我的',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name`(`tenant_id`,`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '品牌';

DROP TABLE IF EXISTS `brand_user`;
CREATE TABLE `brand_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `brand_id` bigint NOT NULL DEFAULT 0 COMMENT '品牌ID',
  `user_type` tinyint NOT NULL DEFAULT 0 COMMENT '参与者类型',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '参与者ID',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE `idx_unique`(`brand_id`,`user_id`,`user_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '品牌的参与者';

DROP TABLE IF EXISTS `brand_plate`;
CREATE TABLE `brand_plate`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `brand_id` bigint NOT NULL DEFAULT 0 COMMENT '品牌ID',
  `plate` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容平台',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE `idx_unique`(`brand_id`,`plate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '品牌的内容平台';

DROP TABLE IF EXISTS `sale_store_brand`;
CREATE TABLE `sale_store_brand`  (
  `brand_id` bigint NOT NULL DEFAULT 0 COMMENT '品牌ID',
  `store_id` bigint NOT NULL DEFAULT 0 COMMENT '店铺id',
  UNIQUE `idx_unique`(`brand_id`,`store_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '品牌的店铺';


DROP TABLE IF EXISTS `sale_store`;
CREATE TABLE `sale_store`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `eid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '店铺电商ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
  `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '主页',
  `brand_id` bigint NOT NULL DEFAULT 0 COMMENT '品牌ID',
  `eplate` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '电商平台',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态',
  `grab_sale` tinyint NOT NULL DEFAULT 0 COMMENT '是否采集销售数据',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_unique`(`eid` , `eplate`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '店铺';


DROP TABLE IF EXISTS `sale_item`;
CREATE TABLE `sale_item`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `eid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品电商ID',
  `store_id` bigint NOT NULL DEFAULT 0 COMMENT '店铺id',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
  `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '主页',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态',
  `grab_sale` tinyint NOT NULL DEFAULT 0 COMMENT '是否采集销售数据',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_unique`(`store_id` , `eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '商品';

DROP TABLE IF EXISTS `tenant_uper`;
CREATE TABLE `tenant_uper`  (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uper_id` bigint NOT NULL DEFAULT 0 COMMENT '内容账号ID',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态',
  `grab_start` datetime  NULL  COMMENT '采集开始日期',
  `grab_end` datetime  NULL  COMMENT '采集结束日期',
  `grab_hour` varchar(100) NULL COMMENT '采集时点',
    `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
	`cron` varchar(100) NULL COMMENT '定时表达式',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_unique`(`tenant_id` , `uper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户的内容账号';

DROP TABLE IF EXISTS `uper_brand`;
CREATE TABLE `uper_brand`  (
  `brand_id` bigint NOT NULL DEFAULT 0 COMMENT '品牌ID',
  `tenant_uper_id` bigint NOT NULL DEFAULT 0 COMMENT '租户的内容账号id',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE `idx_unique`(`brand_id`,`tenant_uper_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户的内容账号品牌';


DROP TABLE IF EXISTS `uper`;
CREATE TABLE `uper`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容账号ID',
  `plate` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容平台',
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '名称',
  `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '主页',
  `sex` tinyint  NULL COMMENT '性别',
  `age` int  NULL COMMENT '年龄',
  `profile` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL COMMENT '简介',
  `ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL  COMMENT 'IP',
  `area` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL  COMMENT '所在地',
  `job` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL  COMMENT '职业',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE `idx_unique`(`sid` ,`plate`) USING BTREE,
  INDEX `idx_name`(`plate`,`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '内容账号';

DROP TABLE IF EXISTS `uper_grab`;
CREATE TABLE `uper_grab`  (
  `uper_id` bigint NOT NULL DEFAULT 0 COMMENT '内容账号ID',
  `grab_date` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '采集日期',
  `grab_hour` tinyint NULL COMMENT '采集时点',
  `grab_minute` tinyint NULL COMMENT '采集分钟',
  `work_id` bigint NOT NULL DEFAULT 0 COMMENT '作品ID',
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '名称',
  `sex` tinyint  NULL COMMENT '性别',
  `age` int  NULL COMMENT '年龄',
  `profile` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL COMMENT '简介',
  `ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL  COMMENT 'IP',
  `area` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL  COMMENT '所在地',
  `job` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NULL  COMMENT '职业',
  `like` bigint NOT NULL DEFAULT 0 COMMENT '获赞量',
  `focus` bigint NOT NULL DEFAULT 0 COMMENT '关注量',
  `fans` bigint NOT NULL DEFAULT 0 COMMENT '粉丝量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  UNIQUE `idx_unique`(`uper_id`,`grab_date`,`grab_hour`,`grab_minute`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '内容账号采集';


DROP TABLE IF EXISTS `tenant_work`;
CREATE TABLE `tenant_work`  (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `work_id` bigint NOT NULL DEFAULT 0 COMMENT '作品ID',
  `brand_id` bigint COMMENT '品牌ID',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态',
  `grab_start` datetime  NULL  COMMENT '采集开始日期',
  `grab_end` datetime  NULL  COMMENT '采集结束日期',
  `grab_hour` varchar(100) NULL COMMENT '采集时点',
    `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
	`cron` varchar(100) NULL COMMENT '定时表达式',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE `idx_unique`(`tenant_id` , `work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户的作品';



DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作品ID',
  `plate` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容平台',
  `uper_id` bigint NOT NULL DEFAULT 0 COMMENT '内容账号ID',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '链接',
  `type` tinyint NULL DEFAULT 0 COMMENT '类型',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '视频链接',
  `video_sec` tinyint NOT NULL DEFAULT 0 COMMENT '视频时长',
  `pic_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片链接',
  `pic_num` tinyint NOT NULL DEFAULT 0 COMMENT '图片数量',
  `topic` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '话题',
  `area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '所在地',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pub_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE `idx_unique`(`sid`,`plate`) USING BTREE,
  INDEX `idx_uper`(`uper_id`,`plate`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '作品';


DROP TABLE IF EXISTS `work_grab`;
CREATE TABLE `work_grab`  (
  `work_id` bigint NOT NULL DEFAULT 0 COMMENT '作品ID',
  `grab_date` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '采集日期',
  `grab_hour` tinyint  NULL COMMENT '采集时点',
  `grab_minute` tinyint NULL COMMENT '采集分钟',
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '名称',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '视频链接',
  `video_sec` tinyint NULL DEFAULT 0 COMMENT '视频时长',
  `pic_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片链接',
  `pic_num` tinyint NULL DEFAULT 0 COMMENT '图片数量',
  `topic` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '话题',
  `area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '所在地',
  `like` bigint  NULL DEFAULT 0 COMMENT '获赞量',
  `collect` bigint  NULL DEFAULT 0 COMMENT '收藏量',
  `share` bigint  NULL DEFAULT 0 COMMENT '转发量',
  `comment` bigint  NULL DEFAULT 0 COMMENT '评论量',
  `read` bigint  NULL DEFAULT 0 COMMENT '阅读量',
  `watching` bigint  NULL DEFAULT 0 COMMENT '在看量',
  `coin` bigint  NULL DEFAULT 0 COMMENT '投币量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  UNIQUE `idx_unique`(`work_id`,`grab_date`,`grab_hour`,`grab_minute`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '作品采集';




DROP TABLE IF EXISTS `decs_rule`;
CREATE TABLE `decs_rule`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dimension` tinyint NOT NULL DEFAULT 0 COMMENT '决策维度',
  `uper_id` bigint NULL COMMENT '内容账号ID',
  `work_id` bigint NULL COMMENT '作品ID',
  `scene` tinyint NOT NULL DEFAULT 0 COMMENT '决策场景',
  `period` tinyint NOT NULL DEFAULT 0 COMMENT '对比周期',
  `base` bigint NULL  COMMENT '基础量',
  `variety` bigint NULL  COMMENT '变化量',
  `percent` tinyint NULL  COMMENT '变化百分比',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uper`(`tenant_id` ,`uper_id`) USING BTREE,
  INDEX `idx_work`(`tenant_id` ,`work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '决策点';

DROP TABLE IF EXISTS `decs_exec_act`;
CREATE TABLE `decs_exec_act`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `act_class` tinyint NOT NULL DEFAULT 0 COMMENT '分类',
  `action` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '动作内容',
  `spec` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '执行规格',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uper`(`tenant_id` ,`action`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '执行动作';

DROP TABLE IF EXISTS `decs_rule`;
CREATE TABLE `decs_rule`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  `dimension` tinyint NOT NULL DEFAULT 0 COMMENT '决策维度',
  `uper_id` bigint NULL COMMENT '内容账号ID',
  `work_id` bigint NULL COMMENT '作品ID',
  `scene` tinyint NOT NULL DEFAULT 0 COMMENT '决策场景',
  `period` tinyint NOT NULL DEFAULT 0 COMMENT '对比周期',
  `base` bigint NULL DEFAULT 0 COMMENT '基础量',
  `change` bigint NULL DEFAULT 0 COMMENT '变化量',
  `percent` tinyint NULL DEFAULT 0 COMMENT '变化百分比',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uper`(`tenant_id` ,`uper_id`) USING BTREE,
  INDEX `idx_work`(`tenant_id` ,`work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '决策点';


DROP TABLE IF EXISTS `decs_task`;
CREATE TABLE `decs_task`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `decs_from` tinyint NULL DEFAULT 0 COMMENT '决策来源',
  `rule_id` bigint NULL COMMENT '决策点ID',
  `rule_desc` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '决策点描述',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '决策任务状态',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '决策者ID',
  `desc` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '备注',
  `finish_time` datetime  NULL  COMMENT '执行完成时间',
  `oper_time` datetime  NULL  COMMENT '创建时间',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_state`(`tenant_id` ,`user_id`,`state`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '决策任务';


DROP TABLE IF EXISTS `decs_exec_task`;
CREATE TABLE `decs_exec_task`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `desc_task` bigint NOT NULL DEFAULT 0 COMMENT '决策任务ID',
  `decs_from` tinyint NULL DEFAULT 0 COMMENT '决策来源',
  `uper_id` bigint NULL COMMENT '内容账号ID',
  `work_id` bigint NULL COMMENT '作品ID',
  `act_id` bigint NULL COMMENT '动作ID',
  `spec_num` bigint NULL COMMENT '执行数量',
  `reserve_date` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '预约执行日期',
  `reserve_hour` tinyint NOT NULL DEFAULT 0 COMMENT '预约执行时点',
  `real_time` datetime NOT NULL COMMENT '实际执行时间',
  `finish_time` datetime  NULL  COMMENT '执行完成时间',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '决策任务状态',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '执行者ID',
  `desc` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '备注',
  `creator` bigint NOT NULL DEFAULT 0 COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint NOT NULL DEFAULT 0 COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_state`(`tenant_id` ,`user_id`,`state`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '决策任务';


DROP TABLE IF EXISTS `task_opr_log`;
CREATE TABLE `task_opr_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  `task_id` bigint NOT NULL DEFAULT 0 COMMENT '任务ID',
  `desc_task` bigint NOT NULL DEFAULT 0 COMMENT '决策任务ID',
  `step` tinyint NULL DEFAULT 0 COMMENT '执行步骤',
  `operation` tinyint NULL DEFAULT 0 COMMENT '操作动作',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '操作者ID',
  `opinion` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '意见',
  `opr_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_desc_task`(`tenant_id` ,`desc_task`,`opr_time` desc) USING BTREE,
  INDEX `idx_task`(`tenant_id` ,`task_id`,`opr_time` desc) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '任务操作日志';

DROP TABLE IF EXISTS `package`;
CREATE TABLE `package`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '套餐名称',
  `user` tinyint NULL COMMENT '子账户数',
  `uper` bigint NULL COMMENT '内容账号数',
  `uper_price` bigint NULL COMMENT '内容账号数单价',
  `work` bigint NULL COMMENT '作品数',
  `work_price` bigint NULL COMMENT '作品单价',
  `period` tinyint NULL COMMENT '收费周期',
  `user_id` bigint NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE `idx_name`(`name` ) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '套餐';

