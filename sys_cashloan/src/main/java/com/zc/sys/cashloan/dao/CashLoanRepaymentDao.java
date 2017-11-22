package com.zc.sys.cashloan.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface CashLoanRepaymentDao extends BaseDao<CashLoanRepayment> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<CashLoanRepayment> list(CashLoanRepaymentModel model);
	
	/**
	 * 当前是否为最近还款
	 * @param period
	 * @param cashLoanId
	 * @return
	 */
	boolean isCurrentRepayment(int period,long cashLoanId);
	
}