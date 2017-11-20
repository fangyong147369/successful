package com.zc.sys.core.manage.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.sys.entity.Menu;

/**
 * 角色菜单
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月7日
 */
@Entity
@Table(name = BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_M + "_role_menu")
public class RoleMenu extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	/**
	 * 菜单主键
	 */
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	/** 获取【role】 */
	public Role getRole() {
		return role;
	}

	/** 设置【role】 */
	public void setRole(Role role) {
		this.role = role;
	}

	/** 获取【菜单主键】 */
	public Menu getMenu() {
		return menu;
	}

	/** 设置【菜单主键】 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
