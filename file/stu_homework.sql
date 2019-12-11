/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-12-11 13:24:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu_homework
-- ----------------------------
DROP TABLE IF EXISTS `stu_homework`;
CREATE TABLE `stu_homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `homework_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `attachurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_homework
-- ----------------------------
