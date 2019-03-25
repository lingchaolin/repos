/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-09-02 21:36:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` int(20) DEFAULT NULL,
  `department` varchar(10) DEFAULT NULL,
  `salary` int(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO people VALUES ('124', '张三', '1', 'vendition', '12345');
INSERT INTO people VALUES ('125', '李若彤', '0', 'lead', '12345');
INSERT INTO people VALUES ('126', '郭净', '1', 'lead', '56655');
INSERT INTO people VALUES ('127', '杨康', '0', 'secretary', '999');
INSERT INTO people VALUES ('128', '胡一刀', '1', 'secretary', '100');
INSERT INTO people VALUES ('129', '周星驰', '1', 'lead', '18832');
INSERT INTO people VALUES ('130', '火焰', '0', 'lead', '18832');
INSERT INTO people VALUES ('131', '杨过', '0', 'secretary', '999');
INSERT INTO people VALUES ('132', '白术', '1', 'vendition', '8899');
INSERT INTO people VALUES ('133', '白虎', '0', 'vendition', '5654');
INSERT INTO people VALUES ('134', '火神', '0', 'vendition', '5654');
INSERT INTO people VALUES ('138', '张三', '1', 'lead', '20202');
INSERT INTO people VALUES ('139', '李四', '1', 'lead', '1010');
INSERT INTO people VALUES ('142', '张三2018', '1', 'home', '1231');
INSERT INTO people VALUES ('143', 'lili', '1', 'home', '1231');
INSERT INTO people VALUES ('999', '张三2019', '1', 'home', '1231');
