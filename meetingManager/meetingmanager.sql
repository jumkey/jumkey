# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: meetingmanager
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table activities
#

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table agreement
#

DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table agreement
#

LOCK TABLES `agreement` WRITE;
/*!40000 ALTER TABLE `agreement` DISABLE KEYS */;
/*!40000 ALTER TABLE `agreement` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table awards
#

DROP TABLE IF EXISTS `awards`;
CREATE TABLE `awards` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table awards
#

LOCK TABLES `awards` WRITE;
/*!40000 ALTER TABLE `awards` DISABLE KEYS */;
/*!40000 ALTER TABLE `awards` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table awards_prize
#

DROP TABLE IF EXISTS `awards_prize`;
CREATE TABLE `awards_prize` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
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
  `departmentname` varchar(20) DEFAULT NULL,
  `departmentid` int(11) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK328E4352F9502AFB` (`departmentid`),
  KEY `FK328E435271569EA8` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table fee_item
#

LOCK TABLES `fee_item` WRITE;
/*!40000 ALTER TABLE `fee_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_item` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fee_item_property
#

DROP TABLE IF EXISTS `fee_item_property`;
CREATE TABLE `fee_item_property` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='宴请';

#
# Dumping data for table fete
#

LOCK TABLES `fete` WRITE;
/*!40000 ALTER TABLE `fete` DISABLE KEYS */;
/*!40000 ALTER TABLE `fete` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fete_record
#

DROP TABLE IF EXISTS `fete_record`;
CREATE TABLE `fete_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table income
#

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table join_activities_record
#

DROP TABLE IF EXISTS `join_activities_record`;
CREATE TABLE `join_activities_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table join_activities_record
#

LOCK TABLES `join_activities_record` WRITE;
/*!40000 ALTER TABLE `join_activities_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `join_activities_record` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table limit
#

DROP TABLE IF EXISTS `limit`;
CREATE TABLE `limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table limit
#

LOCK TABLES `limit` WRITE;
/*!40000 ALTER TABLE `limit` DISABLE KEYS */;
/*!40000 ALTER TABLE `limit` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table lottery_no
#

DROP TABLE IF EXISTS `lottery_no`;
CREATE TABLE `lottery_no` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table lottery_no
#

LOCK TABLES `lottery_no` WRITE;
/*!40000 ALTER TABLE `lottery_no` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottery_no` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table lottery_record
#

DROP TABLE IF EXISTS `lottery_record`;
CREATE TABLE `lottery_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table lottery_record
#

LOCK TABLES `lottery_record` WRITE;
/*!40000 ALTER TABLE `lottery_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottery_record` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meeting_fee_item
#

DROP TABLE IF EXISTS `meeting_fee_item`;
CREATE TABLE `meeting_fee_item` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table meeting_fee_item
#

LOCK TABLES `meeting_fee_item` WRITE;
/*!40000 ALTER TABLE `meeting_fee_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting_fee_item` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table meeting_fee_item_property
#

DROP TABLE IF EXISTS `meeting_fee_item_property`;
CREATE TABLE `meeting_fee_item_property` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
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
  `date` timestamp NULL DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `desc` text,
  `rdate` timestamp NULL DEFAULT NULL,
  `rman` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='会议信息';

#
# Dumping data for table meeting_info
#

LOCK TABLES `meeting_info` WRITE;
/*!40000 ALTER TABLE `meeting_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting_info` ENABLE KEYS */;
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='通知单';

#
# Dumping data for table notice
#

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table outlay
#

DROP TABLE IF EXISTS `outlay`;
CREATE TABLE `outlay` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table outlay
#

LOCK TABLES `outlay` WRITE;
/*!40000 ALTER TABLE `outlay` DISABLE KEYS */;
/*!40000 ALTER TABLE `outlay` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table price
#

DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) DEFAULT NULL,
  `unitsId` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `hotel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='询价';

#
# Dumping data for table price
#

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table register
#

DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table register
#

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table relatives
#

DROP TABLE IF EXISTS `relatives`;
CREATE TABLE `relatives` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table role
#

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table send_notification_plan
#

DROP TABLE IF EXISTS `send_notification_plan`;
CREATE TABLE `send_notification_plan` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table send_notification_plan
#

LOCK TABLES `send_notification_plan` WRITE;
/*!40000 ALTER TABLE `send_notification_plan` DISABLE KEYS */;
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
  `departmentid` int(11) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `FK3550FAC0F9502AFB` (`departmentid`),
  KEY `FK3550FAC071569EA8` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

#
# Dumping data for table sysaccount
#

LOCK TABLES `sysaccount` WRITE;
/*!40000 ALTER TABLE `sysaccount` DISABLE KEYS */;
INSERT INTO `sysaccount` VALUES (1,'admin','123','admin',1,'13888888888','310001','杭州',1,1,'2010-09-16 10:49:28');
INSERT INTO `sysaccount` VALUES (2,'jumkey','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (3,'test','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (4,'jumkey8','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (5,'test8','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (6,'jumkey9','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (7,'test9','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (8,'jumkey10','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (9,'test10','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (10,'jumkey11','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (11,'test11','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (12,'jumkey12','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (13,'test12','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (14,'jumkey13','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (15,'test13','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (16,'jumkey1','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (17,'test1','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (18,'jumkey2','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (19,'test2','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (20,'jumkey3','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (21,'test3','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (22,'jumkey4','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (23,'test4','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (24,'jumkey5','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (25,'test5','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (26,'jumkey6','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (27,'test6','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (28,'jumkey7','123456','jumkey',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
INSERT INTO `sysaccount` VALUES (29,'test7','123456','tester',0,'13999999999','310000','杭州',1,1,'2010-09-20 15:57:32');
/*!40000 ALTER TABLE `sysaccount` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table units
#

DROP TABLE IF EXISTS `units`;
CREATE TABLE `units` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `zip` varchar(6) DEFAULT NULL,
  `connect` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `site` varchar(50) DEFAULT NULL,
  `unitsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='单位';

#
# Dumping data for table units
#

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table units_type
#

DROP TABLE IF EXISTS `units_type`;
CREATE TABLE `units_type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL COMMENT '厂商、设计院、其他',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='单位类型';

#
# Dumping data for table units_type
#

LOCK TABLES `units_type` WRITE;
/*!40000 ALTER TABLE `units_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `units_type` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='个人';

#
# Dumping data for table user
#

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table department
#

ALTER TABLE `department`
ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `FK328E435271569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `FK328E4352F9502AFB` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`);

#
#  Foreign keys for table sysaccount
#

ALTER TABLE `sysaccount`
ADD CONSTRAINT `FK3550FAC071569EA8` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`),
ADD CONSTRAINT `FK3550FAC0F9502AFB` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
ADD CONSTRAINT `sysaccount_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
ADD CONSTRAINT `sysaccount_ibfk_2` FOREIGN KEY (`creator`) REFERENCES `sysaccount` (`id`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
