package com.zc.sys.core.credit.service;
import com.zc.sys.core.credit.model.CreditScoreModel;
import com.zc.sys.common.form.Result;
/**
 * 信用分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface CreditScoreService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(CreditScoreModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(CreditScoreModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(CreditScoreModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(CreditScoreModel model);

}