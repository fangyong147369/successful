package com.zc.sys.cashloan.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.model.CashLoanModel;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface CashLoanDao extends BaseDao<CashLoan> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<CashLoan> list(CashLoanModel model);
	
}