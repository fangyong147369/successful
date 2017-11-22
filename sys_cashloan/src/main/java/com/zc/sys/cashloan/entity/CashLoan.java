package com.zc.sys.cashloan.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.zc.sys.cashloan.constant.BaseCashLoanConstant;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.user.entity.User;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseCashLoanConstant.DB_PREFIX + BaseCashLoanConstant.DB_MODEL_Cl + "_cash_loan")
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
	private double total;
	/** 还款方式 **/
	private Integer repaymentType;
	/** 期限单位 **/
	private Integer periodUnit;
	/** 期限 **/
	private Integer period;
	/** 天利率 **/
	private double rate;
	/** 逾期天利率 **/
	private double overdueRate;
	/** 服务费收取类型 **/
	private Integer serviceFeeType;
	/** 服务费收取值 **/
	private double serviceFeeValue;
	/** 应还总额 **/
	private double repaymentTotal;
	/** 应还本金 **/
	private double repaymentCapital;
	/** 应还利息 **/
	private double repaymentInterest;
	/** 应还服务费 **/
	private double repaymentServiceFee;
	/** 已还款总额 **/
	private double repaidTotal;
	/** 已还款本金 **/
	private double repaidCapital;
	/** 已还款利息 **/
	private double repaidInterest;
	/** 已还逾期利息 **/
	private double repaidOverdueInterest;
	/** 已还服务费 **/
	private double repaidServiceFee;
	/** 是否使用免息券 **/
	private Integer isInterestFreeNote;
	/** 免息总金额 **/
	private double interestFreeAmount;
	/** 是否可提前还款 **/
	private Integer isPrepayment;
	/** 审核时间 **/
	private Date auditTime;
	/** 审核管理员 **/
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "audit_operator_id")
	private Operator auditOperator;
	/** 放款时间 **/
	private Date loanTime;
	/** 放款方式:放款到银行卡/放款到账户余额 **/
	private Integer loanWay;
	/** 放款账户 **/
	private String loanAccount;
	/** 放款流水 **/
	private String loanOrderNo;
	/** 放款管理员 **/
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "loan_operator_id")
	private Operator loanOperator;
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
	public double getTotal() {
		return total;
	}
	/** 设置【借款本金总额】 **/
	public void setTotal(double total) {
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
	public double getRate() {
		return rate;
	}
	/** 设置【天利率】 **/
	public void setRate(double rate) {
		this.rate = rate;
	}
	/** 获取【逾期天利率】 **/
	public double getOverdueRate() {
		return overdueRate;
	}
	/** 设置【逾期天利率】 **/
	public void setOverdueRate(double overdueRate) {
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
	public double getServiceFeeValue() {
		return serviceFeeValue;
	}
	/** 设置【服务费收取值】 **/
	public void setServiceFeeValue(double serviceFeeValue) {
		this.serviceFeeValue = serviceFeeValue;
	}
	/** 获取【应还总额】 **/
	public double getRepaymentTotal() {
		return repaymentTotal;
	}
	/** 设置【应还总额】 **/
	public void setRepaymentTotal(double repaymentTotal) {
		this.repaymentTotal = repaymentTotal;
	}
	/** 获取【应还本金】 **/
	public double getRepaymentCapital() {
		return repaymentCapital;
	}
	/** 设置【应还本金】 **/
	public void setRepaymentCapital(double repaymentCapital) {
		this.repaymentCapital = repaymentCapital;
	}
	/** 获取【应还利息】 **/
	public double getRepaymentInterest() {
		return repaymentInterest;
	}
	/** 设置【应还利息】 **/
	public void setRepaymentInterest(double repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}
	/** 获取【应还服务费】 **/
	public double getRepaymentServiceFee() {
		return repaymentServiceFee;
	}
	/** 设置【应还服务费】 **/
	public void setRepaymentServiceFee(double repaymentServiceFee) {
		this.repaymentServiceFee = repaymentServiceFee;
	}
	/** 获取【已还款总额】 **/
	public double getRepaidTotal() {
		return repaidTotal;
	}
	/** 设置【已还款总额】 **/
	public void setRepaidTotal(double repaidTotal) {
		this.repaidTotal = repaidTotal;
	}
	/** 获取【已还款本金】 **/
	public double getRepaidCapital() {
		return repaidCapital;
	}
	/** 设置【已还款本金】 **/
	public void setRepaidCapital(double repaidCapital) {
		this.repaidCapital = repaidCapital;
	}
	/** 获取【已还款利息】 **/
	public double getRepaidInterest() {
		return repaidInterest;
	}
	/** 设置【已还款利息】 **/
	public void setRepaidInterest(double repaidInterest) {
		this.repaidInterest = repaidInterest;
	}
	/** 获取【已还逾期利息】 **/
	public double getRepaidOverdueInterest() {
		return repaidOverdueInterest;
	}
	/** 设置【已还逾期利息】 **/
	public void setRepaidOverdueInterest(double repaidOverdueInterest) {
		this.repaidOverdueInterest = repaidOverdueInterest;
	}
	/** 获取【已还服务费】 **/
	public double getRepaidServiceFee() {
		return repaidServiceFee;
	}
	/** 设置【已还服务费】 **/
	public void setRepaidServiceFee(double repaidServiceFee) {
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
	public double getInterestFreeAmount() {
		return interestFreeAmount;
	}
	/** 设置【免息总金额】 **/
	public void setInterestFreeAmount(double interestFreeAmount) {
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
		if(loanWay != null){
			loanWay = loanWay.intValue();
		}
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
	/** 获取【放款流水】 **/
	public String getLoanOrderNo() {
		return loanOrderNo;
	}
	/** 设置【放款流水】 **/
	public void setLoanOrderNo(String loanOrderNo) {
		this.loanOrderNo = loanOrderNo;
	}
	/** 获取【审核管理员】 **/
	public Operator getAuditOperator() {
		return auditOperator;
	}
	/** 设置【审核管理员】 **/
	public void setAuditOperator(Operator auditOperator) {
		this.auditOperator = auditOperator;
	}
	/** 获取【放款管理员】 **/
	public Operator getLoanOperator() {
		return loanOperator;
	}
	/** 设置【放款管理员】 **/
	public void setLoanOperator(Operator loanOperator) {
		this.loanOperator = loanOperator;
	}
}