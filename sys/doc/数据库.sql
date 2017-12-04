/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : world

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-16 12:30:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zc_acc_account`
-- ----------------------------
DROP TABLE IF EXISTS `zc_acc_account`;
CREATE TABLE `zc_acc_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `total` decimal(20,2) DEFAULT NULL COMMENT '账户总额',
  `balance` decimal(20,2) DEFAULT NULL COMMENT '可用余额',
  `freeze_amount` decimal(20,2) DEFAULT NULL COMMENT '冻结金额',
  `version` int(11) DEFAULT NULL COMMENT '版本控制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户表：zc_acc_account';

-- ----------------------------
-- Records of zc_acc_account
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_acc_account_deduct`
-- ----------------------------
DROP TABLE IF EXISTS `zc_acc_account_deduct`;
CREATE TABLE `zc_acc_account_deduct` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '操作金额',
  `order_no` varchar(64) DEFAULT NULL COMMENT '订单号',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `operate_user` varchar(64) DEFAULT NULL COMMENT '操作管理员',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(6646) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下扣款记录：zc_acc_account_deduct';

-- ----------------------------
-- Records of zc_acc_account_deduct
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_acc_account_log`
-- ----------------------------
DROP TABLE IF EXISTS `zc_acc_account_log`;
CREATE TABLE `zc_acc_account_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `total` decimal(20,2) DEFAULT NULL COMMENT '账户总额',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '操作金额',
  `balance` decimal(20,2) DEFAULT NULL COMMENT '可用余额',
  `freeze_amount` decimal(20,2) DEFAULT NULL COMMENT '冻结金额',
  `to_user_id` int(11) DEFAULT NULL COMMENT '交易方用户',
  `content` varchar(512) DEFAULT NULL COMMENT '日志内容',
  `payemnts_type` int(11) DEFAULT NULL COMMENT '收支方式',
  `order_no` varchar(128) DEFAULT NULL COMMENT '关联订单',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金日志表：zc_acc_account_log';

-- ----------------------------
-- Records of zc_acc_account_log
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_acc_bank_card`
-- ----------------------------
DROP TABLE IF EXISTS `zc_acc_bank_card`;
CREATE TABLE `zc_acc_bank_card` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `bank_card_no` varchar(64) DEFAULT NULL COMMENT '银行卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '所属行编码',
  `bank_name` varchar(32) DEFAULT NULL COMMENT '所属行名称',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `branch` varchar(255) DEFAULT NULL COMMENT '支行',
  `branch_name` varchar(128) DEFAULT NULL COMMENT '支行名称',
  `province` varchar(64) DEFAULT NULL COMMENT '省',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `area` varchar(64) DEFAULT NULL COMMENT '区',
  `mobile` varchar(64) DEFAULT NULL COMMENT '预留手机号',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '剩余提取金额',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `auto_deduct` int(11) DEFAULT NULL COMMENT '自动扣款状态',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(64) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡表：zc_acc_bank_card';

-- ----------------------------
-- Records of zc_acc_bank_card
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_acc_recharge`
-- ----------------------------
DROP TABLE IF EXISTS `zc_acc_recharge`;
CREATE TABLE `zc_acc_recharge` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '操作金额',
  `arrival_amount` decimal(20,2) DEFAULT NULL COMMENT '实际到账金额',
  `type` int(11) DEFAULT NULL COMMENT '充值类型',
  `way` int(11) DEFAULT NULL COMMENT '支付方式',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `bank_card_no` varchar(64) DEFAULT NULL COMMENT '银行卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '所属行编码',
  `mobile` varchar(64) DEFAULT NULL COMMENT '预留手机号',
  `real_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `order_no` varchar(64) DEFAULT NULL COMMENT '订单号',
  `order_no_extra` varchar(64) DEFAULT NULL COMMENT '分步订单号',
  `result_msg` varchar(128) DEFAULT NULL COMMENT '结果描述',
  `route` int(11) DEFAULT NULL COMMENT '渠道',
  `fee` decimal(20,2) DEFAULT NULL COMMENT '手续费',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `operate_user` varchar(64) DEFAULT NULL COMMENT '操作管理员',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(64) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值记录表：zc_acc_recharge';

-- ----------------------------
-- Records of zc_acc_recharge
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_acc_withdraw_cash`
-- ----------------------------
DROP TABLE IF EXISTS `zc_acc_withdraw_cash`;
CREATE TABLE `zc_acc_withdraw_cash` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '操作金额',
  `arrival_amount` decimal(20,2) DEFAULT NULL COMMENT '实际到账金额',
  `fee` decimal(20,2) DEFAULT NULL COMMENT '手续费',
  `bank_card_no` varchar(64) DEFAULT NULL COMMENT '银行卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '所属行编码',
  `mobile` varchar(64) DEFAULT NULL COMMENT '预留手机号',
  `real_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `result_msg` varchar(128) DEFAULT NULL COMMENT '结果描述',
  `route` int(11) DEFAULT NULL COMMENT '渠道',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `operate_user` varchar(64) DEFAULT NULL COMMENT '操作管理员',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(64) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提现记录表：zc_acc_withdraw_cash';

-- ----------------------------
-- Records of zc_acc_withdraw_cash
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_cl_cash_loan`
-- ----------------------------
DROP TABLE IF EXISTS `zc_cl_cash_loan`;
CREATE TABLE `zc_cl_cash_loan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `cno` varchar(64) DEFAULT NULL COMMENT '借款编号',
  `name` varchar(128) DEFAULT NULL COMMENT '产品名称',
  `user_id` int(11) DEFAULT NULL COMMENT '债务人',
  `type` int(11) DEFAULT NULL COMMENT '产品类型',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `total` decimal(20,2) DEFAULT NULL COMMENT '借款本金总额',
  `repayment_type` int(11) DEFAULT NULL COMMENT '还款方式',
  `period_unit` int(11) DEFAULT NULL COMMENT '期限单位',
  `period` int(11) DEFAULT NULL COMMENT '期限',
  `rate` decimal(20,2) DEFAULT NULL COMMENT '天利率',
  `overdue_rate` decimal(20,2) DEFAULT NULL COMMENT '逾期天利率',
  `service_fee_type` int(11) DEFAULT NULL COMMENT '服务费收取类型',
  `service_fee_value` decimal(20,0) DEFAULT NULL COMMENT '服务费收取值',
  `repayment_total` decimal(20,2) DEFAULT NULL COMMENT '应还总额',
  `repayment_capital` decimal(20,2) DEFAULT NULL COMMENT '应还本金',
  `repayment_interest` decimal(20,2) DEFAULT NULL COMMENT '应还利息',
  `repayment_service_fee` decimal(20,2) DEFAULT NULL COMMENT '应还服务费',
  `repaid_total` decimal(20,2) DEFAULT NULL COMMENT '已还款总额',
  `repaid_capital` decimal(20,2) DEFAULT NULL COMMENT '已还款本金',
  `repaid_interest` decimal(20,2) DEFAULT NULL COMMENT '已还利息',
  `repaid_overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '已还逾期利息',
  `repaid_service_fee` decimal(20,2) DEFAULT NULL COMMENT '已还服务费',
  `is_interest_free_note` int(11) DEFAULT NULL COMMENT '是否使用免息券',
  `interest_free_amount` decimal(20,2) DEFAULT NULL COMMENT '免息总金额',
  `is_prepayment` int(11) DEFAULT NULL COMMENT '是否可提前还款',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_operator_id` int(11) DEFAULT NULL COMMENT '放款管理员',
  `loan_time` datetime DEFAULT NULL COMMENT '放款时间',
  `loan_way` int(11) DEFAULT NULL COMMENT '放款方式：放款到银行卡,放款到账户余额',
  `loan_account` varchar(64) DEFAULT NULL COMMENT '放款账户',
  `loan_order_no` varchar(64) DEFAULT NULL COMMENT '放款流水',
  `loan_operator_id` int(11) DEFAULT NULL COMMENT '放款管理员',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `version` int(11) DEFAULT NULL COMMENT '版本控制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='现金贷借款表zc_cl_cash_loan';

-- ----------------------------
-- Records of zc_cl_cash_loan
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_cl_cash_loan_repayment`
-- ----------------------------
DROP TABLE IF EXISTS `zc_cl_cash_loan_repayment`;
CREATE TABLE `zc_cl_cash_loan_repayment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '债务用户',
  `cash_loan_id` int(11) DEFAULT NULL COMMENT '贷款id',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `period` varchar(32) DEFAULT NULL COMMENT '期数',
  `repayment_time` datetime DEFAULT NULL COMMENT '预还款时间',
  `repayment_total` decimal(20,2) DEFAULT NULL COMMENT '预还款总额',
  `repayment_capital` decimal(20,2) DEFAULT NULL COMMENT '预还款本金',
  `repayment_interest` decimal(20,2) DEFAULT NULL COMMENT '预还款利息',
  `repayment_service_fee` decimal(20,2) DEFAULT NULL COMMENT '预还服务费',
  `repaid_total` decimal(20,2) DEFAULT NULL COMMENT '实还款总额',
  `repaid_capital` decimal(20,2) DEFAULT NULL COMMENT '实还款本金',
  `repaid_interest` decimal(20,2) DEFAULT NULL COMMENT '实还利息',
  `repaid_service_fee` decimal(20,2) DEFAULT NULL COMMENT '实还服务费',
  `repaid_overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '实还逾期利息',
  `interest_free_amount` decimal(20,2) DEFAULT NULL COMMENT '免息金额',
  `repaid_time` datetime DEFAULT NULL COMMENT '实还款时间',
  `is_overdue` int(11) DEFAULT NULL COMMENT '是否逾期',
  `overdue_day` int(11) DEFAULT NULL COMMENT '逾期天数',
  `overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '逾期利息',
  `order_no` varchar(64) DEFAULT NULL COMMENT '还款/垫付订单号',
  `repayment_way` int(11) DEFAULT NULL COMMENT '还款方式：',
  `repayment_account` varchar(64) DEFAULT NULL COMMENT '还款账户',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' 现金贷还款计划表：zc_cl_cash_loan_repayment';

-- ----------------------------
-- Records of zc_cl_cash_loan_repayment
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_cs_credit_score`
-- ----------------------------
DROP TABLE IF EXISTS `zc_cs_credit_score`;
CREATE TABLE `zc_cs_credit_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `balance_score` decimal(20,2) DEFAULT NULL COMMENT '信用总评分',
  `sys_score` decimal(20,2) DEFAULT NULL COMMENT '系统评分',
  `zmxy_score` decimal(20,2) DEFAULT NULL COMMENT '芝麻信用分(未授权：-1)',
  `version` int(11) DEFAULT NULL COMMENT '版本控制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信用评分账户表：zc_cs_credit_score';

-- ----------------------------
-- Records of zc_cs_credit_score
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_cs_credit_score_log`
-- ----------------------------
DROP TABLE IF EXISTS `zc_cs_credit_score_log`;
CREATE TABLE `zc_cs_credit_score_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `score` decimal(20,2) DEFAULT NULL COMMENT '操作信用分',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `balance_score` decimal(20,2) DEFAULT NULL COMMENT '总信用分',
  `content` varchar(512) DEFAULT NULL COMMENT '日志内容',
  `payemnt_type` int(11) DEFAULT NULL COMMENT '收支方式',
  `order_no` varchar(128) DEFAULT NULL COMMENT '关联订单',
  `operator` varchar(64) DEFAULT NULL COMMENT '操作用户',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信用评分日志表：zc_cs_credit_score_log';

-- ----------------------------
-- Records of zc_cs_credit_score_log
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_jf_integral_account`
-- ----------------------------
DROP TABLE IF EXISTS `zc_jf_integral_account`;
CREATE TABLE `zc_jf_integral_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `total_integral` decimal(20,2) DEFAULT NULL COMMENT '积分总额',
  `balance_integral` decimal(20,2) DEFAULT NULL COMMENT '可用积分',
  `expense_integral` decimal(20,2) DEFAULT NULL COMMENT '消费积分',
  `freeze_integral` decimal(20,2) DEFAULT NULL COMMENT '冻结积分',
  `grade_integral` int(11) DEFAULT NULL COMMENT '积分等级',
  `version` int(11) DEFAULT NULL COMMENT '版本控制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分账户表：zc_jf_integral_account';

-- ----------------------------
-- Records of zc_jf_integral_account
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_jf_integral_log`
-- ----------------------------
DROP TABLE IF EXISTS `zc_jf_integral_log`;
CREATE TABLE `zc_jf_integral_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `integral` decimal(20,2) DEFAULT NULL COMMENT '操作积分',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `total_integral` decimal(20,2) DEFAULT NULL COMMENT '积分总额',
  `balance_integral` decimal(20,2) DEFAULT NULL COMMENT '可用积分',
  `expense_integral` decimal(20,2) DEFAULT NULL COMMENT '消费积分',
  `freeze_integral` decimal(20,2) DEFAULT NULL COMMENT '冻结积分',
  `to_user_id` int(11) DEFAULT NULL COMMENT '交易方用户',
  `content` varchar(512) DEFAULT NULL COMMENT '日志内容',
  `payemnt_type` int(11) DEFAULT NULL COMMENT '收支方式',
  `order_no` varchar(128) DEFAULT NULL COMMENT '关联订单',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分日志：zc_jf_integral_log';

-- ----------------------------
-- Records of zc_jf_integral_log
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_app_upload_record`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_app_upload_record`;
CREATE TABLE `zc_m_app_upload_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `version_id` varchar(8) DEFAULT NULL COMMENT '版本id',
  `version_no` varchar(32) DEFAULT NULL COMMENT '版本号',
  `content` varchar(128) DEFAULT NULL COMMENT '内容',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `url` varchar(128) DEFAULT NULL COMMENT '下载链接',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安卓包上传记录：zc_m_app_upload_record';

-- ----------------------------
-- Records of zc_m_app_upload_record
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_log`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_log`;
CREATE TABLE `zc_m_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `operator_id` int(11) DEFAULT NULL COMMENT '管理员id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `content` varchar(512) DEFAULT NULL COMMENT '操作内容',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(64) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志表：zc_m_log';

-- ----------------------------
-- Records of zc_m_log
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_notice_message`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_notice_message`;
CREATE TABLE `zc_m_notice_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `nid` varchar(32) DEFAULT NULL COMMENT '标识',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `send_user_id` int(11) DEFAULT NULL COMMENT '发送用户',
  `receive_user_id` int(11) DEFAULT NULL COMMENT '接收用户',
  `operator_id` int(11) DEFAULT NULL COMMENT '管理员',
  `state` int(11) DEFAULT NULL COMMENT '标题',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `content` varchar(512) DEFAULT NULL COMMENT '内容',
  `result` varchar(64) DEFAULT NULL COMMENT '发送结果描述',
  `result_code` varchar(32) DEFAULT NULL COMMENT '发送结果代码',
  `receive_addr` varchar(64) DEFAULT NULL COMMENT '接收地址',
  `code` varchar(64) DEFAULT NULL COMMENT '验证码',
  `order_no` varchar(64) DEFAULT NULL COMMENT '订单号',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知消息：zc_m_notice_message';

-- ----------------------------
-- Records of zc_m_notice_message
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_operator`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_operator`;
CREATE TABLE `zc_m_operator` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(128) DEFAULT NULL COMMENT '登录密码',
  `pay_pwd` varchar(128) DEFAULT NULL COMMENT '交易密码',
  `mobile` varchar(64) DEFAULT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `login_ip` varchar(64) DEFAULT NULL COMMENT '最后登录ip',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `add_manager` varchar(32) DEFAULT NULL COMMENT '添加用户',
  `update_manager
update_manager
update_manager` varchar(32) DEFAULT NULL COMMENT '修改用户',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表：zc_m_operator';

-- ----------------------------
-- Records of zc_m_operator
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_order_task`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_order_task`;
CREATE TABLE `zc_m_order_task` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `user_id` int(11) DEFAULT NULL COMMENT 'FK',
  `order_no` varchar(128) DEFAULT NULL COMMENT '关联订单号',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `do_result` varchar(128) DEFAULT NULL COMMENT '处理结果',
  `do_time` datetime DEFAULT NULL COMMENT '处理时间',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单管理：zc_m_order_task';

-- ----------------------------
-- Records of zc_m_order_task
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_role`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_role`;
CREATE TABLE `zc_m_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表：zc_m_role';

-- ----------------------------
-- Records of zc_m_role
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_m_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `zc_m_role_menu`;
CREATE TABLE `zc_m_role_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单表：zc_m_role_menu';

-- ----------------------------
-- Records of zc_m_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_p_apply`
-- ----------------------------
DROP TABLE IF EXISTS `zc_p_apply`;
CREATE TABLE `zc_p_apply` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(32) DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `sex` varchar(8) DEFAULT NULL COMMENT '性别',
  `province` varchar(8) DEFAULT NULL COMMENT '省',
  `city` varchar(8) DEFAULT NULL COMMENT '市',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '金额',
  `content` varchar(512) DEFAULT NULL COMMENT '描述',
  `period` varchar(16) DEFAULT NULL COMMENT '期限',
  `use` varchar(64) DEFAULT NULL COMMENT '用途',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `do_time` datetime DEFAULT NULL COMMENT '处理时间',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '处理备注',
  `add_ip` varchar(64) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目申请表：zc_p_apply';

-- ----------------------------
-- Records of zc_p_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_p_collection`
-- ----------------------------
DROP TABLE IF EXISTS `zc_p_collection`;
CREATE TABLE `zc_p_collection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '债权用户',
  `project_id` int(11) DEFAULT NULL COMMENT '投标项目',
  `tender_id` int(11) DEFAULT NULL COMMENT '投标记录',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `period` varchar(32) DEFAULT NULL COMMENT '期数',
  `repayment_time` datetime DEFAULT NULL COMMENT '预还款时间',
  `repayment_total` decimal(20,2) DEFAULT NULL COMMENT '预还款总额',
  `repayment_capital` decimal(20,2) DEFAULT NULL COMMENT '预还款本金',
  `repayment_interest` decimal(20,2) DEFAULT NULL COMMENT '预还款利息',
  `repaid_total` decimal(20,2) DEFAULT NULL COMMENT '实还款总额',
  `repaid_interest` decimal(20,2) DEFAULT NULL COMMENT '实还利息',
  `repaid_overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '实还逾期利息',
  `repaid_time` datetime DEFAULT NULL COMMENT '实还款时间',
  `repaid_increase_amount` decimal(20,2) DEFAULT NULL COMMENT '实收加息奖励',
  `is_overdue` int(11) DEFAULT NULL COMMENT '是否逾期',
  `overdue_day` int(11) DEFAULT NULL COMMENT '逾期天数',
  `overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '逾期利息',
  `interest_fee` decimal(20,2) DEFAULT NULL COMMENT '利息管理费',
  `increase_amount` decimal(20,2) DEFAULT NULL COMMENT '加息奖励',
  `order_no` varchar(64) DEFAULT NULL COMMENT '兑付订单号',
  `assignment_state` int(11) DEFAULT NULL COMMENT '转让状态',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待收记录表：zc_p_collection';

-- ----------------------------
-- Records of zc_p_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_p_project`
-- ----------------------------
DROP TABLE IF EXISTS `zc_p_project`;
CREATE TABLE `zc_p_project` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `pno` varchar(32) DEFAULT NULL COMMENT '项目编号、唯一标识',
  `name` varchar(128) DEFAULT NULL COMMENT '项目名称',
  `content` text COMMENT '项目内容',
  `user_id` int(11) DEFAULT NULL COMMENT '债务人',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '项目总额',
  `category` int(11) DEFAULT NULL COMMENT '项目类别',
  `type` int(11) DEFAULT NULL COMMENT '项目类型(借款,理财,众筹，债权)',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `invested_amount` decimal(20,2) DEFAULT NULL COMMENT '已募集总额',
  `repayment_type` int(11) DEFAULT NULL COMMENT '还款方式',
  `interest_type` int(11) DEFAULT NULL COMMENT '计息方式',
  `period_unit` int(11) DEFAULT NULL COMMENT '期限单位',
  `period` int(11) DEFAULT NULL COMMENT '期限',
  `rate` decimal(20,2) DEFAULT NULL COMMENT '利率',
  `lowest_single_invest_amount` decimal(20,2) DEFAULT NULL COMMENT '单笔最小投资金额',
  `most_invest_amount` decimal(10,0) DEFAULT NULL COMMENT '最大投资总额',
  `pwd` varchar(32) DEFAULT NULL COMMENT '定向密码',
  `raise_period` int(11) DEFAULT NULL COMMENT '募集天数',
  `review_time` datetime DEFAULT NULL COMMENT '复审时间',
  `award_type` int(11) DEFAULT NULL COMMENT '奖励类型',
  `award_value` decimal(20,2) DEFAULT NULL COMMENT '奖励值',
  `schedule` decimal(20,2) DEFAULT NULL COMMENT '进度',
  `begin_time` datetime DEFAULT NULL COMMENT '开标时间',
  `audit_time` datetime DEFAULT NULL COMMENT '初审时间',
  `is_novice` int(11) DEFAULT NULL COMMENT '是否新手标',
  `overdue_rate` decimal(20,2) DEFAULT NULL COMMENT '逾期利率',
  `increase_rate` decimal(20,2) DEFAULT NULL COMMENT '加息利率',
  `project_fee_rate` decimal(20,2) DEFAULT NULL COMMENT '项目管理费率',
  `project_fee` decimal(20,2) DEFAULT NULL COMMENT '项目管理费总额',
  `interest_fee_rate` decimal(20,2) DEFAULT NULL COMMENT '利息管理费率',
  `Interest_fee` decimal(20,2) DEFAULT NULL COMMENT '利息管理费总额',
  `img_files` varchar(512) DEFAULT NULL COMMENT '图片集',
  `is_recommend` int(11) DEFAULT NULL COMMENT '是否推荐',
  `recommend_time
recommend_time
recommend_time
recommend_time` datetime DEFAULT NULL COMMENT '推荐时间',
  `guarantee_user_id` int(11) DEFAULT NULL COMMENT '担保用户',
  `tender_count` int(11) DEFAULT NULL COMMENT '投资次数',
  `repayment_total` decimal(20,2) DEFAULT NULL COMMENT '应还总额',
  `repayment_capital` decimal(20,2) DEFAULT NULL COMMENT '应还本金',
  `repayment_interest` decimal(20,2) DEFAULT NULL COMMENT '应还利息',
  `repaid_total` decimal(20,2) DEFAULT NULL COMMENT '已还款总额',
  `repaid_capital` decimal(20,2) DEFAULT NULL COMMENT '已还款本金',
  `repaid_interest` decimal(20,2) DEFAULT NULL COMMENT '已还利息',
  `repaid_overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '已还逾期利息',
  `is_experience` int(11) DEFAULT NULL COMMENT '是否体验项目',
  `is_prepayment
is_prepayment
is_prepayment` int(11) DEFAULT NULL COMMENT '是否可提前还款',
  `is_assignment
is_assignment` int(11) DEFAULT NULL COMMENT '是否可债权转让',
  `assignment_id` int(11) DEFAULT NULL COMMENT '债权转让关联待收',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `version` int(11) DEFAULT NULL COMMENT '版本控制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表：zc_p_project';

-- ----------------------------
-- Records of zc_p_project
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_p_repayment`
-- ----------------------------
DROP TABLE IF EXISTS `zc_p_repayment`;
CREATE TABLE `zc_p_repayment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '债务用户',
  `project_id` int(11) DEFAULT NULL COMMENT '投标项目',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `period` varchar(32) DEFAULT NULL COMMENT '期数',
  `repayment_time` datetime DEFAULT NULL COMMENT '预还款时间',
  `repayment_total` decimal(20,2) DEFAULT NULL COMMENT '预还款总额',
  `repayment_capital` decimal(20,2) DEFAULT NULL COMMENT '预还款本金',
  `repayment_interest` decimal(20,2) DEFAULT NULL COMMENT '预还款利息',
  `repaid_total` decimal(20,2) DEFAULT NULL COMMENT '实还款总额',
  `repaid_capital` decimal(20,2) DEFAULT NULL COMMENT '实还款本金',
  `repaid_interest` decimal(20,2) DEFAULT NULL COMMENT '实还利息',
  `repaid_overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '实还逾期利息',
  `repaid_time` datetime DEFAULT NULL COMMENT '实还款时间',
  `increase_amount` decimal(20,2) DEFAULT NULL COMMENT '实收加息奖励',
  `is_overdue` int(11) DEFAULT NULL COMMENT '是否逾期',
  `overdue_day` int(11) DEFAULT NULL COMMENT '逾期天数',
  `overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '逾期利息',
  `order_no` varchar(64) DEFAULT NULL COMMENT '还款/垫付订单号',
  `project_fee` decimal(20,2) DEFAULT NULL COMMENT '项目管理费',
  `overdue_advance_state` int(11) DEFAULT NULL COMMENT '逾期垫付状态',
  `overdue_advance_user_id` int(11) DEFAULT NULL COMMENT '逾期垫付用户',
  `overdue_advance_total` decimal(20,2) DEFAULT NULL COMMENT '逾期垫付总额',
  `overdue_advance_interest` decimal(20,2) DEFAULT NULL COMMENT '垫付后生成利息',
  `overdue_advance_rate` decimal(20,2) DEFAULT NULL COMMENT '垫付后利率',
  `overdue_advance_repay_time` datetime DEFAULT NULL COMMENT '债务用户偿还垫付时间',
  `overdue_advance_day` int(11) DEFAULT NULL COMMENT '垫付后逾期天数',
  `overdue_advance_order_no
overdue_advance_order_no
overdue_adva` varchar(64) DEFAULT NULL COMMENT '债务用户偿还订单号',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款计划表：zc_p_repayment';

-- ----------------------------
-- Records of zc_p_repayment
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_p_tender`
-- ----------------------------
DROP TABLE IF EXISTS `zc_p_tender`;
CREATE TABLE `zc_p_tender` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '债权用户',
  `project_id` int(11) DEFAULT NULL COMMENT '投标项目',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '投资金额',
  `real_amount` decimal(20,2) DEFAULT NULL COMMENT '有效金额',
  `user_amount` decimal(20,2) DEFAULT NULL COMMENT '用户使用金额',
  `repayment_total
repayment_total
repayment_total` decimal(20,2) DEFAULT NULL COMMENT '预还总额',
  `repayment_capital` decimal(20,2) DEFAULT NULL COMMENT '预还本金',
  `repayment_interest` decimal(20,2) DEFAULT NULL COMMENT '预还利息',
  `repaid_total` decimal(20,2) DEFAULT NULL COMMENT '已还款总额',
  `repaid_capital` decimal(20,2) DEFAULT NULL COMMENT '已还款本金',
  `repaid_interest` decimal(20,2) DEFAULT NULL COMMENT '已还利息',
  `repaid_overdue_interest` decimal(20,2) DEFAULT NULL COMMENT '已还逾期利息',
  `interest_fee` decimal(20,2) DEFAULT NULL COMMENT '已支付利息管理费',
  `route` int(11) DEFAULT NULL COMMENT '投资渠道',
  `order_no` varchar(64) DEFAULT NULL COMMENT '投标订单号',
  `award_amount` decimal(20,2) DEFAULT NULL COMMENT '投资奖励',
  `increase_amount` decimal(20,2) DEFAULT NULL COMMENT '已收加息奖励',
  `protocol` varchar(64) DEFAULT NULL COMMENT '协议',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(64) DEFAULT NULL COMMENT '添加ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标记录表：zc_p_tender';

-- ----------------------------
-- Records of zc_p_tender
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_pt_interest_free_note`
-- ----------------------------
DROP TABLE IF EXISTS `zc_pt_interest_free_note`;
CREATE TABLE `zc_pt_interest_free_note` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `note_no` varchar(64) DEFAULT NULL COMMENT '券编号',
  `name` varchar(64) DEFAULT NULL COMMENT '券名称',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `day` int(11) DEFAULT NULL COMMENT '免息天数',
  `validity_type` int(11) DEFAULT NULL COMMENT '有效期   类型  天数    截止时间',
  `validity_value` varchar(32) DEFAULT NULL COMMENT '有效期值',
  `quota` int(11) DEFAULT NULL COMMENT '配额',
  `use_quota` int(11) DEFAULT NULL COMMENT '已发放数量',
  `min_amount` decimal(20,2) DEFAULT NULL COMMENT '最小借款额度',
  `max_amount` decimal(20,2) DEFAULT NULL COMMENT '最大借款额度',
  `summary` varchar(128) DEFAULT NULL COMMENT '简介',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='免息券表：zc_pt_interest_free_note';

-- ----------------------------
-- Records of zc_pt_interest_free_note
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_pt_interest_free_note_record`
-- ----------------------------
DROP TABLE IF EXISTS `zc_pt_interest_free_note_record`;
CREATE TABLE `zc_pt_interest_free_note_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `interest_free_note_id` int(11) DEFAULT NULL COMMENT '免息券id',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `operator_id` int(11) DEFAULT NULL COMMENT '发放管理员：0-系统发放',
  `use_time` datetime DEFAULT NULL COMMENT '使用时间',
  `amount` decimal(20,0) DEFAULT NULL COMMENT '免息金额',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='免息券发放记录表：zc_pt_interest_free_note_record';

-- ----------------------------
-- Records of zc_pt_interest_free_note_record
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_pt_promotion`
-- ----------------------------
DROP TABLE IF EXISTS `zc_pt_promotion`;
CREATE TABLE `zc_pt_promotion` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(128) DEFAULT NULL COMMENT '活动推广标题',
  `way` int(11) DEFAULT NULL COMMENT '推广方式登录、注册、充值、提现、抽奖、续投、现金借款、邀请',
  `content` text COMMENT '推广内容',
  `summary` varchar(512) DEFAULT NULL COMMENT '摘要',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动推广表：zc_pt_promotion';

-- ----------------------------
-- Records of zc_pt_promotion
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_pt_promotion_prize_config`
-- ----------------------------
DROP TABLE IF EXISTS `zc_pt_promotion_prize_config`;
CREATE TABLE `zc_pt_promotion_prize_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `promotion_id` int(11) DEFAULT NULL COMMENT '推广id',
  `type` int(11) DEFAULT NULL COMMENT '奖品类型',
  `prize_no` varchar(64) DEFAULT NULL COMMENT '对应编号',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动推广奖励配置：zc_pt_promotion_prize_config';

-- ----------------------------
-- Records of zc_pt_promotion_prize_config
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_pt_promotion_prize_record`
-- ----------------------------
DROP TABLE IF EXISTS `zc_pt_promotion_prize_record`;
CREATE TABLE `zc_pt_promotion_prize_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `prize_config_id` int(11) DEFAULT NULL COMMENT '推广配置id',
  `promotion_id` int(11) DEFAULT NULL COMMENT '推广id',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `value` varchar(128) DEFAULT NULL COMMENT '活动条件记录值',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `operator_id` int(11) DEFAULT NULL COMMENT '管理员',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动推广奖励记录表：zc_pt_promotion_prize_record';

-- ----------------------------
-- Records of zc_pt_promotion_prize_record
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_s_config`
-- ----------------------------
DROP TABLE IF EXISTS `zc_s_config`;
CREATE TABLE `zc_s_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `nid` varchar(64) DEFAULT NULL COMMENT '标识',
  `value` varchar(256) DEFAULT NULL COMMENT '值',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `type` int(11) DEFAULT NULL COMMENT '分类',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表：zc_s_config';

-- ----------------------------
-- Records of zc_s_config
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_s_dict`
-- ----------------------------
DROP TABLE IF EXISTS `zc_s_dict`;
CREATE TABLE `zc_s_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `nid` varchar(64) DEFAULT NULL COMMENT '标识',
  `nid_name` varchar(64) DEFAULT NULL COMMENT '标识名',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `value` varchar(256) DEFAULT NULL COMMENT '值',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表：zc_s_dict';

-- ----------------------------
-- Records of zc_s_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_s_menu`
-- ----------------------------
DROP TABLE IF EXISTS `zc_s_menu`;
CREATE TABLE `zc_s_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(64) DEFAULT NULL COMMENT '菜单名',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `href` varchar(128) DEFAULT NULL COMMENT '链接地址',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表：zc_s_menu';

-- ----------------------------
-- Records of zc_s_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_s_mintai_pay`
-- ----------------------------
DROP TABLE IF EXISTS `zc_s_mintai_pay`;
CREATE TABLE `zc_s_mintai_pay` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `type` varchar(32) DEFAULT NULL COMMENT '接口',
  `busin_code` varchar(32) DEFAULT NULL COMMENT '业务代码',
  `out_account_id` int(11) DEFAULT NULL COMMENT '资金转出/操作用户',
  `in_account_id` int(11) NOT NULL COMMENT '资金转入用户',
  `amount` decimal(20,2) DEFAULT NULL COMMENT '操作金额',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `res_code` varchar(32) DEFAULT NULL COMMENT '交易结果代码',
  `res_msg` varchar(128) DEFAULT NULL COMMENT '交易结果消息',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `project_uuid` varchar(64) DEFAULT NULL COMMENT '项目代码',
  `invest_id` int(11) DEFAULT NULL COMMENT '投标id',
  `repayment_id` int(11) DEFAULT NULL COMMENT '还款id',
  `do_time` datetime DEFAULT NULL COMMENT '处理时间',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='民泰任务：zc_s_mintai_pay';

-- ----------------------------
-- Records of zc_s_mintai_pay
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_s_template`
-- ----------------------------
DROP TABLE IF EXISTS `zc_s_template`;
CREATE TABLE `zc_s_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `nid` varchar(32) DEFAULT NULL COMMENT '标识',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `type_sub` varchar(32) DEFAULT NULL COMMENT '子类型',
  `title` varchar(512) DEFAULT NULL COMMENT '模版标题',
  `content` varchar(512) DEFAULT NULL COMMENT '模版内容',
  `route` varchar(32) DEFAULT NULL COMMENT '渠道',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模版表：zc_s_template';

-- ----------------------------
-- Records of zc_s_template
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_u_user`
-- ----------------------------
DROP TABLE IF EXISTS `zc_u_user`;
CREATE TABLE `zc_u_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(128) DEFAULT NULL COMMENT '登录密码',
  `pay_pwd` varchar(128) DEFAULT NULL COMMENT '交易密码',
  `real_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(64) DEFAULT NULL COMMENT '手机号',
  `card_no` varchar(64) DEFAULT NULL COMMENT '证件号码',
  `add_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表：zc_u_user';

-- ----------------------------
-- Records of zc_u_user
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_u_user_identify`
-- ----------------------------
DROP TABLE IF EXISTS `zc_u_user_identify`;
CREATE TABLE `zc_u_user_identify` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT 'FK',
  `real_name_state` int(11) DEFAULT NULL COMMENT '实名认证状态(OCR、活体)',
  `email_state` int(11) DEFAULT NULL COMMENT '邮箱认证状态',
  `mobile_state` int(11) DEFAULT NULL COMMENT '手机号认证状态',
  `bind_card_num` int(11) DEFAULT NULL COMMENT '绑卡数量',
  `real_name_count` int(11) DEFAULT NULL COMMENT '实名认证次数',
  `card_img_state` int(11) DEFAULT NULL COMMENT '身份证图片认证状态',
  `octopus_state` int(11) DEFAULT NULL COMMENT '数据魔盒-运营商-数据认证状态',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `login_fail_count` int(11) DEFAULT NULL COMMENT '登录失败次数',
  `e_sign_state` int(11) DEFAULT NULL COMMENT '是否创建e签宝印章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户认证表：zc_u_user_identify';

-- ----------------------------
-- Records of zc_u_user_identify
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_u_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `zc_u_user_info`;
CREATE TABLE `zc_u_user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_id` int(11) DEFAULT NULL COMMENT 'FK',
  `invite_user_id` int(11) DEFAULT NULL COMMENT '邀请用户id',
  `invite_code` varchar(32) DEFAULT NULL COMMENT '邀请码',
  `type` int(11) DEFAULT NULL COMMENT '用户类型',
  `user_nature` int(11) DEFAULT NULL COMMENT '用户类别',
  `card_type` int(11) DEFAULT NULL COMMENT '证件类型',
  `route` int(11) DEFAULT NULL COMMENT '注册渠道',
  `channel` varchar(32) DEFAULT NULL COMMENT '推广途径',
  `sex` int(11) DEFAULT '0' COMMENT '性别',
  `head_img` varchar(128) DEFAULT NULL COMMENT '头像',
  `e_sign_account_id` varchar(50) DEFAULT NULL COMMENT 'E签宝账户唯一标识',
  `e_sign_seal_data` varchar(16384) DEFAULT NULL COMMENT 'E签宝电子签章数据',
  `zmxy_open_id` varchar(500) DEFAULT NULL COMMENT '芝麻信用授权标识',
  `elec_acct` varchar(64) DEFAULT NULL COMMENT '民泰电子账号',
  `ad_identifier` varchar(100) DEFAULT NULL COMMENT '设备标识符',
  `card_fg` varchar(100) DEFAULT NULL COMMENT '身份证国徽面',
  `card_bg` varchar(100) DEFAULT NULL COMMENT '身份证头像面',
  `login_lock_remark` varchar(128) DEFAULT NULL COMMENT '锁定备注',
  `province` varchar(32) DEFAULT NULL COMMENT '省',
  `city` varchar(32) DEFAULT NULL COMMENT '市',
  `area` varchar(32) DEFAULT NULL COMMENT '区',
  `address` varchar(128) DEFAULT NULL COMMENT '居住地址',
  `company_name` varchar(128) DEFAULT NULL COMMENT '公司名称',
  `company_type` int(11) DEFAULT NULL COMMENT '公司类型',
  `company_card_no` varchar(64) DEFAULT NULL COMMENT '公司证件号(企业征信代码)',
  `company_des` varchar(512) DEFAULT NULL COMMENT '公司描述',
  `legal_name` varchar(64) DEFAULT NULL COMMENT '企业法人姓名',
  `legal_card_no` varchar(128) DEFAULT NULL COMMENT '企业法人证件号',
  `add_ip` varchar(128) DEFAULT NULL COMMENT '注册ip',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表：zc_u_user_info';

-- ----------------------------
-- Records of zc_u_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_xc_article`
-- ----------------------------
DROP TABLE IF EXISTS `zc_xc_article`;
CREATE TABLE `zc_xc_article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `site_id` int(11) DEFAULT NULL COMMENT '所属栏目',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `introduction` varchar(512) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_hot` int(11) DEFAULT NULL COMMENT '热文章',
  `clicks` int(11) DEFAULT NULL COMMENT '点击量',
  `pic_path` varchar(512) DEFAULT NULL COMMENT '图片地址',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_ip` varchar(64) DEFAULT NULL COMMENT '最后修改ip',
  `operate_user` varchar(64) DEFAULT NULL COMMENT '最后操作管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表：zc_xc_article';

-- ----------------------------
-- Records of zc_xc_article
-- ----------------------------

-- ----------------------------
-- Table structure for `zc_xc_site`
-- ----------------------------
DROP TABLE IF EXISTS `zc_xc_site`;
CREATE TABLE `zc_xc_site` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `nid` varchar(64) DEFAULT NULL COMMENT '标识',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `url` varchar(512) DEFAULT NULL COMMENT '跳转链接',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `introduction` varchar(512) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `pic_path` varchar(512) DEFAULT NULL COMMENT '图片地址',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_ip` varchar(64) DEFAULT NULL COMMENT '最后修改ip',
  `operate_user` varchar(64) DEFAULT NULL COMMENT '最后操作管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目表：zc_xc_site';

-- ----------------------------
-- Records of zc_xc_site
-- ----------------------------
