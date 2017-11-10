package com.zc.sys.core.integral.service;
import com.zc.sys.core.integral.model.IntegralLogModel;
import com.zc.sys.common.form.Result;
/**
 * 积分日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface IntegralLogService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(IntegralLogModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(IntegralLogModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(IntegralLogModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(IntegralLogModel model);

}