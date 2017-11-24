package com.zc.sys.core.sys.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;

/**
 * 菜单
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月6日
 */
@Entity
@Table(name = BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_S + "_menu")
public class Menu extends LongPKEntity {
	
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 菜单名称 **/
	private String name;
	/** 父级ID **/
	private Long parentId;
	/** 链接地址 **/
	private String href;
	/** 类型 **/
	private int type;
	/** 状态0-未启用；1-启用 **/
	private int state;
	/** 排序 **/
	private int sort;
	/** 备注 **/
	private String remark;
	
	/**
	 * 构造方法
	 */
	public Menu() {
		super();
	}
	
	/**
	 * 构造方法
	 * 
	 * @param id 主键
	 */
	public Menu(Long id) {
		super();
		this.setId(id);
	}
	
	/** 获取【菜单名称】 **/
	public String getName() {
		return name;
	}
	/** 设置【菜单名称】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【父级ID】 **/
	public Long getParentId() {
		return parentId;
	}
	/** 设置【父级ID】 **/
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/** 获取【链接地址】 **/
	public String getHref() {
		return href;
	}
	/** 设置【链接地址】 **/
	public void setHref(String href) {
		this.href = href;
	}
	/** 获取【类型】 **/
	public int getType() {
		return type;
	}
	/** 设置【类型】 **/
	public void setType(int type) {
		this.type = type;
	}
	/** 获取【状态0-未启用；1-启用】 **/
	public int getState() {
		return state;
	}
	/** 设置【状态0-未启用；1-启用】 **/
	public void setState(int state) {
		this.state = state;
	}
	/** 获取【排序】 **/
	public int getSort() {
		return sort;
	}
	/** 设置【排序】 **/
	public void setSort(int sort) {
		this.sort = sort;
	}
	/** 获取【备注】 **/
	public String getRemark() {
		return remark;
	}
	/** 设置【备注】 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
