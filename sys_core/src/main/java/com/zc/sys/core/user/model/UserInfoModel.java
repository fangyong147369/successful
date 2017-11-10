package com.zc.sys.core.user.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.user.entity.UserInfo;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class UserInfoModel extends UserInfo {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;

	/**
	 * 实体转换model
	 */
	public static UserInfoModel instance(UserInfo userInfo) {
		UserInfoModel userInfoModel = new UserInfoModel();
		BeanUtils.copyProperties(userInfo, userInfoModel);
		return userInfoModel;
	}

	/**
	 * model转换实体
	 */
	public UserInfo prototype() {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(this, userInfo);
		return userInfo;
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

}