/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-07-25 10:26:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_info`;
CREATE TABLE `sys_menu_info` (
  `menu_id` varchar(20) NOT NULL COMMENT '权限ID',
  `menu_name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `menu_father_id` varchar(20) NOT NULL COMMENT '权限父级ID',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单树连接路径',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_info
-- ----------------------------
INSERT INTO `sys_menu_info` VALUES ('m1001', '菜单一', '000', 'http：//127.0.0.1:80/caidanyi', '第一个菜单', '2018-07-19 16:41:50');

-- ----------------------------
-- Table structure for `sys_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info` (
  `role_id` varchar(20) NOT NULL COMMENT '角色ID',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_info
-- ----------------------------
INSERT INTO `sys_role_info` VALUES ('r1001', '管理员', '管理员权限', '2018-07-19 16:40:15');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `connection_id` varchar(10) NOT NULL COMMENT '关系ID',
  `role_id` varchar(20) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(20) NOT NULL COMMENT '权限ID',
  `popedom` int(1) NOT NULL COMMENT '权限（1为可用，2为不可用）',
  PRIMARY KEY (`connection_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('rm1001', 'r1001', 'm1001', '1');

-- ----------------------------
-- Table structure for `sys_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(20) DEFAULT '' COMMENT '用户名',
  `login_name` varchar(20) NOT NULL COMMENT '登录用户名',
  `login_password` varchar(20) NOT NULL COMMENT '密码',
  `role_id` varchar(20) DEFAULT NULL COMMENT '角色ID',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `tel` varchar(20) DEFAULT NULL COMMENT '手机号',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `count` bigint(100) DEFAULT NULL COMMENT '登录次数',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('u1001', '管理员', 'admin', '123456', 'r1001', '65456456@163.com', '138546456456', '2018-07-19 00:00:00', null, null, null, '管理员账户');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `connection_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `role_id` varchar(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`connection_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', 'u1001', 'r1001');
