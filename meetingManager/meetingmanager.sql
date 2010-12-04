/*
Navicat MySQL Data Transfer

Source Server         : meetingManager
Source Server Version : 50144
Source Host           : localhost:3306
Source Database       : meetingmanager

Target Server Type    : MYSQL
Target Server Version : 50144
File Encoding         : 65001

Date: 2010-12-03 21:07:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `activities`
-- ----------------------------
DROP TABLE IF EXISTS `activities`;
CREATE TABLE `activities` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `person` varchar(20) DEFAULT NULL,
  `desc1` text,
  `day` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobilephone` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK7A1B3BED6B3D95E3` (`meetingid`),
  CONSTRAINT `FK7A1B3BED6B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of activities
-- ----------------------------
INSERT INTO `activities` VALUES ('2', '2', '活动一', '2010-12-09 00:00:00', 'FBI', '活动中.....', '2', '05718888888', '1588888888');

-- ----------------------------
-- Table structure for `agreement`
-- ----------------------------
DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT NULL,
  `mdate` timestamp NULL DEFAULT NULL,
  `meetingid` int(11) DEFAULT NULL,
  `travelContact` varchar(20) DEFAULT NULL COMMENT '旅行社联系人',
  `travelPhone` varchar(11) DEFAULT NULL COMMENT '旅行社电话',
  `hotelContacts` varchar(20) DEFAULT NULL COMMENT '酒店联系人',
  `hotelPhone` varchar(11) DEFAULT NULL COMMENT '酒店电话',
  `hoteldeposit` double DEFAULT NULL COMMENT '酒店押金(浮点数)',
  PRIMARY KEY (`Id`),
  KEY `FK3A29520A6B3D95E3` (`meetingid`),
  CONSTRAINT `agreement_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `FK3A29520A6B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of agreement
-- ----------------------------
INSERT INTO `agreement` VALUES ('1', '2010-10-01 00:00:00', '2010-10-03 00:00:00', '2', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('5', null, '2010-10-15 00:00:00', '3', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('6', null, '2010-10-22 00:00:00', '4', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('7', null, '2010-10-14 00:00:00', '6', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('8', null, '2010-10-10 00:00:00', '7', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('9', '2010-10-15 00:00:00', '2010-10-15 00:00:00', '8', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('10', '2010-10-14 00:00:00', '2010-10-14 00:00:00', '9', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('11', '2010-10-13 00:00:00', '2010-10-13 00:00:00', '10', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('12', '2010-10-23 00:00:00', '2010-10-22 00:00:00', '11', null, null, null, null, null);
INSERT INTO `agreement` VALUES ('13', '2010-10-20 00:00:00', '2010-10-21 00:00:00', '12', null, null, null, null, null);

-- ----------------------------
-- Table structure for `arrangementsseminars`
-- ----------------------------
DROP TABLE IF EXISTS `arrangementsseminars`;
CREATE TABLE `arrangementsseminars` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingArrangements` int(11) DEFAULT NULL,
  `lecture` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `timelength` int(11) DEFAULT NULL,
  `recorder` varchar(50) DEFAULT NULL,
  `recorddate` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKCDF76D6BC139F4AC` (`meetingArrangements`),
  KEY `FKCDF76D6B4C9DF0C0` (`lecture`),
  CONSTRAINT `FKCDF76D6B4C9DF0C0` FOREIGN KEY (`lecture`) REFERENCES `lecture` (`Id`),
  CONSTRAINT `FKCDF76D6BC139F4AC` FOREIGN KEY (`meetingArrangements`) REFERENCES `meetingarrangements` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of arrangementsseminars
-- ----------------------------

-- ----------------------------
-- Table structure for `awards`
-- ----------------------------
DROP TABLE IF EXISTS `awards`;
CREATE TABLE `awards` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `host` varchar(20) DEFAULT NULL,
  `Guest` varchar(20) DEFAULT NULL,
  `unitstype` varchar(255) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `shieldunits` varchar(1000) DEFAULT NULL,
  `shielduser` varchar(1000) DEFAULT NULL,
  `meetingArrangements` int(11) DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `remarks` text,
  `expenses` double DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKAC40D1B66B3D95E3` (`meetingid`),
  KEY `FKAC40D1B697E125A2` (`units`),
  KEY `FKAC40D1B6C139F4AC` (`meetingArrangements`),
  CONSTRAINT `FKAC40D1B6C139F4AC` FOREIGN KEY (`meetingArrangements`) REFERENCES `meetingarrangements` (`Id`),
  CONSTRAINT `awards_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `FKAC40D1B66B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `FKAC40D1B697E125A2` FOREIGN KEY (`units`) REFERENCES `units` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of awards
-- ----------------------------
INSERT INTO `awards` VALUES ('1', '2', '所发生', 'QQ', '狗狗', '', '', '', '', null, null, null, null, null);

-- ----------------------------
-- Table structure for `awards_prize`
-- ----------------------------
DROP TABLE IF EXISTS `awards_prize`;
CREATE TABLE `awards_prize` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `awardid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sponsors` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKB6CA4849509097AA` (`awardid`),
  CONSTRAINT `awards_prize_ibfk_1` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`),
  CONSTRAINT `FKB6CA4849509097AA` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of awards_prize
-- ----------------------------

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) NOT NULL DEFAULT '',
  `departmentid` int(11) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK328E4352F9502AFB` (`departmentid`),
  KEY `FK328E435271569EA8` (`creator`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
  CONSTRAINT `department_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='部门';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事部', null, '1', '2010-09-16 10:49:51');
INSERT INTO `department` VALUES ('2', '技术部', null, '1', null);

-- ----------------------------
-- Table structure for `fee_item`
-- ----------------------------
DROP TABLE IF EXISTS `fee_item`;
CREATE TABLE `fee_item` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `startfee` varchar(20) DEFAULT NULL,
  `nature` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of fee_item
-- ----------------------------
INSERT INTO `fee_item` VALUES ('1', '餐费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('2', '宴请费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('3', '活动车费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('4', '活动门票', '', '', '支出');
INSERT INTO `fee_item` VALUES ('5', '活动导游费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('6', '活动旅行社保险', '', '', '支出');
INSERT INTO `fee_item` VALUES ('7', '领导住宿费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('8', '专家住宿费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('9', '会务组住宿费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('10', '代表住宿费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('11', '个人会议费', '', '', '收入');
INSERT INTO `fee_item` VALUES ('12', '团体会议费', '', '', '收入');
INSERT INTO `fee_item` VALUES ('13', '讲座费', '', '', '收入');
INSERT INTO `fee_item` VALUES ('14', '赞助费', '', '', '收入');
INSERT INTO `fee_item` VALUES ('21', '资料费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('22', '酒水费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('23', '酒店押金', '', '', '支出');
INSERT INTO `fee_item` VALUES ('24', '场地费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('25', '横幅费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('26', '投影仪费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('27', '录音/录像费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('28', '茶水费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('29', '水果费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('30', '复印费', '', '', '支出');
INSERT INTO `fee_item` VALUES ('31', '税金', '', '', '支出');

-- ----------------------------
-- Table structure for `fee_item_property`
-- ----------------------------
DROP TABLE IF EXISTS `fee_item_property`;
CREATE TABLE `fee_item_property` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `feeitemid` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK43091488B3CC7BF1` (`feeitemid`),
  CONSTRAINT `fee_item_property_ibfk_1` FOREIGN KEY (`feeitemid`) REFERENCES `fee_item` (`Id`),
  CONSTRAINT `FK43091488B3CC7BF1` FOREIGN KEY (`feeitemid`) REFERENCES `fee_item` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of fee_item_property
-- ----------------------------

-- ----------------------------
-- Table structure for `fete`
-- ----------------------------
DROP TABLE IF EXISTS `fete`;
CREATE TABLE `fete` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `desknumber` int(11) DEFAULT NULL,
  `unitprice` int(11) DEFAULT NULL,
  `othercost` int(11) DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `outlays` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK2FE7706B3D95E3` (`meetingid`),
  KEY `FK2FE77097E125A2` (`units`),
  CONSTRAINT `FK2FE77097E125A2` FOREIGN KEY (`units`) REFERENCES `units` (`Id`),
  CONSTRAINT `FK2FE7706B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of fete
-- ----------------------------

-- ----------------------------
-- Table structure for `fete_record`
-- ----------------------------
DROP TABLE IF EXISTS `fete_record`;
CREATE TABLE `fete_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `feteid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK48A8440044DF60B7` (`feteid`),
  KEY `FK48A844005F3DBEAD` (`userid`),
  CONSTRAINT `FK48A844005F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FK48A8440044DF60B7` FOREIGN KEY (`feteid`) REFERENCES `fete` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of fete_record
-- ----------------------------

-- ----------------------------
-- Table structure for `income`
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingfeeitemid` int(11) DEFAULT NULL,
  `unitsId` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKB969A1A9802912FD` (`unitsId`),
  KEY `FKB969A1A971569EA8` (`creator`),
  KEY `FKB969A1A95F3DBEAD` (`userid`),
  KEY `FKB969A1A926A7F953` (`meetingfeeitemid`),
  CONSTRAINT `FKB969A1A926A7F953` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
  CONSTRAINT `FKB969A1A95F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FKB969A1A971569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
  CONSTRAINT `FKB969A1A9802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
  CONSTRAINT `income_ibfk_2` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `income_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `income_ibfk_4` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('3', '8', '1', '1', null, null, null, null);
INSERT INTO `income` VALUES ('6', '7', '1', '1', null, null, null, null);
INSERT INTO `income` VALUES ('7', '3', '1', '1', null, null, null, null);
INSERT INTO `income` VALUES ('8', '4', null, null, null, null, null, null);
INSERT INTO `income` VALUES ('9', '5', null, null, '2010-10-15 03:05:38', null, '2010-10-15 03:05:38', null);
INSERT INTO `income` VALUES ('10', '3', null, null, '2010-10-15 03:06:07', null, '2010-10-15 03:06:07', null);
INSERT INTO `income` VALUES ('11', '3', null, null, '2010-10-31 16:53:12', null, '2010-10-31 16:53:12', null);

-- ----------------------------
-- Table structure for `join_activities_record`
-- ----------------------------
DROP TABLE IF EXISTS `join_activities_record`;
CREATE TABLE `join_activities_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `activitiesid` int(11) DEFAULT NULL,
  `joiner` int(11) DEFAULT NULL,
  `expendamount` int(11) DEFAULT NULL,
  `expenditures` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKF874E90ED90E6171` (`activitiesid`),
  KEY `FKF874E90E4C41D3DE` (`joiner`),
  CONSTRAINT `FKF874E90E4C41D3DE` FOREIGN KEY (`joiner`) REFERENCES `user` (`Id`),
  CONSTRAINT `FKF874E90ED90E6171` FOREIGN KEY (`activitiesid`) REFERENCES `activities` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of join_activities_record
-- ----------------------------

-- ----------------------------
-- Table structure for `lecture`
-- ----------------------------
DROP TABLE IF EXISTS `lecture`;
CREATE TABLE `lecture` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `meetingRoomid` int(11) DEFAULT NULL,
  `unitsid` int(11) DEFAULT NULL,
  `subject` text,
  `arrangements` text,
  `agreement` text,
  `expertsfee` int(11) NOT NULL,
  `seminarfee` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `speakers` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK3240D7E6B3D95E3` (`meetingid`),
  KEY `FK3240D7E802912FD` (`unitsid`),
  KEY `FK3240D7E2E3432AB` (`meetingRoomid`),
  KEY `FK3240D7E11D62CDB` (`speakers`),
  CONSTRAINT `FK3240D7E11D62CDB` FOREIGN KEY (`speakers`) REFERENCES `user` (`Id`),
  CONSTRAINT `FK3240D7E2E3432AB` FOREIGN KEY (`meetingRoomid`) REFERENCES `meetingroom` (`Id`),
  CONSTRAINT `FK3240D7E6B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of lecture
-- ----------------------------

-- ----------------------------
-- Table structure for `limit`
-- ----------------------------
DROP TABLE IF EXISTS `limit`;
CREATE TABLE `limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `creator` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK6234BBB71569EA8` (`creator`),
  CONSTRAINT `FK6234BBB71569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of limit
-- ----------------------------
INSERT INTO `limit` VALUES ('1', null, '询价管理 - 浏览', 'XJ_VIEW', null);
INSERT INTO `limit` VALUES ('2', null, '询价管理 - 管理', 'XJ_MANAGER', null);
INSERT INTO `limit` VALUES ('3', null, '询价管理 - 签订合同', 'XJ_QDHT', null);
INSERT INTO `limit` VALUES ('4', null, '库管理 - 浏览', 'K_VIEW', null);
INSERT INTO `limit` VALUES ('5', null, '库管理 -管理', 'K_MANAGER', null);
INSERT INTO `limit` VALUES ('6', null, '系统设置', 'SYSTEM', null);
INSERT INTO `limit` VALUES ('7', null, '会议管理 - 浏览', 'HY_VIEW', null);
INSERT INTO `limit` VALUES ('8', null, '会议管理 - 管理', 'HY_MANAGER', null);
INSERT INTO `limit` VALUES ('9', null, '会议管理 - 会议室管理', 'HY_HYS', null);
INSERT INTO `limit` VALUES ('10', null, '会议管理 - 讲座管理', 'HY_JZ', null);
INSERT INTO `limit` VALUES ('11', null, '会议管理 - 会议安排', 'HY_HYAP', null);
INSERT INTO `limit` VALUES ('12', null, '会议管理 - 通知/回执管理', 'HY_TZ/HZ', null);
INSERT INTO `limit` VALUES ('13', null, '会议管理 - 报到管理', 'HY_BD', null);
INSERT INTO `limit` VALUES ('14', null, '会议管理 - 用餐管理', 'HY_YC', null);
INSERT INTO `limit` VALUES ('15', null, '会议管理 - 费用管理', 'HY_FY', null);
INSERT INTO `limit` VALUES ('16', null, '会议管理 - 宴请管理', 'HY_YQ', null);
INSERT INTO `limit` VALUES ('17', null, '会议管理 - 抽奖管理', 'HY_CJ', null);
INSERT INTO `limit` VALUES ('18', null, '会议管理 - 活动管理', 'HY_HD', null);

-- ----------------------------
-- Table structure for `lottery`
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT NULL,
  `senddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK1523D7496B3D95E3` (`meetingid`),
  KEY `FK1523D74997667F3A` (`owner`),
  CONSTRAINT `FK1523D7496B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `FK1523D74997667F3A` FOREIGN KEY (`owner`) REFERENCES `user` (`Id`),
  CONSTRAINT `lottery_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of lottery
-- ----------------------------
INSERT INTO `lottery` VALUES ('1', '2', '1', '2010-09-30 05:27:25', null);
INSERT INTO `lottery` VALUES ('2', '10', '1', '2010-10-20 16:50:59', null);

-- ----------------------------
-- Table structure for `lottery_record`
-- ----------------------------
DROP TABLE IF EXISTS `lottery_record`;
CREATE TABLE `lottery_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `awardid` int(11) DEFAULT NULL,
  `LotteriesId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK93187E07509097AA` (`awardid`),
  KEY `FK93187E072CE60F` (`LotteriesId`),
  CONSTRAINT `FK93187E072CE60F` FOREIGN KEY (`LotteriesId`) REFERENCES `lottery` (`Id`),
  CONSTRAINT `FK93187E07509097AA` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`),
  CONSTRAINT `lottery_record_ibfk_1` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`),
  CONSTRAINT `lottery_record_ibfk_2` FOREIGN KEY (`LotteriesId`) REFERENCES `lottery` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of lottery_record
-- ----------------------------

-- ----------------------------
-- Table structure for `meal`
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '用餐形式 0集体，1个人',
  `money` double DEFAULT NULL COMMENT '用餐费用 每餐',
  `number` int(11) DEFAULT NULL COMMENT '用餐人数',
  `address` varchar(255) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `meetingid` int(11) DEFAULT NULL,
  `drinkscost` double DEFAULT NULL,
  `expenses` double DEFAULT NULL,
  `mealtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK3313C36B3D95E3` (`meetingid`),
  CONSTRAINT `FK3313C36B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES ('1', '0', '1000', '100', '达到', '2009-12-29 00:00:00', null, null, null, null);

-- ----------------------------
-- Table structure for `meeting_fee_item`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_fee_item`;
CREATE TABLE `meeting_fee_item` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `feeitemid` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `meetingid` (`meetingid`,`feeitemid`),
  KEY `FK13F225B071569EA8` (`creator`),
  KEY `FK13F225B0B3CC7BF1` (`feeitemid`),
  KEY `FK13F225B06B3D95E3` (`meetingid`),
  CONSTRAINT `FK13F225B06B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `meeting_fee_item_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `meeting_fee_item_ibfk_3` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
  CONSTRAINT `meeting_fee_item_ibfk_4` FOREIGN KEY (`feeitemid`) REFERENCES `fee_item` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of meeting_fee_item
-- ----------------------------
INSERT INTO `meeting_fee_item` VALUES ('3', null, null, null, null, null);
INSERT INTO `meeting_fee_item` VALUES ('4', '2', '4', null, null, null);
INSERT INTO `meeting_fee_item` VALUES ('5', '2', '5', null, null, null);
INSERT INTO `meeting_fee_item` VALUES ('7', '2', '3', '123', null, null);
INSERT INTO `meeting_fee_item` VALUES ('8', '2', '2', '123', null, null);

-- ----------------------------
-- Table structure for `meeting_fee_item_property`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_fee_item_property`;
CREATE TABLE `meeting_fee_item_property` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingfeeitemid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK96584F8471569EA8` (`creator`),
  KEY `FK96584F8426A7F953` (`meetingfeeitemid`),
  CONSTRAINT `FK96584F8426A7F953` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
  CONSTRAINT `FK96584F8471569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
  CONSTRAINT `meeting_fee_item_property_ibfk_1` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
  CONSTRAINT `meeting_fee_item_property_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of meeting_fee_item_property
-- ----------------------------

-- ----------------------------
-- Table structure for `meeting_info`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_info`;
CREATE TABLE `meeting_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `priceid` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `desc1` text,
  `rdate` timestamp NULL DEFAULT NULL,
  `rman` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `priceid` (`priceid`),
  KEY `FKA0520032343D9624` (`rman`),
  KEY `FKA05200327E30B831` (`priceid`),
  CONSTRAINT `FKA05200327E30B831` FOREIGN KEY (`priceid`) REFERENCES `price` (`Id`),
  CONSTRAINT `meeting_info_ibfk_1` FOREIGN KEY (`priceid`) REFERENCES `price` (`Id`),
  CONSTRAINT `meeting_info_ibfk_2` FOREIGN KEY (`rman`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk COMMENT='会议信息';

-- ----------------------------
-- Records of meeting_info
-- ----------------------------
INSERT INTO `meeting_info` VALUES ('2', '8', '2010-10-29 00:00:00', '关于XX的谈论', '波波 ', '杭州滨江 ', '', null, null);
INSERT INTO `meeting_info` VALUES ('3', '15', '2010-10-29 00:00:00', '算得上', '2', '杭州滨江 ', '3', null, null);
INSERT INTO `meeting_info` VALUES ('4', '16', '2010-10-29 00:00:00', '信息科学', 'js', '杭州滨江 ', '孙夫人vb', null, null);
INSERT INTO `meeting_info` VALUES ('6', '17', '2010-10-29 00:00:00', '莲花开了', '啊啊啊', '杭州滨江 ', '据了解哦i', null, null);
INSERT INTO `meeting_info` VALUES ('7', '18', '2010-10-29 00:00:00', '淡淡的', 'jj', '杭州滨江 ', 'kkk', null, null);
INSERT INTO `meeting_info` VALUES ('8', '19', '2010-10-29 00:00:00', '发生的', '12', '杭州滨江 ', '12', null, null);
INSERT INTO `meeting_info` VALUES ('9', '20', '2010-10-14 00:00:00', '发送', '11', '杭州滨江 ', '11', null, null);
INSERT INTO `meeting_info` VALUES ('10', '23', '2010-10-14 00:00:00', '订购', '11', '杭州滨江 ', '1111', null, null);
INSERT INTO `meeting_info` VALUES ('11', '24', '2010-10-21 00:00:00', 'biaoti', '陈', '杭州', '很快哈佛就爱了', null, null);
INSERT INTO `meeting_info` VALUES ('12', '21', '2010-10-20 00:00:00', '很凉快', '好看', '杭州滨江 ', '哗啦哗啦', null, null);

-- ----------------------------
-- Table structure for `meetingarrangements`
-- ----------------------------
DROP TABLE IF EXISTS `meetingarrangements`;
CREATE TABLE `meetingarrangements` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingroom` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `host` text,
  `intermission` int(11) DEFAULT NULL,
  `drawingtime` int(11) DEFAULT NULL,
  `recorder` varchar(50) DEFAULT NULL,
  `recorddate` datetime DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `meetingInfo` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKD3EFA8646EEB3310` (`meetingroom`),
  KEY `FKD3EFA8646EE2FAB6` (`meetingInfo`),
  CONSTRAINT `FKD3EFA8646EE2FAB6` FOREIGN KEY (`meetingInfo`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `FKD3EFA8646EEB3310` FOREIGN KEY (`meetingroom`) REFERENCES `meetingroom` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of meetingarrangements
-- ----------------------------

-- ----------------------------
-- Table structure for `meetingroom`
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `name` text,
  `address` text,
  `sitefees` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `host` varchar(20) DEFAULT NULL,
  `backplane` text,
  `scroll` text,
  `projector` text,
  `wired` text,
  `wireless` text,
  `recording` text,
  `video` text,
  `tea` text,
  `fruit` text,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKCB6635966B3D95E3` (`meetingid`),
  CONSTRAINT `FKCB6635966B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('2', '询价管理', null, null);

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `FKC20796D86B3D95E3` (`meetingid`),
  CONSTRAINT `FKC20796D86B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk COMMENT='通知单';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('2', '2', '2010-12-02 00:00:00', '321');
INSERT INTO `notice` VALUES ('3', '3', '2010-10-13 00:00:00', '123');
INSERT INTO `notice` VALUES ('4', '6', '2010-10-14 00:00:00', '144');
INSERT INTO `notice` VALUES ('5', '12', '2010-10-20 00:00:00', '200');

-- ----------------------------
-- Table structure for `outlay`
-- ----------------------------
DROP TABLE IF EXISTS `outlay`;
CREATE TABLE `outlay` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingfeeitemid` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `person` varchar(20) DEFAULT NULL,
  `unitsId` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKC4110796802912FD` (`unitsId`),
  KEY `FKC411079671569EA8` (`creator`),
  KEY `FKC41107965F3DBEAD` (`userid`),
  KEY `FKC411079626A7F953` (`meetingfeeitemid`),
  CONSTRAINT `FKC411079626A7F953` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
  CONSTRAINT `FKC41107965F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FKC411079671569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
  CONSTRAINT `FKC4110796802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `outlay_ibfk_1` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
  CONSTRAINT `outlay_ibfk_2` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `outlay_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `outlay_ibfk_4` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of outlay
-- ----------------------------
INSERT INTO `outlay` VALUES ('4', '4', '1200', '13', '1', '1', null, null);
INSERT INTO `outlay` VALUES ('5', '4', '1111', '12', null, null, null, '2010-10-15 03:05:05');

-- ----------------------------
-- Table structure for `price`
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) NOT NULL DEFAULT '0',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(20) NOT NULL DEFAULT '',
  `hotel` varchar(20) NOT NULL DEFAULT '',
  `hotelTraffic` text COMMENT '酒店交通（1000，字符串）',
  `hotelenvironment` text COMMENT '周边环境（2000，字符串）',
  `number` int(11) DEFAULT NULL COMMENT '会议人数（整型）',
  `roomNumber` int(11) DEFAULT NULL COMMENT '客房数（整型）',
  `registTime` datetime DEFAULT NULL COMMENT '报到时间',
  `roomSize` text COMMENT '会议室规模（2000，字符串）',
  `travel` text COMMENT '会议行程（大文本）',
  `mealSize` text COMMENT '餐厅规模（2000，字符串）',
  `mealType` text COMMENT '用餐形式（1000，字符串）',
  `meal` text COMMENT '餐谱（大文本）',
  `meetingspaceFee` double DEFAULT NULL COMMENT '会议室场地费',
  `housingFee` double DEFAULT NULL COMMENT '住房费',
  `productionFee` double DEFAULT NULL COMMENT '背板制作费',
  `bannersFee` double DEFAULT NULL COMMENT '条幅费',
  `projectorFee` double DEFAULT NULL COMMENT '投影仪费',
  `teaFee` double DEFAULT NULL COMMENT '茶水费',
  `fruitFee` double DEFAULT NULL COMMENT '水果费',
  `mealFee` double DEFAULT NULL COMMENT '餐费标准',
  `fareFee` double DEFAULT NULL COMMENT '车费',
  `admissionFee` double DEFAULT NULL COMMENT '门票费',
  `guideFee` double DEFAULT NULL COMMENT '导游费',
  `insuranceFee` double DEFAULT NULL COMMENT '保险费',
  `bookingFee` double DEFAULT NULL COMMENT '订票',
  `taxesFee` double DEFAULT NULL COMMENT '税金',
  `unitsname` varchar(20) DEFAULT NULL,
  `minnumber` int(11) DEFAULT NULL COMMENT '会议人数最小（整型）',
  `maxnumber` int(11) DEFAULT NULL COMMENT '会议人数最大（整型）',
  `roomMinSize` int(11) DEFAULT NULL COMMENT '会议室规模min（2000，字符串）',
  `roomMaxSize` int(11) DEFAULT NULL COMMENT '会议室规模max（2000，字符串）',
  `mealMinSize` int(11) DEFAULT NULL COMMENT '餐厅规模（2000，字符串）',
  `mealMaxSize` int(11) DEFAULT NULL COMMENT '餐厅规模（2000，字符串）',
  `mealType1` int(11) DEFAULT NULL COMMENT '用餐形式 自助餐0无1有',
  `mealType2` int(11) DEFAULT NULL COMMENT '用餐形式 桌餐0无1有',
  `fareFee1` double DEFAULT NULL COMMENT '车费一',
  `fareFee2` double DEFAULT NULL COMMENT '车费2',
  `fareFee3` double DEFAULT NULL COMMENT '车费3',
  `travelFee` double DEFAULT NULL COMMENT '旅游费',
  `meetingType` int(11) DEFAULT NULL COMMENT '会议类型 0年会、1标准会',
  `meetingDays` int(11) DEFAULT NULL COMMENT '会议天数',
  `activities` varchar(255) DEFAULT NULL COMMENT '活动',
  `projectorFee1` double DEFAULT NULL COMMENT '投影仪费半天',
  `projectorFee2` double DEFAULT NULL COMMENT '投影仪费一天',
  `travelFee1` double DEFAULT NULL COMMENT '旅游费1',
  `travelFee2` double DEFAULT NULL COMMENT '旅游费2',
  `travelFee3` double DEFAULT NULL COMMENT '旅游费3',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=gbk COMMENT='询价';

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES ('8', '123', '2010-12-03 00:00:00', '123', '123', null, null, null, null, '2010-12-04 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('15', '2123', '2010-12-02 00:00:00', '231', '123', null, null, null, null, '2010-12-03 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('16', '1', '2010-09-30 00:00:00', '1', '12', null, null, null, null, '2010-12-03 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('17', '321', '2010-10-14 00:00:00', '阿发', '事实上', null, null, null, null, '2010-12-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('18', '321', '2010-10-13 00:00:00', '分手费大幅上升', '是否', null, null, null, null, '2010-12-03 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('19', '1', '2010-10-13 00:00:00', '1', '1', null, null, null, null, '2010-12-03 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('20', '1', '2010-10-13 00:00:00', '1', '1', null, null, null, null, '2010-12-03 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('21', '1', '2010-10-13 00:00:00', '1', '1', null, null, null, null, '2010-12-04 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('23', '1', '2010-10-13 00:00:00', '1', '1', null, null, null, null, '2010-12-03 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('24', '20000', '2010-10-29 00:00:00', 'hanzhou', 'hotel', null, null, null, null, '2010-12-04 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `price` VALUES ('25', '1', '2010-12-04 00:00:00', '滨江', '酒店名称', '酒店交通', '周边环境', null, '12', '2010-12-03 00:00:00', null, '12', null, null, '', '1', '1', '1', '1', null, '1', '1', '1', null, null, null, null, '1', '1', '第三代', '1', '2', '1', '2', '1', '2', '1', '1', '1', '1', '1', '1', '1', '1', '', '1', '1', null, null, null);

-- ----------------------------
-- Table structure for `priceroomtype`
-- ----------------------------
DROP TABLE IF EXISTS `priceroomtype`;
CREATE TABLE `priceroomtype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `minRoomNumber` int(11) DEFAULT NULL,
  `maxRoomNumber` int(11) DEFAULT NULL,
  `priceid` int(11) DEFAULT NULL,
  `roomtypeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKC55C82DE7E30B831` (`priceid`),
  KEY `FKC55C82DEE9EA67E1` (`roomtypeid`),
  CONSTRAINT `FKC55C82DEE9EA67E1` FOREIGN KEY (`roomtypeid`) REFERENCES `roomtype` (`Id`),
  CONSTRAINT `FKC55C82DE7E30B831` FOREIGN KEY (`priceid`) REFERENCES `price` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of priceroomtype
-- ----------------------------

-- ----------------------------
-- Table structure for `register`
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `payment` varchar(20) DEFAULT NULL COMMENT '无，部分，全部',
  `stayday` int(11) DEFAULT NULL,
  `stayroomnumber` int(11) DEFAULT NULL,
  `sign` int(11) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `receive` int(11) DEFAULT NULL,
  `award` varchar(50) DEFAULT NULL,
  `meal` varchar(50) DEFAULT NULL,
  `deposit` double DEFAULT NULL COMMENT '押金',
  `depositDate` datetime DEFAULT NULL COMMENT '收押金日期',
  `reachDate` datetime DEFAULT NULL COMMENT '报到时间',
  `chargeDate` datetime DEFAULT NULL COMMENT '收费日期',
  `roomNo` varchar(10) DEFAULT NULL COMMENT '房间号',
  `personalOptions` int(11) DEFAULT NULL COMMENT '个人选项 代表、专家、家属、特殊免交、特殊暂缓',
  `userName` varchar(10) DEFAULT NULL COMMENT '用户姓名',
  `isReceipt` int(11) DEFAULT NULL COMMENT '是否已开收据',
  `personalFee` double DEFAULT NULL COMMENT '个人会务费',
  `groupsFee` double DEFAULT NULL COMMENT '团体会务费',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `meetingid` (`meetingid`,`userid`),
  KEY `FKD6DC2EA35F3DBEAD` (`userid`),
  KEY `FKD6DC2EA36B3D95E3` (`meetingid`),
  CONSTRAINT `FKD6DC2EA35F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FKD6DC2EA36B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
  CONSTRAINT `register_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `register_ibfk_2` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('8', '2', '2', '部分', '120', '11', '1', '1', '1000', '1', '1002', '111', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `register` VALUES ('11', '2', '1', '部分', '120', '10', '11', '1', '1000', '1', '1', '1003', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `register` VALUES ('12', '10', '1', '全部', '2', '2', '1', '11', '111', '1', '2', '111', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `relatives`
-- ----------------------------
DROP TABLE IF EXISTS `relatives`;
CREATE TABLE `relatives` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL COMMENT '能带亲属的所有活动:报到BD，宴请YQ，活动HD',
  `theirid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKFF8B5F275F3DBEAD` (`userid`),
  KEY `FKFF8B5F27409E207C` (`theirid`),
  CONSTRAINT `FKFF8B5F27409E207C` FOREIGN KEY (`theirid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FKFF8B5F275F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `relatives_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `relatives_ibfk_2` FOREIGN KEY (`theirid`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of relatives
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `FK35807671569EA8` (`creator`),
  CONSTRAINT `FK35807671569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '1', '2010-12-02 15:16:13');
INSERT INTO `role` VALUES ('2', '普通用户', '1', '2010-12-02 15:16:16');

-- ----------------------------
-- Table structure for `role_limit`
-- ----------------------------
DROP TABLE IF EXISTS `role_limit`;
CREATE TABLE `role_limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL DEFAULT '0',
  `limitid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK6C747EB259E86943` (`roleid`),
  KEY `FK6C747EB29B3B1895` (`limitid`),
  CONSTRAINT `FK6C747EB29B3B1895` FOREIGN KEY (`limitid`) REFERENCES `limit` (`Id`),
  CONSTRAINT `FK6C747EB259E86943` FOREIGN KEY (`roleid`) REFERENCES `role` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of role_limit
-- ----------------------------
INSERT INTO `role_limit` VALUES ('152', '1', '3');
INSERT INTO `role_limit` VALUES ('153', '1', '6');
INSERT INTO `role_limit` VALUES ('154', '1', '9');
INSERT INTO `role_limit` VALUES ('155', '1', '12');
INSERT INTO `role_limit` VALUES ('156', '1', '15');
INSERT INTO `role_limit` VALUES ('157', '1', '18');
INSERT INTO `role_limit` VALUES ('158', '2', '1');
INSERT INTO `role_limit` VALUES ('159', '2', '2');
INSERT INTO `role_limit` VALUES ('160', '2', '3');
INSERT INTO `role_limit` VALUES ('161', '2', '4');
INSERT INTO `role_limit` VALUES ('162', '2', '5');
INSERT INTO `role_limit` VALUES ('163', '2', '6');
INSERT INTO `role_limit` VALUES ('164', '2', '7');
INSERT INTO `role_limit` VALUES ('165', '2', '8');
INSERT INTO `role_limit` VALUES ('166', '2', '9');
INSERT INTO `role_limit` VALUES ('167', '2', '10');
INSERT INTO `role_limit` VALUES ('168', '2', '11');
INSERT INTO `role_limit` VALUES ('169', '2', '12');
INSERT INTO `role_limit` VALUES ('170', '2', '13');
INSERT INTO `role_limit` VALUES ('171', '2', '14');
INSERT INTO `role_limit` VALUES ('172', '2', '15');
INSERT INTO `role_limit` VALUES ('173', '2', '16');
INSERT INTO `role_limit` VALUES ('174', '2', '17');
INSERT INTO `role_limit` VALUES ('175', '2', '18');

-- ----------------------------
-- Table structure for `roomtype`
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `FK35807671569EA8` (`creator`),
  KEY `FKF5BA2A9571569EA8` (`creator`),
  CONSTRAINT `FKF5BA2A9571569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of roomtype
-- ----------------------------
INSERT INTO `roomtype` VALUES ('1', '标准双人间', '1', null);
INSERT INTO `roomtype` VALUES ('2', '标准普通间', '1', '2010-12-02 05:01:47');

-- ----------------------------
-- Table structure for `send_notification_plan`
-- ----------------------------
DROP TABLE IF EXISTS `send_notification_plan`;
CREATE TABLE `send_notification_plan` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `noticeid` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `unitsId` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `sender` int(11) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `responsedate` timestamp NULL DEFAULT NULL,
  `housenumber` int(11) DEFAULT NULL,
  `reachflights` varchar(255) DEFAULT NULL,
  `reachTrain` varchar(255) DEFAULT NULL,
  `reachtime` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `reachman` varchar(255) DEFAULT NULL,
  `roomtypeId` int(11) DEFAULT NULL,
  `reachphone` varchar(11) DEFAULT NULL,
  `issingle` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKD8F37D06802912FD` (`unitsId`),
  KEY `FKD8F37D06E8FB4687` (`noticeid`),
  KEY `FKD8F37D065F3DBEAD` (`userid`),
  KEY `FKD8F37D06FE0838B1` (`sender`),
  KEY `FKD8F37D06E9EA67E1` (`roomtypeId`),
  CONSTRAINT `FKD8F37D065F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FKD8F37D06802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `FKD8F37D06E8FB4687` FOREIGN KEY (`noticeid`) REFERENCES `notice` (`Id`),
  CONSTRAINT `FKD8F37D06E9EA67E1` FOREIGN KEY (`roomtypeId`) REFERENCES `roomtype` (`Id`),
  CONSTRAINT `FKD8F37D06FE0838B1` FOREIGN KEY (`sender`) REFERENCES `sysaccount` (`id`),
  CONSTRAINT `send_notification_plan_ibfk_1` FOREIGN KEY (`noticeid`) REFERENCES `notice` (`Id`),
  CONSTRAINT `send_notification_plan_ibfk_2` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `send_notification_plan_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `send_notification_plan_ibfk_4` FOREIGN KEY (`sender`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of send_notification_plan
-- ----------------------------
INSERT INTO `send_notification_plan` VALUES ('5', '2', null, null, '2', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `send_notification_plan` VALUES ('6', '2', null, null, '3', null, '已回执', '2010-10-13 08:21:52', null, null, null, null, null, null, null, null, null);
INSERT INTO `send_notification_plan` VALUES ('10', '2', null, null, '1', null, '已回执', '2010-10-25 09:55:40', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `sysaccount`
-- ----------------------------
DROP TABLE IF EXISTS `sysaccount`;
CREATE TABLE `sysaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `zip` varchar(6) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `departmentid` int(11) NOT NULL DEFAULT '0',
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `FK3550FAC0F9502AFB` (`departmentid`),
  KEY `FK3550FAC071569EA8` (`creator`),
  KEY `FK3550FAC059E86943` (`roleid`),
  CONSTRAINT `FK3550FAC059E86943` FOREIGN KEY (`roleid`) REFERENCES `role` (`Id`),
  CONSTRAINT `sysaccount_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
  CONSTRAINT `sysaccount_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='系统账号';

-- ----------------------------
-- Records of sysaccount
-- ----------------------------
INSERT INTO `sysaccount` VALUES ('1', 'admin', '123', 'admin', '0', '13888888888', '310001', '杭州', '1', '1', '2010-09-16 10:49:28', '1');

-- ----------------------------
-- Table structure for `tradetype`
-- ----------------------------
DROP TABLE IF EXISTS `tradetype`;
CREATE TABLE `tradetype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `unittypeid` int(11) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK2CEF2E9E71569EA8` (`creator`),
  KEY `FK2CEF2E9EA892DC66` (`unittypeid`),
  CONSTRAINT `FK2CEF2E9EA892DC66` FOREIGN KEY (`unittypeid`) REFERENCES `units_type` (`Id`),
  CONSTRAINT `FK2CEF2E9E71569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tradetype
-- ----------------------------
INSERT INTO `tradetype` VALUES ('20', '分类一', '0', '2', '1', '2010-12-02 10:08:37');
INSERT INTO `tradetype` VALUES ('21', '分类1.1', '20', '2', '1', '2010-12-02 10:26:22');

-- ----------------------------
-- Table structure for `units`
-- ----------------------------
DROP TABLE IF EXISTS `units`;
CREATE TABLE `units` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) NOT NULL DEFAULT '',
  `zip` varchar(6) DEFAULT NULL,
  `connect` varchar(20) NOT NULL DEFAULT '',
  `phone` varchar(11) NOT NULL DEFAULT '',
  `mail` varchar(50) DEFAULT NULL,
  `site` varchar(50) DEFAULT NULL,
  `unitstypeId` int(11) DEFAULT NULL,
  `tradetypeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK6A4576F6386FE11` (`unitstypeId`),
  KEY `FK6A4576FE2F623BB` (`tradetypeid`),
  CONSTRAINT `FK6A4576FE2F623BB` FOREIGN KEY (`tradetypeid`) REFERENCES `tradetype` (`Id`),
  CONSTRAINT `FK6A4576F6386FE11` FOREIGN KEY (`unitstypeId`) REFERENCES `units_type` (`Id`),
  CONSTRAINT `units_ibfk_1` FOREIGN KEY (`unitstypeId`) REFERENCES `units_type` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk COMMENT='单位';

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES ('1', '万格', '滨江', '341500', 'jj', '13888888888', '888@qq.com', 'http://www.baidu.com', '1', '20');
INSERT INTO `units` VALUES ('2', '哥哥', '杭州', '321000', '狗狗', '13888888888', '2@sfs.v', 'http://www.baidu.com', '2', '21');

-- ----------------------------
-- Table structure for `units_type`
-- ----------------------------
DROP TABLE IF EXISTS `units_type`;
CREATE TABLE `units_type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) NOT NULL DEFAULT '' COMMENT '厂商、设计院、其他',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='单位类型';

-- ----------------------------
-- Records of units_type
-- ----------------------------
INSERT INTO `units_type` VALUES ('1', '厂商');
INSERT INTO `units_type` VALUES ('2', '设计院');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `usertype` varchar(11) DEFAULT NULL,
  `unitsId` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `cellphone` varchar(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `zip` varchar(6) DEFAULT NULL,
  `zwei` varchar(11) DEFAULT NULL,
  `zwu` varchar(11) DEFAULT NULL,
  `photo` text,
  PRIMARY KEY (`Id`),
  KEY `FK36EBCB802912FD` (`unitsId`),
  KEY `FK36EBCB5F3DBEAD` (`userid`),
  CONSTRAINT `FK36EBCB5F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
  CONSTRAINT `FK36EBCB802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk COMMENT='个人';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jumkey', '专家', '1', '3', '1', '13888888888', '11@qq.com', '13888888888', '杭州', '310000', 'wei', 'wu', null);
INSERT INTO `user` VALUES ('2', 'jumkey\'s father', '专家', '1', null, '1', '13888888888', '11@qq.com', '13888888888', '杭州', '310000', 'wei', 'wu', null);
INSERT INTO `user` VALUES ('3', 'jumkey\'s mother', '一般', '1', null, '1', '13888888888', '11@qq.com', '13888888888', '杭州', '310000', 'wei', 'wu', null);
