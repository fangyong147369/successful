package com.zc.sys.core.account.service;
import com.zc.sys.core.account.model.WithdrawCashModel;
import com.zc.sys.common.form.Result;
/**
 * 提现
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface WithdrawCashService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(WithdrawCashModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(WithdrawCashModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(WithdrawCashModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(WithdrawCashModel model);

}