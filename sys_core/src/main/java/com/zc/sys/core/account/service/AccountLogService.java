package com.zc.sys.core.account.service;
import com.zc.sys.core.account.model.AccountLogModel;
import com.zc.sys.common.form.Result;
/**
 * 资金日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface AccountLogService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(AccountLogModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(AccountLogModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(AccountLogModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(AccountLogModel model);

}