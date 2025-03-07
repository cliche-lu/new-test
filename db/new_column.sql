ALTER TABLE sys_user
    ADD COLUMN levels      VARCHAR(32) NULL COMMENT '等级',
    ADD COLUMN level_score INT         NULL COMMENT '等级��';
-- ----------------------------
-- Table structure for tenant_type
-- ----------------------------
DROP TABLE IF EXISTS `tenant_type`;
CREATE TABLE `tenant_type`
(
    `id`          bigint(0)                                       NOT NULL AUTO_INCREMENT,
    `tenant_id`   int(0)                                          NOT NULL COMMENT '租户id',
    `tenant_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '租户名',
    `del_flag`    int(0)                                          NOT NULL COMMENT '0表示未删除,1表示删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_type
-- ----------------------------
INSERT INTO `tenant_type`
VALUES (1, 3, '棋友', 0);
INSERT INTO `tenant_type`
VALUES (2, 4, '其他', 0);

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE business_table
    MODIFY COLUMN join_date_start datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
    MODIFY COLUMN join_date_end datetime(0) NULL DEFAULT NULL COMMENT '结束时间'
;

alter table sys_role add role_name varchar(32) null comment '角色名称';
