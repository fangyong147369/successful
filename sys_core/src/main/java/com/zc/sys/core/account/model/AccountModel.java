package com.zc.sys.core.account.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.account.entity.Account;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class AccountModel extends Account {
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
	public static AccountModel instance(Account account) {
		AccountModel accountModel = new AccountModel();
		BeanUtils.copyProperties(account, accountModel);
		return accountModel;
	}

	/**
	 * model转换实体
	 */
	public Account prototype() {
		Account account = new Account();
		BeanUtils.copyProperties(this, account);
		return account;
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