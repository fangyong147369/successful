package com.zc.sys.core.manage.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.manage.entity.RoleMenu;
import com.zc.sys.core.manage.model.RoleMenuModel;

/**
 * 角色-菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface RoleMenuDao extends BaseDao<RoleMenu> {

	/**
	 * 删除角色菜单关联表信息（物理删除）
	 * 
	 * @param roleId 角色ID
	 */
	void deleteByRoleId(long roleId);

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<RoleMenu> list(RoleMenuModel model);
}