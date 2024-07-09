/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.31.231
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 192.168.31.231:3306
 Source Schema         : test01

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 09/07/2024 09:46:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `age` int(11) NULL DEFAULT NULL COMMENT '总额度',
  `gender` tinyint(4) NOT NULL COMMENT '性别',
  `phone` bigint(20) NULL DEFAULT NULL COMMENT '余额',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '张三', 21, 1, 1999999999, '2024-07-08 09:05:14', NULL);
INSERT INTO `t_user` VALUES (2, '张2', 22, 1, 1999999999, '2024-07-08 01:05:51', NULL);
INSERT INTO `t_user` VALUES (3, '张3', 22, 1, 1999999999, '2024-07-08 01:06:17', NULL);
INSERT INTO `t_user` VALUES (4, '张4', 22, 1, 1999999999, '2024-07-08 01:06:23', NULL);
INSERT INTO `t_user` VALUES (5, '张5', 22, 1, 1999999999, '2024-07-08 01:06:27', NULL);
INSERT INTO `t_user` VALUES (6, '张6', 22, 1, 1999999999, '2024-07-08 01:06:31', NULL);
INSERT INTO `t_user` VALUES (7, '张7', 22, 1, 1999999999, '2024-07-08 01:06:36', NULL);
INSERT INTO `t_user` VALUES (8, '张8', 22, 1, 1999999999, '2024-07-08 01:06:40', NULL);
INSERT INTO `t_user` VALUES (9, '张9', 22, 1, 1999999999, '2024-07-08 01:06:43', NULL);
INSERT INTO `t_user` VALUES (10, '张10', 22, 1, 1999999999, '2024-07-08 01:06:50', NULL);
INSERT INTO `t_user` VALUES (11, '张11', 22, 1, 1999999999, '2024-07-08 01:06:53', NULL);
INSERT INTO `t_user` VALUES (12, '张12', 22, 1, 1999999999, '2024-07-08 01:06:56', NULL);
INSERT INTO `t_user` VALUES (13, '张13', 22, 1, 1999999999, '2024-07-08 01:07:00', NULL);

SET FOREIGN_KEY_CHECKS = 1;
