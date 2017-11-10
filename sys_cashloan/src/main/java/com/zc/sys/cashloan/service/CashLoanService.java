package com.zc.sys.cashloan.service;
import com.zc.sys.cashloan.model.CashLoanModel;
import com.zc.sys.common.form.Result;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface CashLoanService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(CashLoanModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(CashLoanModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(CashLoanModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(CashLoanModel model);

}