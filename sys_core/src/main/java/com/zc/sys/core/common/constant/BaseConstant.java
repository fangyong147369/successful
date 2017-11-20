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
	/** 通用业务处理状态-已处理 **/
	public static final int BUSINESS_STATE_YES = 1;
	/** 通用业务处理状态-处理中 **/
	public static final int BUSINESS_STATE_WAIT = 2;
	/** 通用业务处理状态-处理失败 **/
	public static final int BUSINESS_STATE_FAIL = -1;
	/** Business-State=========================================================end **/
	
	
	
	
	
	
	
	
	
	
}
