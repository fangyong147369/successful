package com.zc.sys.core.user.service;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.common.form.Result;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface UserInfoService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(UserInfoModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(UserInfoModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(UserInfoModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(UserInfoModel model);

}