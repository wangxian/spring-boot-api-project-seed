/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50616
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 50616
 File Encoding         : 65001

 Date: 02/07/2019 23:45:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user1
-- ----------------------------
BEGIN;
INSERT INTO `user1` VALUES (1, '王一', '2017-11-10 22:53:37', '2019-07-02 23:44:07', NULL);
INSERT INTO `user1` VALUES (2, '王二', '2017-11-10 23:04:46', '2019-07-02 23:44:13', NULL);
INSERT INTO `user1` VALUES (3, '王三', '2019-07-02 18:11:38', '2019-07-02 23:44:17', NULL);
INSERT INTO `user1` VALUES (4, '马六', '2019-07-02 18:11:45', '2019-07-02 23:44:26', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
