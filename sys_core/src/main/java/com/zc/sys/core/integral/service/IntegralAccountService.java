package com.zc.sys.core.integral.service;
import com.zc.sys.core.integral.model.IntegralAccountModel;
import com.zc.sys.common.form.Result;
/**
 * 积分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface IntegralAccountService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(IntegralAccountModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(IntegralAccountModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(IntegralAccountModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(IntegralAccountModel model);

}