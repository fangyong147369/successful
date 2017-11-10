package com.zc.sys.core.account.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.account.entity.WithdrawCash;
/**
 * 提现
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class WithdrawCashModel extends WithdrawCash {
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
	public static WithdrawCashModel instance(WithdrawCash withdrawCash) {
		WithdrawCashModel withdrawCashModel = new WithdrawCashModel();
		BeanUtils.copyProperties(withdrawCash, withdrawCashModel);
		return withdrawCashModel;
	}

	/**
	 * model转换实体
	 */
	public WithdrawCash prototype() {
		WithdrawCash withdrawCash = new WithdrawCash();
		BeanUtils.copyProperties(this, withdrawCash);
		return withdrawCash;
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