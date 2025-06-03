DROP TABLE IF EXISTS `temp_work`;
CREATE TABLE `temp_work`  (
  `sid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作品ID',
  `uper_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容账号ID',
  `plate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容平台',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '标题',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '类型',
  `suggest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '推荐',
  `item` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '商品',
  `view` bigint  NULL DEFAULT 0 COMMENT '阅读量',
  `review` bigint  NULL DEFAULT 0 COMMENT '评论量',
  `share` bigint  NULL DEFAULT 0 COMMENT '转发量',
  `collect` bigint  NULL DEFAULT 0 COMMENT '收藏量',
  `favor` bigint  NULL DEFAULT 0 COMMENT '获赞量',
  `pub_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL  COMMENT '链接',
  `grab_date` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '采集日期'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '作品';


DROP TABLE IF EXISTS `temp_item`;
CREATE TABLE `temp_item`  (
                              `item` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作品ID',
                              `words` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容账号ID',
                              `plate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容平台',
                              `custom` bigint  NULL DEFAULT 0 COMMENT '访客量',
                              `buy` bigint  NULL DEFAULT 0 COMMENT '支付买家数',
                              `collect` bigint  NULL DEFAULT 0 COMMENT '收藏人数',
                              `car` bigint  NULL DEFAULT 0 COMMENT '加购人数',
                              `grab_date` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '采集日期'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '商品销量';



DROP TABLE IF EXISTS `temp_work_item`;
CREATE TABLE `temp_work_item`  (
                              `sid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作品ID',
                              `item_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品ID',
                              `plate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容平台',
                              INDEX `idx_uper`(`sid`,`plate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '作品商品关系';


show global variables like 'local_infile';
set global local_infile=1;
load data local infile "D:/github/ai_framework/output.csv" into table temp_work;

load data local INFILE "D:/github/ai_framework/output.csv"
    INTO TABLE temp_work
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY ''
    IGNORE 1 ROWS;