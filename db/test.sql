/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 31/07/2024 16:06:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图书名称',
  `book_ssm` mediumtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图书描述',
  `book_auth` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图书作者',
  `category_id` bigint(0) NULL DEFAULT NULL COMMENT '图书类型（关联id）',
  `is_delete` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '软删除(0为存在，1为删除)',
  `update_test` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新测试',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Java编程思想', '深入的面向对象概念、多线程、自动项目构建、单元测试和调试等', '埃克尔', 1, '0', NULL);
INSERT INTO `book` VALUES (2, 'Java入门', '适合广大想学习一门编程语言的读者', '臧萌', 1, '0', NULL);
INSERT INTO `book` VALUES (3, '红楼梦', '以贾宝玉的所见所闻为线索，以贾府的家庭琐事。', '曹雪芹', 2, '0', NULL);
INSERT INTO `book` VALUES (6, '2', '2', '2', 2, '1', NULL);
INSERT INTO `book` VALUES (7, 'cess', 'ass', '12', 1, '1', NULL);
INSERT INTO `book` VALUES (8, '测试', '测试', '测试', 2, '1', NULL);
INSERT INTO `book` VALUES (9, '视图测试', '测试', '测试测试测试测试菜市场测试测试测试测试测试从吃到从', 3, '0', '6666');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '图书分类编号',
  `category_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名称',
  `is_delete` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '编程技术', '0');
INSERT INTO `category` VALUES (2, '文学', '0');

-- ----------------------------
-- Table structure for my_book
-- ----------------------------
DROP TABLE IF EXISTS `my_book`;
CREATE TABLE `my_book`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pages` int(0) NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `bookcaseid` int(0) NULL DEFAULT NULL,
  `abled` int(0) NULL DEFAULT NULL,
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(0) NULL DEFAULT NULL COMMENT '0表示未删除,1表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ieh6qsxp6q7oydadktc9oc8t2`(`bookcaseid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_book
-- ----------------------------
INSERT INTO `my_book` VALUES ('-1136316414', '11', NULL, NULL, NULL, 10.10, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('1', '12', '1', '1', 1, 1.00, 1, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('13132', '13', NULL, NULL, NULL, 10.10, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('2', '1', '1', '1', 1, 1.00, 1, 222, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('3', '1', '1', '1', 1, 1.00, 1, 222, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('7', '1', '1', '1', 1, 1.00, 1, 1, '1', '2024-05-14 10:59:52', NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('806637ca33c44c61bb0f06758fc26c2c', '222', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `my_book` VALUES ('9', '1', '1', '1', 1, 1.00, NULL, 1, '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for my_test
-- ----------------------------
DROP TABLE IF EXISTS `my_test`;
CREATE TABLE `my_test`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `my_json` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'json',
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'other',
  `deciale` decimal(15, 4) NULL DEFAULT NULL COMMENT '小数',
  `zz` tinyint(0) NULL DEFAULT NULL COMMENT 'true or false',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_test
-- ----------------------------
INSERT INTO `my_test` VALUES (1, '{\"name\": \"1\",\"price\": \"1.00\"}', '001', -1.2500, NULL);
INSERT INTO `my_test` VALUES (2, '123132', NULL, NULL, NULL);
INSERT INTO `my_test` VALUES (3, '测试', '002', NULL, NULL);
INSERT INTO `my_test` VALUES (4, '测试', '003', NULL, NULL);
INSERT INTO `my_test` VALUES (5, '{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}', 'other', NULL, NULL);
INSERT INTO `my_test` VALUES (6, NULL, '1321', NULL, NULL);
INSERT INTO `my_test` VALUES (7, NULL, '1322', NULL, NULL);
INSERT INTO `my_test` VALUES (8, NULL, '1323', NULL, 11);
INSERT INTO `my_test` VALUES (9, '{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}', '1321', NULL, NULL);
INSERT INTO `my_test` VALUES (10, '{\"name\": \"John\", \"age\": 31, \"city\": \"New York\"}', '1322', NULL, 1);
INSERT INTO `my_test` VALUES (11, '{\"name\": \"John\", \"age\": 32, \"city\": \"New York\"}', '1323', NULL, 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_pass` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_roles` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nick_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('admin', '1', '123456', '9', 'admin');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` bigint(0) NOT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, '1');
INSERT INTO `test` VALUES (2, '2');
INSERT INTO `test` VALUES (3, '3');

-- ----------------------------
-- View structure for test_veiw
-- ----------------------------
DROP VIEW IF EXISTS `test_veiw`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `test_veiw` AS select `book`.`book_id` AS `book_id`,`book`.`book_name` AS `book_name`,`book`.`book_ssm` AS `book_ssm`,`book`.`book_auth` AS `book_auth`,`book`.`category_id` AS `category_id`,`book`.`is_delete` AS `is_delete`,`my_book`.`id` AS `id`,`my_book`.`name` AS `name`,`my_book`.`author` AS `author`,`my_book`.`publish` AS `publish`,`my_book`.`pages` AS `pages`,`my_book`.`price` AS `price`,`my_book`.`bookcaseid` AS `bookcaseid`,`my_book`.`abled` AS `abled`,`my_book`.`create_by` AS `create_by`,`my_book`.`create_time` AS `create_time`,`my_book`.`update_by` AS `update_by`,`my_book`.`update_time` AS `update_time`,`my_book`.`del_flag` AS `del_flag` from (`book` join `my_book` on((`book`.`book_id` = `my_book`.`id`)));

SET FOREIGN_KEY_CHECKS = 1;
