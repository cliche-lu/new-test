/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : new-test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 26/02/2025 21:07:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business_table
-- ----------------------------
DROP TABLE IF EXISTS `business_table`;
CREATE TABLE `business_table`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `imag` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简略地点',
  `users` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '同行人们',
  `others` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '其他',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(0) NULL DEFAULT NULL COMMENT '0表示未删除,1表示删除',
  `reversion` int(0) NULL DEFAULT NULL COMMENT '版本号',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '多租户',
  `share` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分享至',
  `join_date_start` date NULL DEFAULT NULL COMMENT '时间',
  `join_date_end` date NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business_table
-- ----------------------------
INSERT INTO `business_table` VALUES (1, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 5, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (2, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 4, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (3, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 1, '1', 'test,admin', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (4, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', 'admin', '2025-02-25 16:51:36', 0, 3, '1', 'all,ceshi,test001', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (5, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', 'admin', '2025-02-25 16:51:55', 0, 5, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (6, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 1, '1', 'test0011', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (7, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 2, '1', 'test001', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (8, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 1, '2', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (9, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', 'admin', '2025-02-26 11:54:03', 1, 1, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (10, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 2, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (11, '1213', '12', '12', '6666', '12', 'test', '2025-02-18 15:10:42', '12', '2025-02-18 15:10:47', 0, 8, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (12, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', 'admin', '2025-02-25 17:24:23', 0, 2, '1', 'ceshi', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (13, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', 'admin', '2025-02-25 17:42:58', 0, 1, '1', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (14, '1213', '12', '12', '12', '12', 'test', '2025-02-18 15:10:42', 'admin', '2025-02-25 17:24:34', 0, 2, '1', 'all,ceshi,test001', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (15, '测试新增', '测试图片', '新区', 'me', '测试', 'test', '2025-02-21 17:42:24', NULL, '2025-02-21 17:42:26', 0, 0, '2', 'all', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (16, 'Some remark', '', 'Some address', 'User1,', 'Some other', 'admin', '2025-02-26 16:01:28', 'admin', '2025-02-26 16:01:28', 0, 2, '1', 'all,ceshi,test001', '2025-02-26', '2025-02-26');
INSERT INTO `business_table` VALUES (17, 'Some remark001', '', 'Some address001', 'User1,1321', 'Some other', 'admin', '2025-02-26 16:02:36', NULL, '2025-02-26 16:02:36', 0, 0, '1', 'all', '2025-02-26', '2025-02-26');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路径',
  `menu_type` int(0) NULL DEFAULT NULL COMMENT '菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)',
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单权限编码',
  `rule_flag` int(0) NULL DEFAULT NULL COMMENT '是否添加数据权限1是0否',
  `is_route` tinyint(1) NULL DEFAULT NULL COMMENT '是否路由菜单: 0:不是  1:是（默认值1）',
  `column_role` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '列权限',
  `row_role` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '行权限',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(0) NULL DEFAULT NULL COMMENT '0表示未删除,1表示删除',
  `reversion` int(0) NULL DEFAULT NULL COMMENT '版本号',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '多租户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, NULL, '测试权限', NULL, 2, 'sys:user:getUserByUserNamer', 1, 0, '1', '1', 'admin', '2025-02-18 10:42:54', 'admin', '2025-02-18 10:42:59', 0, 1, '1');
INSERT INTO `sys_permission` VALUES (2, NULL, '测试权限2', NULL, 2, 'sys:user:getNowLoginUser', 1, 0, '1', '1', 'admin', '2025-02-18 14:38:57', 'admin', '2025-02-18 14:39:04', 0, 1, '1');
INSERT INTO `sys_permission` VALUES (3, NULL, '测试权限3', NULL, 2, 'business:list', 1, 0, '1', '1', 'admin', '2025-02-18 15:01:44', 'admin', '2025-02-18 15:01:50', 0, 1, '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限类型',
  `allow_tenant` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '运行查询多租户',
  `row_role` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '行权限',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(0) NULL DEFAULT NULL COMMENT '0表示未删除,1表示删除',
  `reversion` int(0) NULL DEFAULT NULL COMMENT '版本号',
  `tenant_id` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '多租户',
  `column_role` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '列权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '1', '1', '32', 'admin', '2025-02-18 10:40:14', 'admin', '2025-02-18 10:40:18', 0, 1, '1', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NOT NULL,
  `permission` bigint(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_p_id`(`role_id`) USING BTREE,
  INDEX `permission_id`(`permission`) USING BTREE,
  CONSTRAINT `permission_id` FOREIGN KEY (`permission`) REFERENCES `sys_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_p_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` VALUES (2, 1, 2);
INSERT INTO `sys_role_permission` VALUES (3, 1, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `tenant_id` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '多租户',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号',
  `real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(0) NULL DEFAULT NULL COMMENT '0表示未删除,1表示删除',
  `reversion` int(0) NULL DEFAULT NULL COMMENT '版本号',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]', '2', '10086', 'cliche', '0', 'admin', '2025-02-14 09:47:23', 'admin', '2025-02-14 09:47:28', 0, 1, '41827738-ef99-42e2-9335-aa3f19c2ef3f');
INSERT INTO `sys_user` VALUES (2, 'test', '[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]', '2', '10026', 'clicheLL12L', '0', 'admin', '2025-02-17 17:34:28', 'admin', '2025-02-18 16:12:24', 0, 1, 'efda20a1-d3e9-4afb-991b-389ad772cb9c');
INSERT INTO `sys_user` VALUES (3, 'ceshi', '[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]', '1', '1111', 'clicheLLL', '0', 'admin', '2025-02-18 15:57:33', NULL, NULL, 0, 0, '41827738-ef99-6642e2-9335-aa3f19c2ef3f');
INSERT INTO `sys_user` VALUES (4, 'test001', '[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]', '1', '666676', '55555555', '0', 'admin', '2025-02-18 15:57:33', 'admin', '2025-02-18 17:37:58', 0, 3, '41827738-ef99-6642e2-9335-aa3f119c2ef3f');
INSERT INTO `sys_user` VALUES (5, 'admo', '[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]', '2', '18964512345', NULL, NULL, 'admo', '2025-02-26 13:51:59', NULL, '2025-02-26 13:51:59', 0, 0, '3ddb4ecc-6e3e-425a-b2c6-1b6fad702999');
INSERT INTO `sys_user` VALUES (6, 'admiw', '[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]', '2', '10086', NULL, NULL, 'admiw', '2025-02-26 13:55:16', NULL, '2025-02-26 13:55:16', 0, 0, 'aea08bfd-9d4a-4936-9197-77f3c2128ef9');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NOT NULL,
  `role_id` bigint(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
