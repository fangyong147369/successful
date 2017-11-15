package com.zc.sys.cashloan.service;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
import com.zc.sys.common.form.Result;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface CashLoanRepaymentService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(CashLoanRepaymentModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(CashLoanRepaymentModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(CashLoanRepaymentModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(CashLoanRepaymentModel model);


	/**
 	 * 现金贷款还款请求
 	 * @param model
 	 * @return
 	 */
	public Result cashLoanRepaymentRequest(CashLoanRepaymentModel model);
	
	/**
 	 * 现金贷款处理处理
 	 * @param model
 	 * @return
 	 */
	public Result cashLoanRepaymentDeal(CashLoanRepaymentModel model);
}