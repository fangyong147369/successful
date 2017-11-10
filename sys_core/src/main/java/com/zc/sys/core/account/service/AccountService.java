package com.zc.sys.core.account.service;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.common.form.Result;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface AccountService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(AccountModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(AccountModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(AccountModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(AccountModel model);

}