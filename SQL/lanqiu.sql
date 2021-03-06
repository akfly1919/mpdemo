/*
Navicat MySQL Data Transfer

Source Server         : 140.143.94.196
Source Server Version : 50633
Source Host           : 140.143.94.196:3306
Source Database       : lanqiu

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-06-19 15:21:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `game`
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `match_id` varchar(32) DEFAULT NULL,
  `game_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `aid` varchar(32) DEFAULT NULL,
  `bid` varchar(32) DEFAULT NULL,
  `ascore` int(11) DEFAULT NULL,
  `bscore` int(11) DEFAULT NULL,
  `ascore_detail` varchar(255) DEFAULT NULL,
  `bscore_detail` varchar(255) DEFAULT NULL,
  `game_didian` varchar(255) DEFAULT NULL,
  `game_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `match_id` (`match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of game
-- ----------------------------

-- ----------------------------
-- Table structure for `game_player_detail`
-- ----------------------------
DROP TABLE IF EXISTS `game_player_detail`;
CREATE TABLE `game_player_detail` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `game_id` bigint(20) DEFAULT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  `player_id` bigint(20) DEFAULT NULL,
  `sf` tinyint(4) DEFAULT NULL,
  `num` tinyint(11) DEFAULT NULL,
  `min` tinyint(11) DEFAULT NULL,
  `fg` tinyint(11) DEFAULT NULL,
  `fgt` tinyint(11) DEFAULT NULL,
  `pt3` tinyint(11) DEFAULT NULL,
  `pt3t` tinyint(11) DEFAULT NULL,
  `ft` tinyint(11) DEFAULT NULL,
  `ftt` tinyint(11) DEFAULT NULL,
  `oreb` tinyint(11) DEFAULT NULL,
  `dreb` tinyint(11) DEFAULT NULL,
  `reb` tinyint(11) DEFAULT NULL,
  `ast` tinyint(11) DEFAULT NULL,
  `stl` tinyint(11) DEFAULT NULL,
  `blk` tinyint(11) DEFAULT NULL,
  `to` tinyint(11) DEFAULT NULL,
  `pf` tinyint(11) DEFAULT NULL,
  `pts` tinyint(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `game_team_player` (`game_id`,`team_id`,`player_id`),
  KEY `game_id` (`game_id`),
  KEY `team_id` (`team_id`),
  KEY `player_id` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of game_player_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `lq_match`
-- ----------------------------
DROP TABLE IF EXISTS `lq_match`;
CREATE TABLE `lq_match` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `match_id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lq_desc` varchar(255) DEFAULT NULL,
  `openid` varchar(100) DEFAULT NULL,
  `unionid` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `status` varchar(4) DEFAULT '0',
  `num` int(4) DEFAULT NULL,
  `groupNum` int(4) DEFAULT NULL,
  `picUrl` varchar(255) DEFAULT NULL,
  `begTime` timestamp NULL DEFAULT NULL,
  `endTime` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of lq_match
-- ----------------------------

-- ----------------------------
-- Table structure for `match_team`
-- ----------------------------
DROP TABLE IF EXISTS `match_team`;
CREATE TABLE `match_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `match_id` varchar(32) DEFAULT NULL,
  `team_id` varchar(32) DEFAULT NULL,
  `team_w_name` varchar(255) DEFAULT NULL,
  `group_name` varchar(4) DEFAULT NULL,
  `v_count` tinyint(4) DEFAULT NULL,
  `f_count` tinyint(4) DEFAULT NULL,
  `q_count` tinyint(4) DEFAULT NULL,
  `point` varchar(100) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of match_team
-- ----------------------------

-- ----------------------------
-- Table structure for `player`
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `openid` varchar(32) DEFAULT NULL,
  `unionid` varchar(255) DEFAULT NULL,
  `bri` timestamp NULL DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL,
  `lq_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `openid` (`openid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of player
-- ----------------------------

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `lq_desc` varchar(255) DEFAULT NULL,
  `status` varchar(4) DEFAULT '0',
  `openId` varchar(100) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teamId` (`team_id`),
  KEY `openId` (`openId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for `team_player`
-- ----------------------------
DROP TABLE IF EXISTS `team_player`;
CREATE TABLE `team_player` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `team_id` bigint(20) DEFAULT NULL,
  `player_id` bigint(20) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team_player
-- ----------------------------
