/*
Navicat MySQL Data Transfer

Source Server         : aliyun_docker_mysql
Source Server Version : 50729
Source Host           : 120.24.93.68:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-02-10 18:30:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

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

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `answernum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for questionhistory
-- ----------------------------
DROP TABLE IF EXISTS `questionhistory`;
CREATE TABLE `questionhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `publishdate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionhistory
-- ----------------------------

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

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `classnum` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `snumber` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `academy` varchar(30) DEFAULT NULL,
  `telephote` varchar(11) DEFAULT NULL,
  `avatarurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `suname` varchar(255) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

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

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `tname` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `avaterurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- View structure for userview
-- ----------------------------
DROP VIEW IF EXISTS `userview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `userview` AS select `student`.`email` AS `email`,`student`.`password` AS `password`,0 AS `role` from `student` union select `teacher`.`email` AS `email`,`teacher`.`password` AS `password`,1 AS `role` from `teacher` ;
