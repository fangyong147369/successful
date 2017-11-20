package com.zc.sys.core.manage.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.manage.entity.Operator;
/**
 * 管理员
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class OperatorModel extends Operator {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	private RoleModel roleModel;

	/**
	 * 实体转换model
	 */
	public static OperatorModel instance(Operator operator) {
		OperatorModel operatorModel = new OperatorModel();
		BeanUtils.copyProperties(operator, operatorModel);
		return operatorModel;
	}

	/**
	 * model转换实体
	 */
	public Operator prototype() {
		Operator operator = new Operator();
		BeanUtils.copyProperties(this, operator);
		return operator;
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

	/** 获取【roleMoel】 **/
	public RoleModel getRoleMoel() {
		return roleModel;
	}

	/** 设置【roleMoel】 **/
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

}