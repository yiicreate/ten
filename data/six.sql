/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3336
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3336
 Source Schema         : six

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 31/07/2021 17:08:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级id',
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '部门类型',
  `is_use` tinyint(2) NULL DEFAULT NULL COMMENT '是否启用1启用0未启用',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `sort` int(255) NULL DEFAULT NULL COMMENT '排序',
  `is_use` tinyint(1) NULL DEFAULT NULL COMMENT '是否启用1启用，0未启用',
  `remark` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('64f078fe050341f29177ad0e41eeb86e', '0', '女', 'sex', 2, 1, '性别', '2021-07-31 09:48:33', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_dictionary` VALUES ('663530114fa84c9ab01d44a74142b32a', '0', '否', 'bool', 1, 1, '是否', '2021-07-31 14:19:13', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_dictionary` VALUES ('71cef5673f88434d9620f6a1f4e41346', '1', '男', 'sex', 1, 1, '性别', '2021-07-31 09:47:56', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_dictionary` VALUES ('87b5aa8267b94937b78008f8fdcbdd1a', '1', '是', 'bool', 2, 1, '是否', '2021-07-31 14:19:22', 'c5d4d1d3c50f4673875beec00b527ed2');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '菜单类型1、菜单，2按钮、3数据权限',
  `is_use` tinyint(1) NULL DEFAULT NULL COMMENT '是否启用',
  `target` tinyint(1) NULL DEFAULT NULL COMMENT '是否单独打开',
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('52287c266e38460ebc8ca784388fcc14', '系统管理', 'sys/index', 2, 'ssdww', 1, NULL, 0, '0', '2021-07-20 09:22:56', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('615d822f52e74d389474c63b0ddad22b', '用户管理', 'sys/user', 1, 'ssdww', 1, NULL, 0, '52287c266e38460ebc8ca784388fcc14', '2021-07-20 09:23:32', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('7b7f22e466904bb6907dadccaded3523', '首页', '/index', 1, 'ssdww', 1, NULL, 0, '0', '2021-07-20 09:21:36', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('814b25c100d34c749eaa3a8a60299f1b', '用户授权', 'sys/rules', 1, 'ssdww', 1, NULL, 0, '52287c266e38460ebc8ca784388fcc14', '2021-07-20 09:25:42', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('999727dfd423454fb4d2d9870aa003ad', '菜单管理', 'sys/menu', 2, 'ssdww', 1, NULL, 0, '52287c266e38460ebc8ca784388fcc14', '2021-07-20 09:23:57', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('9d56442a050742c9bd0fc2afc1bc1cf5', '角色管理', 'sys/role', 1, 'ssdww', 1, NULL, 0, '52287c266e38460ebc8ca784388fcc14', '2021-07-20 09:24:15', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('a0cefe50c3cb401ebab3f7ab27aef8f0', '用户修改', 'sys:user:update', 1, 'ssdww', 2, NULL, 0, '615d822f52e74d389474c63b0ddad22b', '2021-07-20 09:29:36', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('aca9082309ed4c44a7432e67180e5d5b', '用户新增', 'sys:user:save', 1, 'ssdww', 2, NULL, 0, '615d822f52e74d389474c63b0ddad22b', '2021-07-20 09:29:21', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('bc2f351bde2d469d8c614dbb1de29fb2', '用户查看', 'sys:user:view', 1, 'ssdww', 2, NULL, 0, '615d822f52e74d389474c63b0ddad22b', '2021-07-20 09:30:28', 'c5d4d1d3c50f4673875beec00b527ed2');
INSERT INTO `sys_menu` VALUES ('f69cc5a1310d407e98055e997861f752', '用户列表', 'sys:user:view', 1, 'dsfsdfdsaf', 2, NULL, 0, '615d822f52e74d389474c63b0ddad22b', '2021-07-20 09:30:18', 'c5d4d1d3c50f4673875beec00b527ed2');

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('1', 'url', 'https://www.baidu.com/');
INSERT INTO `sys_param` VALUES ('2', 'jwtExpireTime', '1000');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名',
  `is_use` tinyint(1) NULL DEFAULT NULL COMMENT '是否可用',
  `rules` blob NULL COMMENT '对应菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('d3eff23ce8f04adda1ead5dc6459f332', '系统管理员', 1, 0x3532323837633236366533383436306562633863613738343338386663633134);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'token',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `company_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司id',
  `department` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门id',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `id_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9bcedfc16e4468552c8bb99900fff15362d60ca0bc471e5a008d89b27066b483', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiYWRtaW4iLCJleHAiOjE2MjcxOTkwNTV9.PwUGsj6fdW-DrP5-AbzB6IZAn_UMG1FlIALHdB4zm4s', 1, '1', '1', NULL, '超级管理员', '1223456', '123457', '2021-07-13 10:53:14', '1');
INSERT INTO `sys_user` VALUES ('2', 'ss', '123', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('3', 'dd', '124', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('c5d4d1d3c50f4673875beec00b527ed2', 'sckr', '9bcedfc16e4468552c8bb99900fff15362d60ca0bc471e5a008d89b27066b483', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoic2NrciIsImV4cCI6MTcxNDA5NTgyNX0.xlGZR_AufzfDxe4ozKTwUFpuqEDGITsqeeXdk_b0fmA', 0, '1', '1', NULL, '自己的2221', '123456789', '123456699', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', 'c5d4d1d3c50f4673875beec00b527ed2', 'd3eff23ce8f04adda1ead5dc6459f332');

SET FOREIGN_KEY_CHECKS = 1;
