/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-12-11 13:24:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source` (
  `id` int(11) NOT NULL,
  `subclass_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of source
-- ----------------------------
