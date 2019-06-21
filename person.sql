/*
Navicat MySQL Data Transfer

Source Server         : shxjia
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-06-21 15:18:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `idCard` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '1', '12121212', '21', '1');
INSERT INTO `person` VALUES ('3', '3', '3', '3', '3');
INSERT INTO `person` VALUES ('4', '4', '4', 'shxjia4', '4');
INSERT INTO `person` VALUES ('5', '5', '5', 'sh1', '5');
INSERT INTO `person` VALUES ('9', '1', '1', 'shxjia6', '1');
INSERT INTO `person` VALUES ('10', '1', '1', '1', '1');
INSERT INTO `person` VALUES ('11', '6', '6', 'shxjia6', '6');
