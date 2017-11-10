package com.zc.sys.cashloan.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.cashloan.constant.BaseConstant;
import com.zc.sys.common.entity.LongPKEntity;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Cl + "_cash_loan_repayment")
public class CashLoanRepayment extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

}