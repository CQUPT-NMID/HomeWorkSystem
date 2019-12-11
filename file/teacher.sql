/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-12-11 13:25:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `tname` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `avaterurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
