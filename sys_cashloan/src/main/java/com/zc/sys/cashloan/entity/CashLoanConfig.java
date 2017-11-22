package com.zc.sys.cashloan.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zc.sys.cashloan.constant.BaseCashLoanConstant;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.manage.entity.Operator;
/**
 * 现金贷产品配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月22日
 */
@Entity
@Table(name=BaseCashLoanConstant.DB_PREFIX + BaseCashLoanConstant.DB_MODEL_Cl + "_cash_loan_config")
public class CashLoanConfig extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 名称 **/
	private String name;
	/** 期限单位 **/
	private int periodUnit;
	/** 期限 **/
	private String period;
	/** 天利率 **/
	private double rate;
	/** 还款方式 **/
	private String repaymentType;
	/** 服务费收取类型 **/
	private int serviceFeeType;
	/** 服务费收取值 **/
	private double serviceFeeValue;
	/** 是否支持提前还款 **/
	private int isPrepayment;
	/** 逾期利率 **/
	private double overdueRate;
	/** 状态 **/
	private int state;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 最后修改时间 **/
	private Date updateTime;
	/** 最后修改管理员 **/
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "update_operator_id")
	private Operator updateOperator;
	
	/** 获取【名称】 **/
	public String getName() {
		return name;
	}
	/** 设置【名称】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【期限单位】 **/
	public int getPeriodUnit() {
		return periodUnit;
	}
	/** 设置【期限单位】 **/
	public void setPeriodUnit(int periodUnit) {
		this.periodUnit = periodUnit;
	}
	/** 获取【天利率】 **/
	public double getRate() {
		return rate;
	}
	/** 设置【天利率】 **/
	public void setRate(double rate) {
		this.rate = rate;
	}
	/** 获取【服务费收取类型】 **/
	public int getServiceFeeType() {
		return serviceFeeType;
	}
	/** 设置【服务费收取类型】 **/
	public void setServiceFeeType(int serviceFeeType) {
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
	/** 获取【是否支持提前还款】 **/
	public int getIsPrepayment() {
		return isPrepayment;
	}
	/** 设置【是否支持提前还款】 **/
	public void setIsPrepayment(int isPrepayment) {
		this.isPrepayment = isPrepayment;
	}
	/** 获取【逾期利率】 **/
	public double getOverdueRate() {
		return overdueRate;
	}
	/** 设置【逾期利率】 **/
	public void setOverdueRate(double overdueRate) {
		this.overdueRate = overdueRate;
	}
	/** 获取【状态】 **/
	public int getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(int state) {
		this.state = state;
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
	/** 获取【期限】 **/
	public String getPeriod() {
		return period;
	}
	/** 设置【期限】 **/
	public void setPeriod(String period) {
		this.period = period;
	}
	/** 获取【还款方式】 **/
	public String getRepaymentType() {
		return repaymentType;
	}
	/** 设置【还款方式】 **/
	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}
	/** 获取【最后修改时间】 **/
	public Date getUpdateTime() {
		return updateTime;
	}
	/** 设置【最后修改时间】 **/
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/** 获取【最后修改管理员】 **/
	public Operator getUpdateOperator() {
		return updateOperator;
	}
	/** 设置【最后修改管理员】 **/
	public void setUpdateOperator(Operator updateOperator) {
		this.updateOperator = updateOperator;
	}
	
}