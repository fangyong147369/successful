package com.zc.sys.core.manage.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.manage.entity.RoleMenu;
/**
 * 角色-菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class RoleMenuModel extends RoleMenu {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

//	/** 当前页码 **/
//	private int pageNo;
//	/** 每页数据条数 **/
//	private int pageSize = Page.ROWS;
//	/** 条件查询 **/
//	private String searchName;

	private Long menuId;

	private Long parentId;

	private String menuName;

	private String menuUrl;

	/**
	 * 实体转换model
	 */
	public static RoleMenuModel instance(RoleMenu roleMenu) {
		RoleMenuModel roleMenuModel = new RoleMenuModel();
		BeanUtils.copyProperties(roleMenu, roleMenuModel);
		return roleMenuModel;
	}

	/**
	 * model转换实体
	 */
	public RoleMenu prototype() {
		RoleMenu roleMenu = new RoleMenu();
		BeanUtils.copyProperties(this, roleMenu);
		return roleMenu;
	}

	public Long getMenuId(){
		return menuId;
	}

	public void setMenuId(Long menuId){
		this.menuId=menuId;
	}

	public Long getParentId(){
		return parentId;
	}

	public void setParentId(Long parentId){
		this.parentId=parentId;
	}

	public String getMenuName(){
		return menuName;
	}

	public void setMenuName(String menuName){
		this.menuName=menuName;
	}

	public String getMenuUrl(){
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl){
		this.menuUrl=menuUrl;
	}

//	/** 获取【当前页码】 **/
//	public int getPageNo() {
//		return pageNo;
//	}
//
//	/** 设置【当前页码】 **/
//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//	}
//
//	/** 获取【每页数据条数】 **/
//	public int getPageSize() {
//		return pageSize;
//	}
//
//	/** 设置【每页数据条数】 **/
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//
//	/** 获取【条件查询】 **/
//	public String getSearchName() {
//		return searchName;
//	}
//
//	/** 设置【条件查询】 **/
//	public void setSearchName(String searchName) {
//		this.searchName = searchName;
//	}

}