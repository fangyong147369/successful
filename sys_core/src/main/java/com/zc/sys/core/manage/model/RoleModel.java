package com.zc.sys.core.manage.model;
import org.springframework.beans.BeanUtils;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.manage.entity.Role;
/**
 * 角色
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class RoleModel extends Role {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	/** 角色菜单 **/
	private String menuIdStr;

	/**
	 * 实体转换model
	 */
	public static RoleModel instance(Role role) {
		RoleModel roleModel = new RoleModel();
		BeanUtils.copyProperties(role, roleModel);
		return roleModel;
	}

	/**
	 * model转换实体
	 */
	public Role prototype() {
		Role role = new Role();
		BeanUtils.copyProperties(this, role);
		return role;
	}
	
	/**
	 * 设置管理员角色修改基本参数
	 * @param role
	 */
	public void setUpdateParam(Role role) {
		role.setName(this.getName());
		role.setRemark(this.getRemark());
		role.setState(role.getState());
	}

	/** 获取【当前页码】 **/
	public int getPageNo() {
		return pageNo;
	}

	/** 设置【当前页码】 **/
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/** 获取【每页数据条数】 **/
	public int getPageSize() {
		return pageSize;
	}

	/** 设置【每页数据条数】 **/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 获取【条件查询】 **/
	public String getSearchName() {
		return searchName;
	}

	/** 设置【条件查询】 **/
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/** 获取【角色菜单】 **/
	public String getMenuIdStr() {
		return menuIdStr;
	}

	/** 设置【角色菜单】 **/
	public void setMenuIdStr(String menuIdStr) {
		this.menuIdStr = menuIdStr;
	}
}