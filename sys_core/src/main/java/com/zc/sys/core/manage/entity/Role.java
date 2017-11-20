package com.zc.sys.core.manage.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;

/**
 * 角色
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月7日
 */
@Entity
@Table(name = BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_M + "_role")
public class Role extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;
	/** 角色名 **/
	private String name;
	/** 状态：0-未启用；1-启用 **/
	private Integer state;
	/** 备注 **/
	private String remark;
	/** 获取权限 **/
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<RoleMenu> roleMenus;

	/** 获取【角色名】 **/
	public String getName() {
		return name;
	}

	/** 设置【角色名】 **/
	public void setName(String name) {
		this.name = name;
	}

	/** 获取【状态：0-未启用；1-启用】 **/
	public Integer getState() {
		return state;
	}

	/** 设置【状态：0-未启用；1-启用】 **/
	public void setState(Integer state) {
		this.state = state;
	}

	/** 获取【备注】 **/
	public String getRemark() {
		return remark;
	}

	/** 设置【备注】 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}

//	/** 获取【获取权限】 **/
//	public List<RoleMenu> getRoleMenus() {
//		return roleMenus;
//	}
//
//	/** 设置【获取权限】 **/
//	public void setRoleMenus(List<RoleMenu> roleMenus) {
//		this.roleMenus = roleMenus;
//	}

	
}
