package com.zc.sys.core.manage.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.manage.entity.Role;
import com.zc.sys.core.manage.model.RoleModel;
/**
 * 角色
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface RoleDao extends BaseDao<Role> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<Role> list(RoleModel model);
	
}