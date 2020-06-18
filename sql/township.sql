/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : township

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-06-18 20:40:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for crop
-- ----------------------------
DROP TABLE IF EXISTS `crop`;
CREATE TABLE `crop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crop_name` varchar(255) DEFAULT NULL,
  `growth_period` bigint(255) DEFAULT NULL,
  `cost_price` bigint(11) DEFAULT NULL,
  `selling_price` bigint(11) DEFAULT NULL,
  `grow_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ripe_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of crop
-- ----------------------------
INSERT INTO `crop` VALUES ('1', 'wheat', '2', '0', '1', '2020-05-05 15:38:47', '2020-05-05 15:38:47', 'ripe');
INSERT INTO `crop` VALUES ('2', 'wheat', '2', '0', '1', '2020-05-05 18:27:41', '2020-05-05 18:27:41', 'ripe');
