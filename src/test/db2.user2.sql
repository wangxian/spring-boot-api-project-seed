/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50616
 Source Host           : localhost:3306
 Source Schema         : db2

 Target Server Type    : MySQL
 Target Server Version : 50616
 File Encoding         : 65001

 Date: 02/07/2019 23:45:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user2
-- ----------------------------
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user2
-- ----------------------------
BEGIN;
INSERT INTO `user2` VALUES (1, '南海', '2018-12-22 22:53:37', '2019-07-02 23:44:42', NULL);
INSERT INTO `user2` VALUES (2, '王丽', '2018-11-10 23:04:46', '2019-07-02 18:14:46', NULL);
INSERT INTO `user2` VALUES (3, '东海', '2019-07-02 18:11:38', '2019-07-02 18:14:53', NULL);
INSERT INTO `user2` VALUES (4, '西海', '2019-07-02 18:11:45', '2019-07-02 18:14:56', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
