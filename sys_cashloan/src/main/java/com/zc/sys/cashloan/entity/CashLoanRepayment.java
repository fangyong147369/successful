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
	private int state;
	/** 期限 **/
	private int period;
	/** 预还款时间 **/
	private Date repaymentTime;
	/** 预还总额 **/
	private double repaymentTotal;
	/** 预还本金 **/
	private double repaymentCapital;
	/** 预还利息 **/
	private double repaymentInterest;
	/** 预还服务费 **/
	private double repaymentServiceFee;
	/** 实还款总额 **/
	private double repaidTotal;
	/** 实还款本金 **/
	private double repaidCapital;
	/** 实还款利息 **/
	private double repaidInterest;
	/** 实还逾期利息 **/
	private double repaidOverdueInterest;
	/** 实还服务费 **/
	private double repaidServiceFee;
	/** 免息总金额 **/
	private double interestFreeAmount;
	/** 实还款时间 **/
	private Date repaidTime;
	/** 是否逾期 **/
	private int isOverdue;
	/** 逾期天数 **/
	private int overdueDay;
	/** 逾期利息 **/
	private double overdueInterest;
	/** 还款/垫付订单号 **/
	private String orderNo;
	/** 还款方式：余额还款/代扣还款 **/
	private int repaymentWay;
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
	public int getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(int state) {
		this.state = state;
	}
	/** 获取【期限】 **/
	public int getPeriod() {
		return period;
	}
	/** 设置【期限】 **/
	public void setPeriod(int period) {
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
	public double getRepaymentTotal() {
		return repaymentTotal;
	}
	/** 设置【预还总额】 **/
	public void setRepaymentTotal(double repaymentTotal) {
		this.repaymentTotal = repaymentTotal;
	}
	/** 获取【预还本金】 **/
	public double getRepaymentCapital() {
		return repaymentCapital;
	}
	/** 设置【预还本金】 **/
	public void setRepaymentCapital(double repaymentCapital) {
		this.repaymentCapital = repaymentCapital;
	}
	/** 获取【预还利息】 **/
	public double getRepaymentInterest() {
		return repaymentInterest;
	}
	/** 设置【预还利息】 **/
	public void setRepaymentInterest(double repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}
	/** 获取【预还服务费】 **/
	public double getRepaymentServiceFee() {
		return repaymentServiceFee;
	}
	/** 设置【预还服务费】 **/
	public void setRepaymentServiceFee(double repaymentServiceFee) {
		this.repaymentServiceFee = repaymentServiceFee;
	}
	/** 获取【实还款总额】 **/
	public double getRepaidTotal() {
		return repaidTotal;
	}
	/** 设置【实还款总额】 **/
	public void setRepaidTotal(double repaidTotal) {
		this.repaidTotal = repaidTotal;
	}
	/** 获取【实还款本金】 **/
	public double getRepaidCapital() {
		return repaidCapital;
	}
	/** 设置【实还款本金】 **/
	public void setRepaidCapital(double repaidCapital) {
		this.repaidCapital = repaidCapital;
	}
	/** 获取【实还款利息】 **/
	public double getRepaidInterest() {
		return repaidInterest;
	}
	/** 设置【实还款利息】 **/
	public void setRepaidInterest(double repaidInterest) {
		this.repaidInterest = repaidInterest;
	}
	/** 获取【实还逾期利息】 **/
	public double getRepaidOverdueInterest() {
		return repaidOverdueInterest;
	}
	/** 设置【实还逾期利息】 **/
	public void setRepaidOverdueInterest(double repaidOverdueInterest) {
		this.repaidOverdueInterest = repaidOverdueInterest;
	}
	/** 获取【实还服务费】 **/
	public double getRepaidServiceFee() {
		return repaidServiceFee;
	}
	/** 设置【实还服务费】 **/
	public void setRepaidServiceFee(double repaidServiceFee) {
		this.repaidServiceFee = repaidServiceFee;
	}
	/** 获取【免息总金额】 **/
	public double getInterestFreeAmount() {
		return interestFreeAmount;
	}
	/** 设置【免息总金额】 **/
	public void setInterestFreeAmount(double interestFreeAmount) {
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
	public int getIsOverdue() {
		return isOverdue;
	}
	/** 设置【是否逾期】 **/
	public void setIsOverdue(int isOverdue) {
		this.isOverdue = isOverdue;
	}
	/** 获取【逾期天数】 **/
	public int getOverdueDay() {
		return overdueDay;
	}
	/** 设置【逾期天数】 **/
	public void setOverdueDay(int overdueDay) {
		this.overdueDay = overdueDay;
	}
	/** 获取【逾期利息】 **/
	public double getOverdueInterest() {
		return overdueInterest;
	}
	/** 设置【逾期利息】 **/
	public void setOverdueInterest(double overdueInterest) {
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
	public int getRepaymentWay() {
		return repaymentWay;
	}
	/** 设置【还款方式：余额还款代扣还款】 **/
	public void setRepaymentWay(int repaymentWay) {
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