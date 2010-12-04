# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: 192.168.1.123    Database: meetingmanager
# ------------------------------------------------------
# Server version 5.1.44-community

DROP DATABASE IF EXISTS `meetingmanager`;
CREATE DATABASE `meetingmanager` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `meetingmanager`;

#
# Source for table activities
#

DROP TABLE IF EXISTS `activities`;
CREATE TABLE `activities` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `person` varchar(20) DEFAULT NULL,
  `desc1` text,
  PRIMARY KEY (`Id`),
  KEY `FK7A1B3BED6B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table activities
#

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (1,2,'四谛法dfdf1111','2010-12-10','我','1sdfsdfafdsf',5,NULL,'0571-8888888',159);
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table agreement
#

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
  KEY `FK3A29520A6B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gbk;

#
# Dumping data for table agreement
#

LOCK TABLES `agreement` WRITE;
/*!40000 ALTER TABLE `agreement` DISABLE KEYS */;
INSERT INTO `agreement` VALUES (1,'2010-10-01','2010-10-03',2,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (5,NULL,'2010-10-15',3,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (6,NULL,'2010-10-22',4,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (7,NULL,'2010-10-14',6,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (8,NULL,'2010-10-10',7,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (9,'2010-10-15','2010-10-15',8,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (10,'2010-10-14','2010-10-14',9,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (11,'2010-10-13','2010-10-13',10,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (12,'2010-10-23','2010-10-22',11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `agreement` VALUES (13,'2010-10-20','2010-10-21',12,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `agreement` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table arrangementsseminars
#

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
  KEY `FKCDF76D6B4C9DF0C0` (`lecture`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table arrangementsseminars
#

LOCK TABLES `arrangementsseminars` WRITE;
/*!40000 ALTER TABLE `arrangementsseminars` DISABLE KEYS */;
/*!40000 ALTER TABLE `arrangementsseminars` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table awards
#

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
  KEY `FKAC40D1B6C139F4AC` (`meetingArrangements`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

#
# Dumping data for table awards
#

LOCK TABLES `awards` WRITE;
/*!40000 ALTER TABLE `awards` DISABLE KEYS */;
INSERT INTO `awards` VALUES (1,2,'所发生','QQ','狗狗','','','','',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `awards` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table awards_prize
#

DROP TABLE IF EXISTS `awards_prize`;
CREATE TABLE `awards_prize` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `awardid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sponsors` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKB6CA4849509097AA` (`awardid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table awards_prize
#

LOCK TABLES `awards_prize` WRITE;
/*!40000 ALTER TABLE `awards_prize` DISABLE KEYS */;
/*!40000 ALTER TABLE `awards_prize` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table department
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) NOT NULL DEFAULT '',
  `departmentid` int(11) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK328E4352F9502AFB` (`departmentid`),
  KEY `FK328E435271569EA8` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='部门';

#
# Dumping data for table department
#

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'人事部',NULL,1,'2010-09-16 10:49:51');
INSERT INTO `department` VALUES (2,'技术部',NULL,1,NULL);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fee_item
#

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

#
# Dumping data for table fee_item
#

LOCK TABLES `fee_item` WRITE;
/*!40000 ALTER TABLE `fee_item` DISABLE KEYS */;
INSERT INTO `fee_item` VALUES (1,'餐费','','','支出');
INSERT INTO `fee_item` VALUES (2,'宴请费','','','支出');
INSERT INTO `fee_item` VALUES (3,'活动车费','','','支出');
INSERT INTO `fee_item` VALUES (4,'活动门票','','','支出');
INSERT INTO `fee_item` VALUES (5,'活动导游费','','','支出');
INSERT INTO `fee_item` VALUES (6,'活动旅行社保险','','','支出');
INSERT INTO `fee_item` VALUES (7,'领导住宿费','','','支出');
INSERT INTO `fee_item` VALUES (8,'专家住宿费','','','支出');
INSERT INTO `fee_item` VALUES (9,'会务组住宿费','','','支出');
INSERT INTO `fee_item` VALUES (10,'代表住宿费','','','支出');
INSERT INTO `fee_item` VALUES (11,'个人会议费','','','收入');
INSERT INTO `fee_item` VALUES (12,'团体会议费','','','收入');
INSERT INTO `fee_item` VALUES (13,'讲座费','','','收入');
INSERT INTO `fee_item` VALUES (14,'赞助费','','','收入');
INSERT INTO `fee_item` VALUES (21,'资料费','','','支出');
INSERT INTO `fee_item` VALUES (22,'酒水费','','','支出');
INSERT INTO `fee_item` VALUES (23,'酒店押金','','','支出');
INSERT INTO `fee_item` VALUES (24,'场地费','','','支出');
INSERT INTO `fee_item` VALUES (25,'横幅费','','','支出');
INSERT INTO `fee_item` VALUES (26,'投影仪费','','','支出');
INSERT INTO `fee_item` VALUES (27,'录音/录像费','','','支出');
INSERT INTO `fee_item` VALUES (28,'茶水费','','','支出');
INSERT INTO `fee_item` VALUES (29,'水果费','','','支出');
INSERT INTO `fee_item` VALUES (30,'复印费','','','支出');
INSERT INTO `fee_item` VALUES (31,'税金','','','支出');
/*!40000 ALTER TABLE `fee_item` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fee_item_property
#

DROP TABLE IF EXISTS `fee_item_property`;
CREATE TABLE `fee_item_property` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `feeitemid` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK43091488B3CC7BF1` (`feeitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table fee_item_property
#

LOCK TABLES `fee_item_property` WRITE;
/*!40000 ALTER TABLE `fee_item_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_item_property` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fete
#

DROP TABLE IF EXISTS `fete`;
CREATE TABLE `fete` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `scale` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `desknumber` int(11) DEFAULT NULL,
  `unitprice` int(11) DEFAULT NULL,
  `othercost` int(11) DEFAULT NULL,
  `unitsid` int(11) DEFAULT NULL,
  `outlays` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK2FE7706B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table fete
#

LOCK TABLES `fete` WRITE;
/*!40000 ALTER TABLE `fete` DISABLE KEYS */;
INSERT INTO `fete` VALUES (4,2,'滨江区','2010-12-09',121211,11,1,1,1,1,1111,NULL,NULL);
INSERT INTO `fete` VALUES (5,2,'滨江1号','2010-12-09',1,2,3,4,5,1,6,NULL,NULL);
/*!40000 ALTER TABLE `fete` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fete_record
#

DROP TABLE IF EXISTS `fete_record`;
CREATE TABLE `fete_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `feteid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK48A8440044DF60B7` (`feteid`),
  KEY `FK48A844005F3DBEAD` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table fete_record
#

LOCK TABLES `fete_record` WRITE;
/*!40000 ALTER TABLE `fete_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `fete_record` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table income
#

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
  KEY `FKB969A1A926A7F953` (`meetingfeeitemid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

#
# Dumping data for table income
#

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES (3,8,1,1,NULL,NULL,NULL,NULL);
INSERT INTO `income` VALUES (6,7,1,1,NULL,NULL,NULL,NULL);
INSERT INTO `income` VALUES (7,3,1,1,NULL,NULL,NULL,NULL);
INSERT INTO `income` VALUES (8,4,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `income` VALUES (9,5,NULL,NULL,'2010-10-15 03:05:38',NULL,'2010-10-15 03:05:38',NULL);
INSERT INTO `income` VALUES (10,3,NULL,NULL,'2010-10-15 03:06:07',NULL,'2010-10-15 03:06:07',NULL);
INSERT INTO `income` VALUES (11,3,NULL,NULL,'2010-10-31 16:53:12',NULL,'2010-10-31 16:53:12',NULL);
INSERT INTO `income` VALUES (12,9,NULL,3,NULL,NULL,NULL,11);
INSERT INTO `income` VALUES (13,10,1,NULL,NULL,NULL,NULL,12);
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table join_activities_record
#

DROP TABLE IF EXISTS `join_activities_record`;
CREATE TABLE `join_activities_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `activitiesid` int(11) DEFAULT NULL,
  `joiner` int(11) DEFAULT NULL,
  `payment` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKF874E90ED90E6171` (`activitiesid`),
  KEY `FKF874E90E4C41D3DE` (`joiner`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table join_activities_record
#

LOCK TABLES `join_activities_record` WRITE;
/*!40000 ALTER TABLE `join_activities_record` DISABLE KEYS */;
INSERT INTO `join_activities_record` VALUES (8,1,NULL,121,1212,NULL);
/*!40000 ALTER TABLE `join_activities_record` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table lecture
#

DROP TABLE IF EXISTS `lecture`;
CREATE TABLE `lecture` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `unitsid` int(11) DEFAULT NULL,
  `subject` text,
  `speakers` int(11) DEFAULT NULL,
  `agreement` text,
  `expertsfee` double NOT NULL,
  `seminarfee` double NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK3240D7E6B3D95E3` (`meetingid`),
  KEY `FK3240D7E802912FD` (`unitsid`),
  KEY `FK3240D7E11D62CDB` (`speakers`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table lecture
#

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table limit
#

DROP TABLE IF EXISTS `limit`;
CREATE TABLE `limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `creator` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK6234BBB71569EA8` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=gbk;

#
# Dumping data for table limit
#

LOCK TABLES `limit` WRITE;
/*!40000 ALTER TABLE `limit` DISABLE KEYS */;
INSERT INTO `limit` VALUES (1,NULL,'询价管理 - 浏览','XJ_VIEW',NULL);
INSERT INTO `limit` VALUES (2,NULL,'询价管理 - 管理','XJ_MANAGER',NULL);
INSERT INTO `limit` VALUES (3,NULL,'询价管理 - 签订合同','XJ_QDHT',NULL);
INSERT INTO `limit` VALUES (4,NULL,'库管理 - 浏览','K_VIEW',NULL);
INSERT INTO `limit` VALUES (5,NULL,'库管理 -管理','K_MANAGER',NULL);
INSERT INTO `limit` VALUES (6,NULL,'系统设置','SYSTEM',NULL);
INSERT INTO `limit` VALUES (7,NULL,'会议管理 - 浏览','HY_VIEW',NULL);
INSERT INTO `limit` VALUES (8,NULL,'会议管理 - 管理','HY_MANAGER',NULL);
INSERT INTO `limit` VALUES (9,NULL,'会议管理 - 会议室管理','HY_HYS',NULL);
INSERT INTO `limit` VALUES (10,NULL,'会议管理 - 讲座管理','HY_JZ',NULL);
INSERT INTO `limit` VALUES (11,NULL,'会议管理 - 会议安排','HY_HYAP',NULL);
INSERT INTO `limit` VALUES (12,NULL,'会议管理 - 通知/回执管理','HY_TZ/HZ',NULL);
INSERT INTO `limit` VALUES (13,NULL,'会议管理 - 报到管理','HY_BD',NULL);
INSERT INTO `limit` VALUES (14,NULL,'会议管理 - 用餐管理','HY_YC',NULL);
INSERT INTO `limit` VALUES (15,NULL,'会议管理 - 费用管理','HY_FY',NULL);
INSERT INTO `limit` VALUES (16,NULL,'会议管理 - 宴请管理','HY_YQ',NULL);
INSERT INTO `limit` VALUES (17,NULL,'会议管理 - 抽奖管理','HY_CJ',NULL);
INSERT INTO `limit` VALUES (18,NULL,'会议管理 - 活动管理','HY_HD',NULL);
/*!40000 ALTER TABLE `limit` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table lottery
#

DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT NULL,
  `senddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK1523D7496B3D95E3` (`meetingid`),
  KEY `FK1523D74997667F3A` (`owner`)
) ENGINE=InnoDB AUTO_INCREMENT=2001 DEFAULT CHARSET=gbk;

#
# Dumping data for table lottery
#

LOCK TABLES `lottery` WRITE;
/*!40000 ALTER TABLE `lottery` DISABLE KEYS */;
INSERT INTO `lottery` VALUES (2001,2,1,'2010-09-30 05:27:25',NULL);
INSERT INTO `lottery` VALUES (2002,10,2,'2010-09-30 05:27:25',NULL);
INSERT INTO `lottery` VALUES (2003,10,1,'2010-10-20 16:50:59',NULL);
INSERT INTO `lottery` VALUES (2004,10,3,'2010-09-30 05:27:25',NULL);
/*!40000 ALTER TABLE `lottery` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table lottery_record
#

DROP TABLE IF EXISTS `lottery_record`;
CREATE TABLE `lottery_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `awardid` int(11) DEFAULT NULL,
  `LotteriesId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK93187E07509097AA` (`awardid`),
  KEY `FK93187E072CE60F` (`LotteriesId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table lottery_record
#

LOCK TABLES `lottery_record` WRITE;
/*!40000 ALTER TABLE `lottery_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottery_record` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meal
#

DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '用餐形式 0集体，1个人',
  `money` double DEFAULT NULL COMMENT '用餐费用 每餐',
  `number` int(11) DEFAULT NULL COMMENT '用餐人数',
  `address` varchar(255) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `meetingid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK3313C36B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

#
# Dumping data for table meal
#

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
INSERT INTO `meal` VALUES (1,0,1000,100,'达到','2009-12-29',NULL);
INSERT INTO `meal` VALUES (2,0,11,11,'sdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (3,0,11,11,'sdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (4,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (5,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (6,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (7,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (8,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (9,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (10,0,11,11,'sdfsdf','2010-12-08',NULL);
INSERT INTO `meal` VALUES (11,1,1,1,'sdfsdf','2010-12-11',NULL);
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meeting_fee_item
#

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
  KEY `FK13F225B06B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

#
# Dumping data for table meeting_fee_item
#

LOCK TABLES `meeting_fee_item` WRITE;
/*!40000 ALTER TABLE `meeting_fee_item` DISABLE KEYS */;
INSERT INTO `meeting_fee_item` VALUES (3,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `meeting_fee_item` VALUES (4,2,4,NULL,NULL,NULL);
INSERT INTO `meeting_fee_item` VALUES (5,2,5,NULL,NULL,NULL);
INSERT INTO `meeting_fee_item` VALUES (7,2,3,123,NULL,NULL);
INSERT INTO `meeting_fee_item` VALUES (8,2,2,123,NULL,NULL);
INSERT INTO `meeting_fee_item` VALUES (9,2,11,NULL,NULL,NULL);
INSERT INTO `meeting_fee_item` VALUES (10,2,12,NULL,NULL,NULL);
/*!40000 ALTER TABLE `meeting_fee_item` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meeting_fee_item_property
#

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
  KEY `FK96584F8426A7F953` (`meetingfeeitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table meeting_fee_item_property
#

LOCK TABLES `meeting_fee_item_property` WRITE;
/*!40000 ALTER TABLE `meeting_fee_item_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting_fee_item_property` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meeting_info
#

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
  KEY `FKA05200327E30B831` (`priceid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk COMMENT='会议信息';

#
# Dumping data for table meeting_info
#

LOCK TABLES `meeting_info` WRITE;
/*!40000 ALTER TABLE `meeting_info` DISABLE KEYS */;
INSERT INTO `meeting_info` VALUES (2,8,'2010-10-29','关于XX的谈论','波波 ','杭州滨江 ','',NULL,NULL);
INSERT INTO `meeting_info` VALUES (3,15,'2010-10-29','算得上','2','杭州滨江 ','3',NULL,NULL);
INSERT INTO `meeting_info` VALUES (4,16,'2010-10-29','信息科学','js','杭州滨江 ','孙夫人vb',NULL,NULL);
INSERT INTO `meeting_info` VALUES (6,17,'2010-10-29','莲花开了','啊啊啊','杭州滨江 ','据了解哦i',NULL,NULL);
INSERT INTO `meeting_info` VALUES (7,18,'2010-10-29','淡淡的','jj','杭州滨江 ','kkk',NULL,NULL);
INSERT INTO `meeting_info` VALUES (8,19,'2010-10-29','发生的','12','杭州滨江 ','12',NULL,NULL);
INSERT INTO `meeting_info` VALUES (9,20,'2010-10-14','发送','11','杭州滨江 ','11',NULL,NULL);
INSERT INTO `meeting_info` VALUES (10,23,'2010-10-14','订购','11','杭州滨江 ','1111',NULL,NULL);
INSERT INTO `meeting_info` VALUES (11,24,'2010-10-21','biaoti','陈','杭州','很快哈佛就爱了',NULL,NULL);
INSERT INTO `meeting_info` VALUES (12,21,'2010-10-20','很凉快','好看','杭州滨江 ','哗啦哗啦',NULL,NULL);
/*!40000 ALTER TABLE `meeting_info` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meetingarrangements
#

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
  KEY `FKD3EFA8646EE2FAB6` (`meetingInfo`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table meetingarrangements
#

LOCK TABLES `meetingarrangements` WRITE;
/*!40000 ALTER TABLE `meetingarrangements` DISABLE KEYS */;
/*!40000 ALTER TABLE `meetingarrangements` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meetingroom
#

DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `name` text,
  `address` text,
  `number` int(11) NOT NULL,
  `host` varchar(20) DEFAULT NULL,
  `backplane` int(11) DEFAULT NULL,
  `scroll` int(11) DEFAULT NULL,
  `projector` int(11) DEFAULT NULL,
  `wired` int(11) DEFAULT NULL,
  `wireless` int(11) DEFAULT NULL,
  `recording` int(11) DEFAULT NULL,
  `video` int(11) DEFAULT NULL,
  `tea` int(11) DEFAULT NULL,
  `fruit` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKCB6635966B3D95E3` (`meetingid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table meetingroom
#

LOCK TABLES `meetingroom` WRITE;
/*!40000 ALTER TABLE `meetingroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `meetingroom` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table module
#

DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table module
#

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (2,'询价管理',NULL,NULL);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table notice
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingid` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `FKC20796D86B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk COMMENT='通知单';

#
# Dumping data for table notice
#

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (2,2,'2010-12-02',321);
INSERT INTO `notice` VALUES (3,3,'2010-10-13',123);
INSERT INTO `notice` VALUES (4,6,'2010-10-14',144);
INSERT INTO `notice` VALUES (5,12,'2010-10-20',200);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table outlay
#

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
  KEY `FKC411079626A7F953` (`meetingfeeitemid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

#
# Dumping data for table outlay
#

LOCK TABLES `outlay` WRITE;
/*!40000 ALTER TABLE `outlay` DISABLE KEYS */;
INSERT INTO `outlay` VALUES (4,4,1200,'13',1,1,NULL,NULL);
INSERT INTO `outlay` VALUES (5,4,1111,'12',NULL,NULL,NULL,'2010-10-15 03:05:05');
/*!40000 ALTER TABLE `outlay` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table price
#

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=gbk COMMENT='询价';

#
# Dumping data for table price
#

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (8,123,'2010-12-03','123','123',NULL,NULL,NULL,NULL,'2010-12-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (15,2123,'2010-12-02','231','123',NULL,NULL,NULL,NULL,'2010-12-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (16,1,'2010-09-30','1','12',NULL,NULL,NULL,NULL,'2010-12-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (17,321,'2010-10-14','阿发','事实上',NULL,NULL,NULL,NULL,'2010-12-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (18,321,'2010-10-13','分手费大幅上升','是否',NULL,NULL,NULL,NULL,'2010-12-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (19,1,'2010-10-13','1','1',NULL,NULL,NULL,NULL,'2010-12-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (20,1,'2010-10-13','1','1',NULL,NULL,NULL,NULL,'2010-12-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (21,1,'2010-10-13','1','1',NULL,NULL,NULL,NULL,'2010-12-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (23,1,'2010-10-13','1','1',NULL,NULL,NULL,NULL,'2010-12-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (24,20000,'2010-10-29','hanzhou','hotel',NULL,NULL,NULL,NULL,'2010-12-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `price` VALUES (25,1,'2010-12-04','滨江','酒店名称','酒店交通','周边环境',NULL,12,'2010-12-03',NULL,'12',NULL,NULL,'',1,1,1,1,NULL,1,1,1,NULL,NULL,NULL,NULL,1,1,'第三代',1,2,1,2,1,2,1,1,1,1,1,1,1,1,'',1,1,NULL,NULL,NULL);
INSERT INTO `price` VALUES (26,1,'2010-12-04','地点','酒店名称','酒店交通','周边环境',NULL,NULL,'2010-12-04',NULL,'12',NULL,NULL,'',1,1,1,1,NULL,1,1,1,NULL,NULL,NULL,NULL,1,1,'大苏打',1,2,1,2,1,2,1,1,1,1,1,1,12,12,'',1,1,NULL,NULL,NULL);
INSERT INTO `price` VALUES (27,1,'2010-12-04','地点','酒店名称','酒店交通','周边环境',NULL,NULL,'2010-12-04',NULL,'12',NULL,NULL,'',1,1,1,1,NULL,1,1,1,NULL,NULL,NULL,NULL,1,1,'大苏打',1,2,1,2,1,2,1,1,1,1,1,1,12,12,'',1,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table priceroomtype
#

DROP TABLE IF EXISTS `priceroomtype`;
CREATE TABLE `priceroomtype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `minRoomNumber` int(11) DEFAULT NULL,
  `maxRoomNumber` int(11) DEFAULT NULL,
  `priceid` int(11) DEFAULT NULL,
  `roomtypeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKC55C82DE7E30B831` (`priceid`),
  KEY `FKC55C82DEE9EA67E1` (`roomtypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table priceroomtype
#

LOCK TABLES `priceroomtype` WRITE;
/*!40000 ALTER TABLE `priceroomtype` DISABLE KEYS */;
INSERT INTO `priceroomtype` VALUES (1,1,2,27,1);
INSERT INTO `priceroomtype` VALUES (2,2,3,27,2);
/*!40000 ALTER TABLE `priceroomtype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table register
#

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
  KEY `FKD6DC2EA36B3D95E3` (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

#
# Dumping data for table register
#

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (8,2,2,'部分',120,11,1,'1','1000',1,'1002','111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `register` VALUES (11,2,1,'部分',120,10,11,'1','1000',1,'1','1003',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `register` VALUES (12,10,1,'全部',2,2,1,'11','111',1,'2','111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `register` VALUES (16,2,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2010-12-03 09:21:26',NULL,0,'jumkey2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table relatives
#

DROP TABLE IF EXISTS `relatives`;
CREATE TABLE `relatives` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL COMMENT '能带亲属的所有活动:报到BD，宴请YQ，活动HD',
  `theirid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKFF8B5F275F3DBEAD` (`userid`),
  KEY `FKFF8B5F27409E207C` (`theirid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table relatives
#

LOCK TABLES `relatives` WRITE;
/*!40000 ALTER TABLE `relatives` DISABLE KEYS */;
/*!40000 ALTER TABLE `relatives` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table role
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `FK35807671569EA8` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table role
#

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员',1,'2010-12-02 15:16:13');
INSERT INTO `role` VALUES (2,'普通用户',1,'2010-12-02 15:16:16');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table role_limit
#

DROP TABLE IF EXISTS `role_limit`;
CREATE TABLE `role_limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL DEFAULT '0',
  `limitid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK6C747EB259E86943` (`roleid`),
  KEY `FK6C747EB29B3B1895` (`limitid`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=gbk;

#
# Dumping data for table role_limit
#

LOCK TABLES `role_limit` WRITE;
/*!40000 ALTER TABLE `role_limit` DISABLE KEYS */;
INSERT INTO `role_limit` VALUES (176,1,1);
INSERT INTO `role_limit` VALUES (177,1,2);
INSERT INTO `role_limit` VALUES (178,1,3);
INSERT INTO `role_limit` VALUES (179,1,4);
INSERT INTO `role_limit` VALUES (180,1,5);
INSERT INTO `role_limit` VALUES (181,1,6);
INSERT INTO `role_limit` VALUES (182,1,7);
INSERT INTO `role_limit` VALUES (183,1,8);
INSERT INTO `role_limit` VALUES (184,1,9);
INSERT INTO `role_limit` VALUES (185,1,10);
INSERT INTO `role_limit` VALUES (186,1,11);
INSERT INTO `role_limit` VALUES (187,1,12);
INSERT INTO `role_limit` VALUES (188,1,13);
INSERT INTO `role_limit` VALUES (189,1,14);
INSERT INTO `role_limit` VALUES (190,1,15);
INSERT INTO `role_limit` VALUES (191,1,16);
INSERT INTO `role_limit` VALUES (192,1,17);
INSERT INTO `role_limit` VALUES (193,1,18);
/*!40000 ALTER TABLE `role_limit` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table roomtype
#

DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `FK35807671569EA8` (`creator`),
  KEY `FKF5BA2A9571569EA8` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table roomtype
#

LOCK TABLES `roomtype` WRITE;
/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
INSERT INTO `roomtype` VALUES (1,'标准双人间',1,NULL);
INSERT INTO `roomtype` VALUES (2,'标准单人间',1,'2010-12-02 05:01:47');
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table send_notification_plan
#

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
  KEY `FKD8F37D06E9EA67E1` (`roomtypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

#
# Dumping data for table send_notification_plan
#

LOCK TABLES `send_notification_plan` WRITE;
/*!40000 ALTER TABLE `send_notification_plan` DISABLE KEYS */;
INSERT INTO `send_notification_plan` VALUES (5,2,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `send_notification_plan` VALUES (6,2,NULL,NULL,3,NULL,'已回执','2010-10-13 08:21:52',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `send_notification_plan` VALUES (10,2,NULL,NULL,1,NULL,'已回执','2010-10-25 09:55:40',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `send_notification_plan` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table sysaccount
#

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
  KEY `FK3550FAC059E86943` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='系统账号';

#
# Dumping data for table sysaccount
#

LOCK TABLES `sysaccount` WRITE;
/*!40000 ALTER TABLE `sysaccount` DISABLE KEYS */;
INSERT INTO `sysaccount` VALUES (1,'admin','123','admin',0,'13888888888','310001','杭州',1,1,'2010-09-16 10:49:28',1);
/*!40000 ALTER TABLE `sysaccount` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tradetype
#

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
  KEY `FK2CEF2E9EA892DC66` (`unittypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=gbk;

#
# Dumping data for table tradetype
#

LOCK TABLES `tradetype` WRITE;
/*!40000 ALTER TABLE `tradetype` DISABLE KEYS */;
INSERT INTO `tradetype` VALUES (12,'55',11,1,1,'2010-12-02 06:56:18');
INSERT INTO `tradetype` VALUES (21,'分类1.1',20,2,1,'2010-12-02 10:26:22');
INSERT INTO `tradetype` VALUES (22,'sdfsdf',20,1,1,'2010-12-03 01:18:43');
INSERT INTO `tradetype` VALUES (28,'dsfsd',24,1,1,'2010-12-03 02:05:33');
INSERT INTO `tradetype` VALUES (29,'分类一',0,1,1,'2010-12-03 02:09:11');
INSERT INTO `tradetype` VALUES (30,'分类1.11',29,1,1,'2010-12-03 02:10:12');
/*!40000 ALTER TABLE `tradetype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table units
#

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
  PRIMARY KEY (`Id`),
  KEY `FK6A4576F6386FE11` (`unitstypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='单位';

#
# Dumping data for table units
#

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,'万格','滨江','310000','jj','13888888888','888@qq.com','www.abc.com',1);
INSERT INTO `units` VALUES (2,'哥哥','杭州','321000','狗狗','13888888888','2@sfs.v','www.a.av',2);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table units_type
#

DROP TABLE IF EXISTS `units_type`;
CREATE TABLE `units_type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) NOT NULL DEFAULT '' COMMENT '厂商、设计院、其他',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='单位类型';

#
# Dumping data for table units_type
#

LOCK TABLES `units_type` WRITE;
/*!40000 ALTER TABLE `units_type` DISABLE KEYS */;
INSERT INTO `units_type` VALUES (1,'厂商');
INSERT INTO `units_type` VALUES (2,'设计院');
/*!40000 ALTER TABLE `units_type` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

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
  KEY `FK36EBCB5F3DBEAD` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk COMMENT='个人';

#
# Dumping data for table user
#

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jumkey','专家',1,3,1,'13888888888','11@qq.com','13888888888','杭州','310000','wei','wu',NULL);
INSERT INTO `user` VALUES (2,'jumkey1','专家',1,NULL,1,'13888888888','11@qq.com','13888888888','杭州','310000','wei','wu',NULL);
INSERT INTO `user` VALUES (3,'jumkey2','一般',1,NULL,1,'13888888888','11@qq.com','13888888888','杭州','310000','wei','wu',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table activities
#

ALTER TABLE `activities`
ADD CONSTRAINT `activities_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `FK7A1B3BED6B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table arrangementsseminars
#

ALTER TABLE `arrangementsseminars`
ADD CONSTRAINT `FKCDF76D6B4C9DF0C0` FOREIGN KEY (`lecture`) REFERENCES `lecture` (`Id`),
ADD CONSTRAINT `FKCDF76D6BC139F4AC` FOREIGN KEY (`meetingArrangements`) REFERENCES `meetingarrangements` (`Id`);

#
#  Foreign keys for table awards
#

ALTER TABLE `awards`
ADD CONSTRAINT `awards_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `FKAC40D1B66B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `FKAC40D1B697E125A2` FOREIGN KEY (`units`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `FKAC40D1B6C139F4AC` FOREIGN KEY (`meetingArrangements`) REFERENCES `meetingarrangements` (`Id`);

#
#  Foreign keys for table awards_prize
#

ALTER TABLE `awards_prize`
ADD CONSTRAINT `awards_prize_ibfk_1` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`),
ADD CONSTRAINT `FKB6CA4849509097AA` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`);

#
#  Foreign keys for table department
#

ALTER TABLE `department`
ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table fee_item_property
#

ALTER TABLE `fee_item_property`
ADD CONSTRAINT `fee_item_property_ibfk_1` FOREIGN KEY (`feeitemid`) REFERENCES `fee_item` (`Id`),
ADD CONSTRAINT `FK43091488B3CC7BF1` FOREIGN KEY (`feeitemid`) REFERENCES `fee_item` (`Id`);

#
#  Foreign keys for table fete
#

ALTER TABLE `fete`
ADD CONSTRAINT `FK2FE7706B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table fete_record
#

ALTER TABLE `fete_record`
ADD CONSTRAINT `FK48A844005F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FK48A8440044DF60B7` FOREIGN KEY (`feteid`) REFERENCES `fete` (`Id`);

#
#  Foreign keys for table income
#

ALTER TABLE `income`
ADD CONSTRAINT `FKB969A1A926A7F953` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
ADD CONSTRAINT `FKB969A1A95F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FKB969A1A971569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `FKB969A1A9802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `income_ibfk_1` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
ADD CONSTRAINT `income_ibfk_2` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `income_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `income_ibfk_4` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table join_activities_record
#

ALTER TABLE `join_activities_record`
ADD CONSTRAINT `FKF874E90E4C41D3DE` FOREIGN KEY (`joiner`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FKF874E90ED90E6171` FOREIGN KEY (`activitiesid`) REFERENCES `activities` (`Id`),
ADD CONSTRAINT `join_activities_record_ibfk_1` FOREIGN KEY (`activitiesid`) REFERENCES `activities` (`Id`),
ADD CONSTRAINT `join_activities_record_ibfk_2` FOREIGN KEY (`joiner`) REFERENCES `user` (`Id`);

#
#  Foreign keys for table lecture
#

ALTER TABLE `lecture`
ADD CONSTRAINT `FK3240D7E11D62CDB` FOREIGN KEY (`speakers`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FK3240D7E6B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `FK3240D7E802912FD` FOREIGN KEY (`unitsid`) REFERENCES `units` (`Id`);

#
#  Foreign keys for table limit
#

ALTER TABLE `limit`
ADD CONSTRAINT `FK6234BBB71569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table lottery
#

ALTER TABLE `lottery`
ADD CONSTRAINT `FK1523D7496B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `FK1523D74997667F3A` FOREIGN KEY (`owner`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `lottery_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table lottery_record
#

ALTER TABLE `lottery_record`
ADD CONSTRAINT `FK93187E072CE60F` FOREIGN KEY (`LotteriesId`) REFERENCES `lottery` (`Id`),
ADD CONSTRAINT `FK93187E07509097AA` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`),
ADD CONSTRAINT `lottery_record_ibfk_1` FOREIGN KEY (`awardid`) REFERENCES `awards` (`Id`),
ADD CONSTRAINT `lottery_record_ibfk_2` FOREIGN KEY (`LotteriesId`) REFERENCES `lottery` (`Id`);

#
#  Foreign keys for table meal
#

ALTER TABLE `meal`
ADD CONSTRAINT `FK3313C36B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table meeting_fee_item
#

ALTER TABLE `meeting_fee_item`
ADD CONSTRAINT `FK13F225B06B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `meeting_fee_item_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `meeting_fee_item_ibfk_3` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `meeting_fee_item_ibfk_4` FOREIGN KEY (`feeitemid`) REFERENCES `fee_item` (`Id`);

#
#  Foreign keys for table meeting_fee_item_property
#

ALTER TABLE `meeting_fee_item_property`
ADD CONSTRAINT `FK96584F8426A7F953` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
ADD CONSTRAINT `FK96584F8471569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `meeting_fee_item_property_ibfk_1` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
ADD CONSTRAINT `meeting_fee_item_property_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table meeting_info
#

ALTER TABLE `meeting_info`
ADD CONSTRAINT `FKA05200327E30B831` FOREIGN KEY (`priceid`) REFERENCES `price` (`Id`),
ADD CONSTRAINT `meeting_info_ibfk_1` FOREIGN KEY (`priceid`) REFERENCES `price` (`Id`),
ADD CONSTRAINT `meeting_info_ibfk_2` FOREIGN KEY (`rman`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table meetingroom
#

ALTER TABLE `meetingroom`
ADD CONSTRAINT `FKCB6635966B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table notice
#

ALTER TABLE `notice`
ADD CONSTRAINT `FKC20796D86B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table outlay
#

ALTER TABLE `outlay`
ADD CONSTRAINT `FKC411079626A7F953` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
ADD CONSTRAINT `FKC41107965F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FKC411079671569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `FKC4110796802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `outlay_ibfk_1` FOREIGN KEY (`meetingfeeitemid`) REFERENCES `meeting_fee_item` (`Id`),
ADD CONSTRAINT `outlay_ibfk_2` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `outlay_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `outlay_ibfk_4` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table priceroomtype
#

ALTER TABLE `priceroomtype`
ADD CONSTRAINT `FKC55C82DE7E30B831` FOREIGN KEY (`priceid`) REFERENCES `price` (`Id`),
ADD CONSTRAINT `FKC55C82DEE9EA67E1` FOREIGN KEY (`roomtypeid`) REFERENCES `roomtype` (`Id`);

#
#  Foreign keys for table register
#

ALTER TABLE `register`
ADD CONSTRAINT `FKD6DC2EA35F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FKD6DC2EA36B3D95E3` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`),
ADD CONSTRAINT `register_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `register_ibfk_2` FOREIGN KEY (`meetingid`) REFERENCES `meeting_info` (`Id`);

#
#  Foreign keys for table relatives
#

ALTER TABLE `relatives`
ADD CONSTRAINT `FKFF8B5F27409E207C` FOREIGN KEY (`theirid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FKFF8B5F275F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `relatives_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `relatives_ibfk_2` FOREIGN KEY (`theirid`) REFERENCES `user` (`Id`);

#
#  Foreign keys for table role
#

ALTER TABLE `role`
ADD CONSTRAINT `FK35807671569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `role_ibfk_1` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table role_limit
#

ALTER TABLE `role_limit`
ADD CONSTRAINT `FK6C747EB259E86943` FOREIGN KEY (`roleid`) REFERENCES `role` (`Id`),
ADD CONSTRAINT `FK6C747EB29B3B1895` FOREIGN KEY (`limitid`) REFERENCES `limit` (`Id`);

#
#  Foreign keys for table roomtype
#

ALTER TABLE `roomtype`
ADD CONSTRAINT `FKF5BA2A9571569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table send_notification_plan
#

ALTER TABLE `send_notification_plan`
ADD CONSTRAINT `FKD8F37D065F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FKD8F37D06802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `FKD8F37D06E8FB4687` FOREIGN KEY (`noticeid`) REFERENCES `notice` (`Id`),
ADD CONSTRAINT `FKD8F37D06E9EA67E1` FOREIGN KEY (`roomtypeId`) REFERENCES `roomtype` (`Id`),
ADD CONSTRAINT `FKD8F37D06FE0838B1` FOREIGN KEY (`sender`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `send_notification_plan_ibfk_1` FOREIGN KEY (`noticeid`) REFERENCES `notice` (`Id`),
ADD CONSTRAINT `send_notification_plan_ibfk_2` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `send_notification_plan_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `send_notification_plan_ibfk_4` FOREIGN KEY (`sender`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table sysaccount
#

ALTER TABLE `sysaccount`
ADD CONSTRAINT `FK3550FAC059E86943` FOREIGN KEY (`roleid`) REFERENCES `role` (`Id`),
ADD CONSTRAINT `sysaccount_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
ADD CONSTRAINT `sysaccount_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);

#
#  Foreign keys for table tradetype
#

ALTER TABLE `tradetype`
ADD CONSTRAINT `FK2CEF2E9E71569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `FK2CEF2E9EA892DC66` FOREIGN KEY (`unittypeid`) REFERENCES `units_type` (`Id`);

#
#  Foreign keys for table units
#

ALTER TABLE `units`
ADD CONSTRAINT `FK6A4576F6386FE11` FOREIGN KEY (`unitstypeId`) REFERENCES `units_type` (`Id`),
ADD CONSTRAINT `units_ibfk_1` FOREIGN KEY (`unitstypeId`) REFERENCES `units_type` (`Id`);

#
#  Foreign keys for table user
#

ALTER TABLE `user`
ADD CONSTRAINT `FK36EBCB5F3DBEAD` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`),
ADD CONSTRAINT `FK36EBCB802912FD` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`unitsId`) REFERENCES `units` (`Id`),
ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`Id`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
