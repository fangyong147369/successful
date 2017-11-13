package com.zc.sys.core.manage.dao.impl;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.core.manage.entity.RoleMenu;
import com.zc.sys.core.manage.dao.RoleMenuDao;
/**
 * 角色-菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class RoleMenuDaoImpl extends BaseDaoImpl<RoleMenu> implements RoleMenuDao {

	/**
	 * 删除角色菜单关联表信息（物理删除）
	 * 
	 * @param roleId 角色ID
	 */
	@Override
	public void deleteByRoleId(long roleId) {
		Query query = em.createNativeQuery("delete from RoleMenu where role.id=?1").setParameter(1, roleId);
		query.executeUpdate();
	}

}