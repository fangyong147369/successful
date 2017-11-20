package com.zc.sys.cashloan.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zc.sys.cashloan.constant.BaseCashLoanConstant;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.user.entity.User;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseCashLoanConstant.DB_PREFIX + BaseCashLoanConstant.DB_MODEL_Cl + "_cash_loan_repayment")
public class CashLoanRepayment extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 债务人 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	/** 贷款 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cash_loan_id")
	private CashLoan cashLoan;
	/** 状态 **/
	private Integer state;
	/** 期限 **/
	private Integer period;
	/** 预还款时间 **/
	private Date repaymentTime;
	/** 预还总额 **/
	private Double repaymentTotal;
	/** 预还本金 **/
	private Double repaymentCapital;
	/** 预还利息 **/
	private Double repaymentInterest;
	/** 预还服务费 **/
	private Double repyamentServiceFee;
	/** 实还款总额 **/
	private Double repaidTotal;
	/** 实还款本金 **/
	private Double repaidCapital;
	/** 实还款利息 **/
	private Double repaidInterest;
	/** 实还逾期利息 **/
	private Double repaidOverdueInterest;
	/** 实还服务费 **/
	private Double repaidServiceFee;
	/** 免息总金额 **/
	private Double interestFreeAmount;
	/** 实还款时间 **/
	private Date repaidTime;
	/** 是否逾期 **/
	private Integer isOverdue;
	/** 逾期天数 **/
	private Integer overdueDay;
	/** 逾期利息 **/
	private Double overdueInterest;
	/** 还款/垫付订单号 **/
	private String orderNo;
	/** 还款方式：余额还款/代扣还款 **/
	private Integer repaymentWay;
	/** 还款账户 **/
	private String repaymentAccount;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 获取【债务人】 **/
	public User getUser() {
		return user;
	}
	/** 设置【债务人】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【贷款】 **/
	public CashLoan getCashLoan() {
		return cashLoan;
	}
	/** 设置【贷款】 **/
	public void setCashLoan(CashLoan cashLoan) {
		this.cashLoan = cashLoan;
	}
	/** 获取【状态】 **/
	public Integer getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(Integer state) {
		this.state = state;
	}
	/** 获取【期限】 **/
	public Integer getPeriod() {
		return period;
	}
	/** 设置【期限】 **/
	public void setPeriod(Integer period) {
		this.period = period;
	}
	/** 获取【预还款时间】 **/
	public Date getRepaymentTime() {
		return repaymentTime;
	}
	/** 设置【预还款时间】 **/
	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	/** 获取【预还总额】 **/
	public Double getRepaymentTotal() {
		return repaymentTotal;
	}
	/** 设置【预还总额】 **/
	public void setRepaymentTotal(Double repaymentTotal) {
		this.repaymentTotal = repaymentTotal;
	}
	/** 获取【预还本金】 **/
	public Double getRepaymentCapital() {
		return repaymentCapital;
	}
	/** 设置【预还本金】 **/
	public void setRepaymentCapital(Double repaymentCapital) {
		this.repaymentCapital = repaymentCapital;
	}
	/** 获取【预还利息】 **/
	public Double getRepaymentInterest() {
		return repaymentInterest;
	}
	/** 设置【预还利息】 **/
	public void setRepaymentInterest(Double repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}
	/** 获取【预还服务费】 **/
	public Double getRepyamentServiceFee() {
		return repyamentServiceFee;
	}
	/** 设置【预还服务费】 **/
	public void setRepyamentServiceFee(Double repyamentServiceFee) {
		this.repyamentServiceFee = repyamentServiceFee;
	}
	/** 获取【实还款总额】 **/
	public Double getRepaidTotal() {
		return repaidTotal;
	}
	/** 设置【实还款总额】 **/
	public void setRepaidTotal(Double repaidTotal) {
		this.repaidTotal = repaidTotal;
	}
	/** 获取【实还款本金】 **/
	public Double getRepaidCapital() {
		return repaidCapital;
	}
	/** 设置【实还款本金】 **/
	public void setRepaidCapital(Double repaidCapital) {
		this.repaidCapital = repaidCapital;
	}
	/** 获取【实还款利息】 **/
	public Double getRepaidInterest() {
		return repaidInterest;
	}
	/** 设置【实还款利息】 **/
	public void setRepaidInterest(Double repaidInterest) {
		this.repaidInterest = repaidInterest;
	}
	/** 获取【实还逾期利息】 **/
	public Double getRepaidOverdueInterest() {
		return repaidOverdueInterest;
	}
	/** 设置【实还逾期利息】 **/
	public void setRepaidOverdueInterest(Double repaidOverdueInterest) {
		this.repaidOverdueInterest = repaidOverdueInterest;
	}
	/** 获取【实还服务费】 **/
	public Double getRepaidServiceFee() {
		return repaidServiceFee;
	}
	/** 设置【实还服务费】 **/
	public void setRepaidServiceFee(Double repaidServiceFee) {
		this.repaidServiceFee = repaidServiceFee;
	}
	/** 获取【免息总金额】 **/
	public Double getInterestFreeAmount() {
		return interestFreeAmount;
	}
	/** 设置【免息总金额】 **/
	public void setInterestFreeAmount(Double interestFreeAmount) {
		this.interestFreeAmount = interestFreeAmount;
	}
	/** 获取【实还款时间】 **/
	public Date getRepaidTime() {
		return repaidTime;
	}
	/** 设置【实还款时间】 **/
	public void setRepaidTime(Date repaidTime) {
		this.repaidTime = repaidTime;
	}
	/** 获取【是否逾期】 **/
	public Integer getIsOverdue() {
		return isOverdue;
	}
	/** 设置【是否逾期】 **/
	public void setIsOverdue(Integer isOverdue) {
		this.isOverdue = isOverdue;
	}
	/** 获取【逾期天数】 **/
	public Integer getOverdueDay() {
		return overdueDay;
	}
	/** 设置【逾期天数】 **/
	public void setOverdueDay(Integer overdueDay) {
		this.overdueDay = overdueDay;
	}
	/** 获取【逾期利息】 **/
	public Double getOverdueInterest() {
		return overdueInterest;
	}
	/** 设置【逾期利息】 **/
	public void setOverdueInterest(Double overdueInterest) {
		this.overdueInterest = overdueInterest;
	}
	/** 获取【还款垫付订单号】 **/
	public String getOrderNo() {
		return orderNo;
	}
	/** 设置【还款垫付订单号】 **/
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/** 获取【还款方式：余额还款代扣还款】 **/
	public Integer getRepaymentWay() {
		return repaymentWay;
	}
	/** 设置【还款方式：余额还款代扣还款】 **/
	public void setRepaymentWay(Integer repaymentWay) {
		this.repaymentWay = repaymentWay;
	}
	/** 获取【还款账户】 **/
	public String getRepaymentAccount() {
		return repaymentAccount;
	}
	/** 设置【还款账户】 **/
	public void setRepaymentAccount(String repaymentAccount) {
		this.repaymentAccount = repaymentAccount;
	}
	/** 获取【备注】 **/
	public String getRemark() {
		return remark;
	}
	/** 设置【备注】 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** 获取【添加时间】 **/
	public Date getAddTime() {
		return addTime;
	}
	/** 设置【添加时间】 **/
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}