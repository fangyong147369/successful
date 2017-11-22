package com.zc.sys.cashloan.service;
import com.zc.sys.cashloan.model.CashLoanConfigModel;
import com.zc.sys.common.form.Result;
/**
 * 现金贷产品配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月22日
 */
public interface CashLoanConfigService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(CashLoanConfigModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(CashLoanConfigModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(CashLoanConfigModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(CashLoanConfigModel model);

}