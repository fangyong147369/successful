package com.zc.sys.cashloan.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.user.entity.UserIdentify;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class CashLoanModel extends CashLoan {
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
	public static CashLoanModel instance(CashLoan cashLoan) {
		CashLoanModel cashLoanModel = new CashLoanModel();
		BeanUtils.copyProperties(cashLoan, cashLoanModel);
		return cashLoanModel;
	}

	/**
	 * model转换实体
	 */
	public CashLoan prototype() {
		CashLoan cashLoan = new CashLoan();
		BeanUtils.copyProperties(this, cashLoan);
		return cashLoan;
	}
	
	/**
	 * 贷款校验
	 */
	public void checkCashLoan() {
		UserIdentify userIdentify = this.getUser().getUserIdentify();
		if(userIdentify.getState() != 1){
			throw new BussinessException("用户状态异常");
		}
		if(userIdentify.getRealNameState() != 1){
			throw new BussinessException("请先实名认证");
		}
		if(userIdentify.getMobileState() != 1){
			throw new BussinessException("请先手机认证");
		}
		if(userIdentify.getBindCardNum() <= 0){
			throw new BussinessException("请先绑定银行卡");
		}
		if(userIdentify.getOctopusState() != 1){
			throw new BussinessException("请先认证手机号运行商信息");
		}
		
	}
	
	/**
	 * 初始化贷款
	 */
	public void initCashLoan() {
		
	}
	
	/**
	 * 放款处理
	 */
	public void doQueue() {
		
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