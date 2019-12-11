/*
Navicat MySQL Data Transfer

Source Server         : aliyun_docker_mysql
Source Server Version : 50728
Source Host           : 120.24.93.68:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-11 13:33:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `classnum` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `snumber` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `academy` varchar(30) DEFAULT NULL,
  `telephote` varchar(11) DEFAULT NULL,
  `avatarurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
