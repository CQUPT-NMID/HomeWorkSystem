/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-12-11 13:24:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for subjectclass
-- ----------------------------
DROP TABLE IF EXISTS `subjectclass`;
CREATE TABLE `subjectclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `classcode` varchar(20) DEFAULT NULL,
  `classdate` varchar(255) DEFAULT NULL,
  `classavater` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subjectclass
-- ----------------------------
