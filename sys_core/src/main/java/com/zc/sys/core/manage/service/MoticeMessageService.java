package com.zc.sys.core.manage.service;
import com.zc.sys.core.manage.model.MoticeMessageModel;
import com.zc.sys.common.form.Result;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface MoticeMessageService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(MoticeMessageModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(MoticeMessageModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(MoticeMessageModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(MoticeMessageModel model);

}