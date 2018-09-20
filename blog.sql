/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2018-07-15 10:45:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `userid` int(11) NOT NULL,
  `ccontent` text NOT NULL,
  `ctime` date NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '将还是毒害U盾会啊', '2018-07-13');
INSERT INTO `comment` VALUES ('2', 'huduiwwydu', '2018-07-13');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `content` text NOT NULL,
  `time` datetime NOT NULL,
  `type` char(255) NOT NULL,
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('9', '人工智能', '<p>人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工智能人工</p>', '2018-07-12 22:12:31', '1');
INSERT INTO `news` VALUES ('10', '人工智能2', '<p>人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2人工智能2</p>', '2018-07-12 22:12:49', '1');
INSERT INTO `news` VALUES ('11', '人工智能3', '<p>人工智能3人工智能3人工智能3人工智能3人工智能3人工智能3人工智能3人工智能3人工智能3人工智能3</p>', '2018-07-12 22:13:08', '1');
INSERT INTO `news` VALUES ('12', '人工智能4', '<p>人工智能4人工智能4人工智能4人工智能4人工智能4人工智能4人工智能4人工智能4人工智能4人工智能4</p>', '2018-07-12 22:13:25', '1');
INSERT INTO `news` VALUES ('13', '人工智能5', '<p>人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5人工智能5</p>', '2018-07-12 22:13:51', '1');
INSERT INTO `news` VALUES ('14', '人工智能6', '<p>人工智能6人工智能6人工智能6人工智能6人工智能6人工智能6人工智能6人工智能6人工智能6人工智能6</p>', '2018-07-12 22:14:08', '1');
INSERT INTO `news` VALUES ('15', '云计算1', '<p>云计算1云计算1云计算1云计算1云计算1云计算1云计算1云计算1云计算1云计算1云计算1云计算1云计算1</p>', '2018-07-12 22:14:37', '2');
INSERT INTO `news` VALUES ('16', '云计算2', '<p>云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2云计算2</p>', '2018-07-12 22:15:00', '2');
INSERT INTO `news` VALUES ('17', '云计算3', '<p>云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3云计算3</p>', '2018-07-12 22:15:16', '2');
INSERT INTO `news` VALUES ('19', '区块链1', '<p>区块链1区块链1区块链1区块链1区块链1区块链1区块链1区块链1区块链1</p>', '2018-07-12 22:23:03', '3');
INSERT INTO `news` VALUES ('21', '数据库1', '<p>数据库1数据库1数据库1数据库1数据库1数据库1数据库1数据库1数据库1数据库1数据库1</p>', '2018-07-12 22:24:08', '4');
INSERT INTO `news` VALUES ('22', '数据库2', '<p>数据库2数据库2数据库2数据库2数据库2数据库2数据库2数据库2数据库2数据库2数据库2</p>', '2018-07-12 22:24:22', '4');
INSERT INTO `news` VALUES ('23', '程序人生', '<p>程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生程序人生</p>', '2018-07-12 22:24:41', '5');
INSERT INTO `news` VALUES ('24', '程序人生2', '<p>程序人生2程序人生2程序人生2程序人生2程序人生2程序人生2程序人生2程序人生2</p>', '2018-07-12 22:25:10', '5');
INSERT INTO `news` VALUES ('25', '游戏人生1', '<p>游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1游戏人生1<br/></p>', '2018-07-12 22:25:37', '6');
INSERT INTO `news` VALUES ('26', '研发管理1', '<p>研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1研发管理1</p>', '2018-07-12 22:26:02', '7');
INSERT INTO `news` VALUES ('27', '前端11', '<p>前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11前端11</p>', '2018-07-12 22:26:20', '8');
INSERT INTO `news` VALUES ('28', '移动开发', '<p>移动开发移动开发移动开发移动开发移动开发移动开发移动开发移动开发移动开发移动开发移动开发移动开发移动开发</p>', '2018-07-12 22:26:36', '9');
INSERT INTO `news` VALUES ('29', '物联网', '<p>物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网物联网</p>', '2018-07-12 22:26:54', '10');
INSERT INTO `news` VALUES ('30', '编程语言', '<p>编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言编程语言</p>', '2018-07-12 22:27:12', '11');
INSERT INTO `news` VALUES ('31', '计算机基础', '<p>计算机基础计算机基础计算机基础计算机基础计算机基础计算机基础计算机基础计算机基础计算机基础计算机基础计算机基础</p>', '2018-07-12 22:27:39', '12');
INSERT INTO `news` VALUES ('32', '云计算yynews', '<p>云计算yynews云计算yynews云计算yynews云计算yynews云计算yynews云计算yynews云计算yynews云计算yynews云计算yynews</p>', '2018-07-12 22:54:07', '2');
INSERT INTO `news` VALUES ('33', '研发', '<p>研发研发研发研发研发研发研发研发研发研发研发研发研发研发研发<img src=\"http://img.baidu.com/hi/jx2/j_0019.gif\"/></p>', '2018-07-12 23:00:23', '7');
INSERT INTO `news` VALUES ('34', '1111111', '<p>11111111111111111111111111111111111111111</p>', '2018-07-12 23:38:29', '12');
INSERT INTO `news` VALUES ('35', '12121212', '<p>1212121212121111111111111111111111111111</p>', '2018-07-12 23:48:26', '11');
INSERT INTO `news` VALUES ('36', '到底发生地方地方', '<p>发生大幅度双方的个地方个地方</p>', '2018-07-13 10:56:12', '5');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('4', '11', '111111', '111@qq.com');
INSERT INTO `userinfo` VALUES ('5', '111111', '111111', '111@qq.com');
INSERT INTO `userinfo` VALUES ('6', '111111', '111111', '111@qq.com');
INSERT INTO `userinfo` VALUES ('7', '111111', '111111', '111@qq.com');
