package com.zc.sys.cashloan.constant;

/**
 * 常量
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月6日
 */
public final class BaseCashLoanConstant {
	
	/** DB=========================================================start **/
	/** 表前缀  **/
	public static final String DB_PREFIX = "zc_";
	/** 表模块-cl-现金贷  **/
	public static final String DB_MODEL_Cl = "cl";
	/** DB=========================================================end **/
	
	/** CashLoan-State=========================================================start **/
	/** 现金贷-状态-审核中 **/
	public static final int CASHLOAN_STATE_AUDITING = 0;
	/** 现金贷-状态-审核失败 **/
	public static final int CASHLOAN_STATE_AUDIT_FAIL = -1;
	/** 现金贷-状态-放款中 **/
	public static final int CASHLOAN_STATE_LOANING = 5;
	/** 现金贷-状态-放款失败 **/
	public static final int CASHLOAN_STATE_LOAN_FAIL = -5;
	/** 现金贷-状态-还款中 **/
	public static final int CASHLOAN_STATE_REPAYMENTING = 10;
	/** 现金贷-状态-逾期中 **/
	public static final int CASHLOAN_STATE_OVERDUE = 15;
	/** 现金贷-状态-还款完成 **/
	public static final int CASHLOAN_STATE_REPAID = 20;
	/** 现金贷-状态-逾期-还款完成 **/
	public static final int CASHLOAN_STATE_OVERDUE_REPAID = 21;
	/** CashLoan-State=========================================================end **/
	
	
	
	
	
	
	
	
	
	
}
