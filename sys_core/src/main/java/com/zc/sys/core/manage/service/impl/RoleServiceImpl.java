package com.zc.sys.core.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.manage.dao.RoleDao;
import com.zc.sys.core.manage.dao.RoleMenuDao;
import com.zc.sys.core.manage.entity.Role;
import com.zc.sys.core.manage.entity.RoleMenu;
import com.zc.sys.core.manage.model.RoleMenuModel;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.manage.service.RoleService;
import com.zc.sys.core.sys.dao.MenuDao;
import com.zc.sys.core.sys.entity.Menu;

/**
 * 角色
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	@Resource
	private RoleMenuDao roleMenuDao;
	@Resource
	private MenuDao menuDao;

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@Override
	public Result list(RoleModel model) {
		PageDataList<Role> pageDataList = roleDao.list(model);
		PageDataList<RoleModel> pageDataList_ = new PageDataList<RoleModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<RoleModel> list = new ArrayList<RoleModel>();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (Role role : pageDataList.getList()) {
				RoleModel model_ = RoleModel.instance(role);
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
	public Result add(RoleModel model) {
		String menuIdStr = model.getMenuIdStr();
		if (StringUtil.isBlank(menuIdStr)) {
			return Result.error("请选择角色对应的菜单！");
		}
		String[] menuIdArr = menuIdStr.split(",");
		Role role = model.prototype();
		Role r = roleDao.save(role);
		for (int i = 0; i < menuIdArr.length; i++) {
			long menuId = Long.parseLong(menuIdArr[i]);
			Menu menu = menuDao.find(menuId);
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setMenu(menu);
			roleMenu.setRole(r);
			roleMenuDao.save(roleMenu);
		}
		return Result.success().setData(role);
	}

	/**
	 * 修改
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result update(RoleModel model) {
		String menuIdStr = model.getMenuIdStr();
		if (StringUtil.isBlank(menuIdStr)) {
			return Result.error("请选择角色对应的菜单！");
		}
		String[] menuIdArr = menuIdStr.split(",");
		Role role = roleDao.find(model.getId());
		model.setUpdateParam(role);// 设置基本参数
		Role r = roleDao.update(role);// 更新

		roleMenuDao.deleteByRoleId(role.getId());// 删除原菜单
		// 保存新菜单
		for (int i = 0; i < menuIdArr.length; i++) {
			long menuId = Long.parseLong(menuIdArr[i]);
			Menu menu = menuDao.find(menuId);
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setMenu(menu);
			roleMenu.setRole(r);
			roleMenuDao.save(roleMenu);
		}
		return Result.success();
	}

	/**
	 * 获取
	 * @param model
	 * @return
	 */
	@Override
	public Result getById(RoleModel model) {
		if (model.getId() == null || model.getId().longValue() <= 0) {
			return Result.error("参数错误！");
		}
		Role role = roleDao.find(model.getId());
		List<RoleMenu> list = new ArrayList<RoleMenu>();
		for (RoleMenu menu : role.getRoleMenus()) {
			RoleMenuModel model_ = RoleMenuModel.instance(menu);
			model_.setMenuId(menu.getMenu().getId());
			list.add(model_);
		}
		//Hibernate.initialize(list);
		role.setRoleMenus(list);
		return Result.success().setData(role);
	}

}