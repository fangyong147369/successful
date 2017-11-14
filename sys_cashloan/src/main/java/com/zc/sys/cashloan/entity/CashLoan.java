package com.zc.sys.cashloan.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.zc.sys.cashloan.constant.BaseConstant;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.user.entity.User;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Cl + "_cash_loan")
public class CashLoan extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 借款编号 **/
	private String cno;
	/** 产品名称 **/
	private String name;
	/** 债务人 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	/** 产品类型 **/
	private Integer type;
	/** 状态 **/
	private Integer state;
	/** 借款本金总额 **/
	private Double total;
	/** 还款方式 **/
	private Integer repaymentType;
	/** 期限单位 **/
	private Integer periodUnit;
	/** 期限 **/
	private Integer period;
	/** 天利率 **/
	private Double rate;
	/** 逾期天利率 **/
	private Double overdueRate;
	/** 服务费收取类型 **/
	private Integer serviceFeeType;
	/** 服务费收取值 **/
	private Double serviceFeeValue;
	/** 应还总额 **/
	private Double repaymentTotal;
	/** 应还本金 **/
	private Double repaymentCapital;
	/** 应还利息 **/
	private Double repaymentInterest;
	/** 应还服务费 **/
	private Double repyamentServiceFee;
	/** 已还款总额 **/
	private Double repaidTotal;
	/** 已还款本金 **/
	private Double repaidCapital;
	/** 已还款利息 **/
	private Double repaidInterest;
	/** 已还逾期利息 **/
	private Double repaidOverdueInterest;
	/** 已还服务费 **/
	private Double repaidServiceFee;
	/** 是否使用免息券 **/
	private Integer isInterestFreeNote;
	/** 免息总金额 **/
	private Double interestFreeAmount;
	/** 是否可提前还款 **/
	private Integer isPrepayment;
	/** 审核时间 **/
	private Date auditTime;
	/** 放款时间 **/
	private Date loanTime;
	/** 放款方式:放款到银行卡/放款到账户余额 **/
	private Integer loanWay;
	/** 放款账户 **/
	private String loanAccount;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 版本控制 **/
	@Version
	private Integer version;
	/** 获取【借款编号】 **/
	public String getCno() {
		return cno;
	}
	/** 设置【借款编号】 **/
	public void setCno(String cno) {
		this.cno = cno;
	}
	/** 获取【产品名称】 **/
	public String getName() {
		return name;
	}
	/** 设置【产品名称】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【债务人】 **/
	public User getUser() {
		return user;
	}
	/** 设置【债务人】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【产品类型】 **/
	public Integer getType() {
		return type;
	}
	/** 设置【产品类型】 **/
	public void setType(Integer type) {
		this.type = type;
	}
	/** 获取【状态】 **/
	public Integer getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(Integer state) {
		this.state = state;
	}
	/** 获取【借款本金总额】 **/
	public Double getTotal() {
		return total;
	}
	/** 设置【借款本金总额】 **/
	public void setTotal(Double total) {
		this.total = total;
	}
	/** 获取【还款方式】 **/
	public Integer getRepaymentType() {
		return repaymentType;
	}
	/** 设置【还款方式】 **/
	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}
	/** 获取【期限单位】 **/
	public Integer getPeriodUnit() {
		return periodUnit;
	}
	/** 设置【期限单位】 **/
	public void setPeriodUnit(Integer periodUnit) {
		this.periodUnit = periodUnit;
	}
	/** 获取【期限】 **/
	public Integer getPeriod() {
		return period;
	}
	/** 设置【期限】 **/
	public void setPeriod(Integer period) {
		this.period = period;
	}
	/** 获取【天利率】 **/
	public Double getRate() {
		return rate;
	}
	/** 设置【天利率】 **/
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/** 获取【逾期天利率】 **/
	public Double getOverdueRate() {
		return overdueRate;
	}
	/** 设置【逾期天利率】 **/
	public void setOverdueRate(Double overdueRate) {
		this.overdueRate = overdueRate;
	}
	/** 获取【服务费收取类型】 **/
	public Integer getServiceFeeType() {
		return serviceFeeType;
	}
	/** 设置【服务费收取类型】 **/
	public void setServiceFeeType(Integer serviceFeeType) {
		this.serviceFeeType = serviceFeeType;
	}
	/** 获取【服务费收取值】 **/
	public Double getServiceFeeValue() {
		return serviceFeeValue;
	}
	/** 设置【服务费收取值】 **/
	public void setServiceFeeValue(Double serviceFeeValue) {
		this.serviceFeeValue = serviceFeeValue;
	}
	/** 获取【应还总额】 **/
	public Double getRepaymentTotal() {
		return repaymentTotal;
	}
	/** 设置【应还总额】 **/
	public void setRepaymentTotal(Double repaymentTotal) {
		this.repaymentTotal = repaymentTotal;
	}
	/** 获取【应还本金】 **/
	public Double getRepaymentCapital() {
		return repaymentCapital;
	}
	/** 设置【应还本金】 **/
	public void setRepaymentCapital(Double repaymentCapital) {
		this.repaymentCapital = repaymentCapital;
	}
	/** 获取【应还利息】 **/
	public Double getRepaymentInterest() {
		return repaymentInterest;
	}
	/** 设置【应还利息】 **/
	public void setRepaymentInterest(Double repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}
	/** 获取【应还服务费】 **/
	public Double getRepyamentServiceFee() {
		return repyamentServiceFee;
	}
	/** 设置【应还服务费】 **/
	public void setRepyamentServiceFee(Double repyamentServiceFee) {
		this.repyamentServiceFee = repyamentServiceFee;
	}
	/** 获取【已还款总额】 **/
	public Double getRepaidTotal() {
		return repaidTotal;
	}
	/** 设置【已还款总额】 **/
	public void setRepaidTotal(Double repaidTotal) {
		this.repaidTotal = repaidTotal;
	}
	/** 获取【已还款本金】 **/
	public Double getRepaidCapital() {
		return repaidCapital;
	}
	/** 设置【已还款本金】 **/
	public void setRepaidCapital(Double repaidCapital) {
		this.repaidCapital = repaidCapital;
	}
	/** 获取【已还款利息】 **/
	public Double getRepaidInterest() {
		return repaidInterest;
	}
	/** 设置【已还款利息】 **/
	public void setRepaidInterest(Double repaidInterest) {
		this.repaidInterest = repaidInterest;
	}
	/** 获取【已还逾期利息】 **/
	public Double getRepaidOverdueInterest() {
		return repaidOverdueInterest;
	}
	/** 设置【已还逾期利息】 **/
	public void setRepaidOverdueInterest(Double repaidOverdueInterest) {
		this.repaidOverdueInterest = repaidOverdueInterest;
	}
	/** 获取【已还服务费】 **/
	public Double getRepaidServiceFee() {
		return repaidServiceFee;
	}
	/** 设置【已还服务费】 **/
	public void setRepaidServiceFee(Double repaidServiceFee) {
		this.repaidServiceFee = repaidServiceFee;
	}
	/** 获取【是否使用免息券】 **/
	public Integer getIsInterestFreeNote() {
		return isInterestFreeNote;
	}
	/** 设置【是否使用免息券】 **/
	public void setIsInterestFreeNote(Integer isInterestFreeNote) {
		this.isInterestFreeNote = isInterestFreeNote;
	}
	/** 获取【免息总金额】 **/
	public Double getInterestFreeAmount() {
		return interestFreeAmount;
	}
	/** 设置【免息总金额】 **/
	public void setInterestFreeAmount(Double interestFreeAmount) {
		this.interestFreeAmount = interestFreeAmount;
	}
	/** 获取【是否可提前还款】 **/
	public Integer getIsPrepayment() {
		return isPrepayment;
	}
	/** 设置【是否可提前还款】 **/
	public void setIsPrepayment(Integer isPrepayment) {
		this.isPrepayment = isPrepayment;
	}
	/** 获取【审核时间】 **/
	public Date getAuditTime() {
		return auditTime;
	}
	/** 设置【审核时间】 **/
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/** 获取【放款时间】 **/
	public Date getLoanTime() {
		return loanTime;
	}
	/** 设置【放款时间】 **/
	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}
	/** 获取【放款方式:放款到银行卡放款到账户余额】 **/
	public Integer getLoanWay() {
		return loanWay;
	}
	/** 设置【放款方式:放款到银行卡放款到账户余额】 **/
	public void setLoanWay(Integer loanWay) {
		this.loanWay = loanWay;
	}
	/** 获取【放款账户】 **/
	public String getLoanAccount() {
		return loanAccount;
	}
	/** 设置【放款账户】 **/
	public void setLoanAccount(String loanAccount) {
		this.loanAccount = loanAccount;
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
	/** 获取【版本控制】 **/
	public Integer getVersion() {
		return version;
	}
	/** 设置【版本控制】 **/
	public void setVersion(Integer version) {
		this.version = version;
	}
}