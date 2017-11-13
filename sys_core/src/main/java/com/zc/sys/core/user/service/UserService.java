package com.zc.sys.core.user.service;
import com.zc.sys.core.user.model.UserModel;
import com.zc.sys.common.form.Result;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface UserService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(UserModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(UserModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(UserModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(UserModel model);

	/**
	 * 注册
	 * @param model
	 * @return
	 */
	public Object reg(UserModel model);
	
	/**
	 * 登录
	 * @param model
	 * @return
	 */
	public Object login(UserModel model);
	
}