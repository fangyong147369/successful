package com.zc.sys.core.common.constant;

/**
 * 常量
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月6日
 */
public final class BaseConstant {
	
	/** DB=========================================================start **/
	/** 表前缀  **/
	public static final String DB_PREFIX = "zc_";
	/** 表模块-s-系统配置  **/
	public static final String DB_MODEL_S = "s";
	/** 表模块-m-核心及管理  **/
	public static final String DB_MODEL_M = "m";
	/** 表模块-u-用户  **/
	public static final String DB_MODEL_U = "u";
	/** 表模块-acc-资金账户  **/
	public static final String DB_MODEL_Acc = "acc";
	/** 表模块-b-业务  **/
	public static final String DB_MODEL_B = "b";
	/** 表模块-xc-宣传 **/
	public static final String DB_MODEL_Xc = "xc";
	/** 表模块-jf-积分 **/
	public static final String DB_MODEL_Jf = "jf";
	/** 表模块-cs-信用分 **/
	public static final String DB_MODEL_Cs = "cs";
	/** DB=========================================================end **/
	
	/** Identify-State=========================================================start **/
	/** 通用认证状态-未认证 **/
	public static final int IDENTIFY_STATE_NO = 0;
	/** 通用认证状态-已认证 **/
	public static final int IDENTIFY_STATE_YES = 1;
	/** 通用认证状态-认证处理中 **/
	public static final int IDENTIFY_STATE_WAIT = 2;
	/** 通用认证状态-认证失败 **/
	public static final int IDENTIFY_STATE_FAIL = -1;
	/** Identify-State=========================================================end **/
	
	/** Business-State=========================================================start **/
	/** 通用业务处理状态-未处理 **/
	public static final int BUSINESS_STATE_NO = 0;
	/** 通用业务处理状态-已处理/已认证 **/
	public static final int BUSINESS_STATE_YES = 1;
	/** 通用业务处理状态-处理中 **/
	public static final int BUSINESS_STATE_WAIT = 2;
	/** 通用业务处理状态-处理失败 **/
	public static final int BUSINESS_STATE_FAIL = -1;
	/** Business-State=========================================================end **/
	
	/** Info-State=========================================================start **/
	/** 通用信息启用状态-未启用 **/
	public static final int INFO_STATE_NO = 0;
	/** 通用信息启用状态-已启用 **/
	public static final int INFO_STATE_YES = 1;
	/** Info-State=========================================================end **/
	
	/** PeriodUnit=========================================================start **/
	/** 借款期限单位-月 **/
	public static final int PERIODUNIT_MONTH = 0;
	/** 借款期限单位-天 **/
	public static final int PERIODUNIT_DAY = 1;
	/** PeriodUnit=========================================================end **/
	
	/** Repayment-Way=========================================================start **/
	/** 现金贷-还款方式-一次性还本付息 **/
	public static final int REPAYMENT_WAY_ONETIME = 1;
	
	
	/** Repayment-Way=========================================================end **/
	
	/** update-Way=========================================================start **/
	/** 修改密码方式-设置 **/
	public static final int UPDATE_PWD_WAY_SET = 1;
	/** 修改密码方式-正常 **/
	public static final int UPDATE_PWD_WAY_UPDATE = 2;
	/** 修改密码方式-忘记 **/
	public static final int UPDATE_PWD_WAY_FORGET = 3;
	/** update-Way=========================================================end **/
	
	/** handle-SMS-type=========================================================start **/
	/** 主动短信类型-注册 **/
	public static final int HANDLE_SMS_TYPE_REG = 1;
	/** 主动短信类型-登录密码 **/
	public static final int HANDLE_SMS_TYPE_PWD = 2;
	/** 主动短信类型-交易密码 **/
	public static final int HANDLE_SMS_TYPE_PAYPWD = 3;
	/** handle-SMS-type=========================================================end **/
}
