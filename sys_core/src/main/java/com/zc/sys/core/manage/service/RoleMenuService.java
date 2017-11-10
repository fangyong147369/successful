package com.zc.sys.core.manage.service;
import com.zc.sys.core.manage.model.RoleMenuModel;
import com.zc.sys.common.form.Result;
/**
 * 角色-菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface RoleMenuService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(RoleMenuModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(RoleMenuModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(RoleMenuModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(RoleMenuModel model);

}