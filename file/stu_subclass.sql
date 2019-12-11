/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-12-11 13:24:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu_subclass
-- ----------------------------
DROP TABLE IF EXISTS `stu_subclass`;
CREATE TABLE `stu_subclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuid` int(11) DEFAULT NULL,
  `sscid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_subclass
-- ----------------------------
