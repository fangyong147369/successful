package com.zc.sys.cashloan.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class CashLoanRepaymentModel extends CashLoanRepayment {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	/** 订单信息 **/
	private OrderTask orderTask;

	/**
	 * 实体转换model
	 */
	public static CashLoanRepaymentModel instance(CashLoanRepayment cashLoanRepayment) {
		CashLoanRepaymentModel cashLoanRepaymentModel = new CashLoanRepaymentModel();
		BeanUtils.copyProperties(cashLoanRepayment, cashLoanRepaymentModel);
		return cashLoanRepaymentModel;
	}

	/**
	 * model转换实体
	 */
	public CashLoanRepayment prototype() {
		CashLoanRepayment cashLoanRepayment = new CashLoanRepayment();
		BeanUtils.copyProperties(this, cashLoanRepayment);
		return cashLoanRepayment;
	}
	
	/**
	 * 现金贷还款处理
	 */
	public void doQueue() {
		
	}
	

	/**
	 * 校验还款信息
	 * @param cashLoanRepaymet
	 */
	public void checkRepayment(CashLoanRepayment cashLoanRepaymet) {
		if(this.getId() == null || StringUtil.isBlank(cashLoanRepaymet.getPeriod())){
			throw new BusinessException("参数错误");
		}
		
	}

	/**
	 * 初始化还款信息
	 * @param cashLoanRepaymet
	 */
	public void initRepayment(CashLoanRepayment cashLoanRepaymet) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 初始化信息
	 * @param cashLoanRepayment
	 */
	public void initDetail(CashLoanRepayment cashLoanRepayment) {
		// TODO Auto-generated method stub
		
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

	/** 获取【订单信息】 **/
	public OrderTask getOrderTask() {
		return orderTask;
	}

	/** 设置【订单信息】 **/
	public void setOrderTask(OrderTask orderTask) {
		this.orderTask = orderTask;
	}
	
}