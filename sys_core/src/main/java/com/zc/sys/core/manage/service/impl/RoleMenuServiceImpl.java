package com.zc.sys.core.manage.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.RoleMenuDao;
import com.zc.sys.core.manage.model.RoleMenuModel;
import com.zc.sys.core.manage.service.RoleMenuService;
/**
 * 角色-菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Resource
	private RoleMenuDao roleMenuDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(RoleMenuModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(RoleMenuModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(RoleMenuModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(RoleMenuModel model){

		return null;
	}

}