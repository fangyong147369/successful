package com.zc.sys.core.account.service;
import com.zc.sys.core.account.model.AccountDeductModel;
import com.zc.sys.common.form.Result;
/**
 * 线下扣款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface AccountDeductService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(AccountDeductModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(AccountDeductModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(AccountDeductModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(AccountDeductModel model);

}