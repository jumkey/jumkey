/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2010-01-24 14:01:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `eduTime` date DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3', '林淼', '男', '20', '85.5', '2006-09-23');
INSERT INTO `student` VALUES ('4', '赵刚', '男', '21', '87.5', '2006-09-25');
INSERT INTO `student` VALUES ('5', '刘书培', '男', '21', '88.5', '2006-09-26');
INSERT INTO `student` VALUES ('6', '刘海宽', '男', '20', '89.5', '2006-09-27');
INSERT INTO `student` VALUES ('7', '蔡博远', '男', '21', '90.5', '2006-09-28');
INSERT INTO `student` VALUES ('8', '韩麒麟', '男', '21', '91.5', '2006-09-29');
INSERT INTO `student` VALUES ('9', '章爱国', '男', '20', '99', '2006-09-28');
INSERT INTO `student` VALUES ('10', '蔡晓晨', '男', '21', '93.5', '2006-10-01');
INSERT INTO `student` VALUES ('11', '唐建芳', '男', '20', '94.5', '2006-10-02');
INSERT INTO `student` VALUES ('12', '刘煜晗', '男', '21', '95.5', '2006-10-03');
INSERT INTO `student` VALUES ('13', '阳小丽', '男', '21', '96.5', '2006-10-04');
INSERT INTO `student` VALUES ('14', '郑银思', '男', '21', '97.5', '2006-10-05');
INSERT INTO `student` VALUES ('15', '王鸿净', '男', '20', '98.5', '2006-10-06');
INSERT INTO `student` VALUES ('16', '叶娜', '男', '21', '99.5', '2006-10-07');
INSERT INTO `student` VALUES ('17', '张天文', '男', '21', '99.5', '2006-10-08');
INSERT INTO `student` VALUES ('18', '邢超', '男', '21', '99.5', '2006-10-09');
INSERT INTO `student` VALUES ('19', '李顺利', '男', '20', '90', '2010-01-22');
INSERT INTO `student` VALUES ('21', '李顺利', '男', '20', '90', '2010-01-23');
INSERT INTO `student` VALUES ('22', '李顺利', '男', '20', '90', '2010-01-23');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `positional` varchar(20) DEFAULT '讲师',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'Teacher0', '女', null);
INSERT INTO `teacher` VALUES ('2', 'Teacher1', '女', null);
INSERT INTO `teacher` VALUES ('3', 'Teacher2', '女', null);
INSERT INTO `teacher` VALUES ('4', 'Teacher3', '女', null);
INSERT INTO `teacher` VALUES ('5', 'Teacher4', '女', null);
INSERT INTO `teacher` VALUES ('6', 'Teacher5', '女', null);
INSERT INTO `teacher` VALUES ('7', 'Teacher6', '女', null);
INSERT INTO `teacher` VALUES ('8', 'Teacher7', '女', null);
INSERT INTO `teacher` VALUES ('9', 'Teacher8', '女', null);
INSERT INTO `teacher` VALUES ('10', 'Teacher9', '女', null);
INSERT INTO `teacher` VALUES ('11', 'Teacher10', '女', null);
INSERT INTO `teacher` VALUES ('12', 'Teacher11', '女', null);
INSERT INTO `teacher` VALUES ('13', 'Teacher12', '女', null);
INSERT INTO `teacher` VALUES ('14', 'Teacher13', '女', null);
INSERT INTO `teacher` VALUES ('15', 'Teacher14', '女', null);
INSERT INTO `teacher` VALUES ('16', 'Teacher15', '女', null);
INSERT INTO `teacher` VALUES ('17', 'Teacher16', '女', null);
INSERT INTO `teacher` VALUES ('18', 'Teacher17', '女', null);
INSERT INTO `teacher` VALUES ('19', 'Teacher18', '女', null);
INSERT INTO `teacher` VALUES ('20', 'Teacher19', '女', null);
INSERT INTO `teacher` VALUES ('21', '老师20', '男', '讲师');
INSERT INTO `teacher` VALUES ('22', '老师21', '男', '讲师');
INSERT INTO `teacher` VALUES ('23', '老师22', '男', '讲师');
INSERT INTO `teacher` VALUES ('24', '老师23', '男', '讲师');
INSERT INTO `teacher` VALUES ('25', '老师24', '男', '讲师');
INSERT INTO `teacher` VALUES ('26', '老师25', '男', '讲师');
INSERT INTO `teacher` VALUES ('27', '老师26', '男', '讲师');
INSERT INTO `teacher` VALUES ('28', '老师27', '男', '讲师');
INSERT INTO `teacher` VALUES ('29', '老师28', '男', '讲师');
INSERT INTO `teacher` VALUES ('30', '老师29', '男', '讲师');
INSERT INTO `teacher` VALUES ('31', '老师30', '男', '讲师');
INSERT INTO `teacher` VALUES ('32', '老师31', '男', '讲师');
INSERT INTO `teacher` VALUES ('33', '老师32', '男', '讲师');
INSERT INTO `teacher` VALUES ('34', '老师33', '男', '讲师');
INSERT INTO `teacher` VALUES ('35', '老师34', '男', '讲师');
INSERT INTO `teacher` VALUES ('36', '老师35', '男', '讲师');
INSERT INTO `teacher` VALUES ('37', '老师36', '男', '讲师');
INSERT INTO `teacher` VALUES ('38', '老师37', '男', '讲师');
INSERT INTO `teacher` VALUES ('39', '老师38', '男', '讲师');
INSERT INTO `teacher` VALUES ('40', '老师39', '男', '讲师');
