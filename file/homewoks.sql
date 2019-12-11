/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-12-11 13:24:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for homewoks
-- ----------------------------
DROP TABLE IF EXISTS `homewoks`;
CREATE TABLE `homewoks` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `subclass_id` int(11) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `info` varchar(1000) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homewoks
-- ----------------------------
