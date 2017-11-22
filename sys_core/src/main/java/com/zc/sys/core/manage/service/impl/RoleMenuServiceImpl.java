package com.zc.sys.core.manage.service.impl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.manage.entity.RoleMenu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.RoleMenuDao;
import com.zc.sys.core.manage.model.RoleMenuModel;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.manage.service.RoleMenuService;
import com.zc.sys.core.sys.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

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
		PageDataList<RoleMenu> pageDataList = roleMenuDao.list(model);
		PageDataList<RoleMenuModel> pageDataList_ = new PageDataList<RoleMenuModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<RoleMenuModel> list = new ArrayList<RoleMenuModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (RoleMenu menu : pageDataList.getList()) {
				RoleMenuModel model_ = RoleMenuModel.instance(menu);
//				model_.setMenuId(menu.getMenu().getId());
//				model_.setParentId(menu.getMenu().getParentId());
//				model_.setMenuName(menu.getMenu().getName());
//				model_.setMenuUrl(menu.getMenu().getHref());
				model_.setMenuModel(MenuModel.instance(menu.getMenu()));
//				model.setRoleModel(RoleModel.instance(menu.getRole()));
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(RoleMenuModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
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