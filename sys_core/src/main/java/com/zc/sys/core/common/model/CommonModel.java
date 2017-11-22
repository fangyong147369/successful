package com.zc.sys.core.common.model;

import java.util.Date;
import java.util.List;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.util.calculate.BigDecimalUtil;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.interest.CalculatorModel;

/**
 * 公共接口
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
public class CommonModel {

	/** 手机号 **/
	private String mobile;
	/** 期限单位 **/
	private int periodUnit;
	/** 期限 **/
	private int period;
	/** 借款金额 **/
	private double amount;
	/** 天利率 **/
	private double rate;
	/** 计息开始时间 **/
	private Date startTime;
	/** 还款方式 **/
	private int repaymentType;
	/** 还款利息总额 **/
	private double interestTotal;
	/** 还款总额（本息） **/
	private double total;
	/** 还款计划model **/
	private List<CalculatorModel> CalculatorModelList;

	public CommonModel() {
		super();
	}
	
	/**
	 * @param periodUnit
	 * @param period
	 * @param amount
	 * @param rate
	 * @param startTime
	 * @param repaymentType
	 */
	public CommonModel(int periodUnit, int period, double amount, double rate,
			Date startTime, int repaymentType) {
		super();
		this.periodUnit = periodUnit;
		this.period = period;
		this.amount = amount;
		this.rate = rate;
		this.startTime = startTime;
		this.repaymentType = repaymentType;
	}

	/**
	 * 短信发送校验
	 */
	public void checkSMS() {
		if(StringUtil.isBlank(mobile) || !StringUtil.isPhone(mobile)){
			throw new BusinessException("手机号不能为空");
		}
	}
	
	/**
	 * 利息计算器参数校验及初始化
	 */
	public void checkAndInitCalculator() {
		if(periodUnit != BaseConstant.PERIODUNIT_DAY && periodUnit != BaseConstant.PERIODUNIT_MONTH){
			throw new BusinessException("参数错误");
		}
		if(period <= 0){
			throw new BusinessException("借款期限必须大于0");
		}
		if(amount <= 0){
			throw new BusinessException("借款金额必须大于0");
		}
		if(rate <=0){
			throw new BusinessException("借款天利率必须大于0");
		}
		if(repaymentType != BaseConstant.REPAYMENT_WAY_ONETIME){
			throw new BusinessException("参数错误");
		}
		if(startTime == null){
			startTime = DateUtil.getNow();
		}
		rate = BigDecimalUtil.div(rate, 100);
	}

	/** 获取【手机号】 **/
	public String getMobile() {
		return mobile;
	}

	/** 设置【手机号】 **/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/** 获取【期限单位】 **/
	public int getPeriodUnit() {
		return periodUnit;
	}

	/** 设置【期限单位】 **/
	public void setPeriodUnit(int periodUnit) {
		this.periodUnit = periodUnit;
	}

	/** 获取【期限】 **/
	public int getPeriod() {
		return period;
	}

	/** 设置【期限】 **/
	public void setPeriod(int period) {
		this.period = period;
	}

	/** 获取【借款金额】 **/
	public double getAmount() {
		return amount;
	}

	/** 设置【借款金额】 **/
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/** 获取【天利率】 **/
	public double getRate() {
		return rate;
	}

	/** 设置【天利率】 **/
	public void setRate(double rate) {
		this.rate = rate;
	}

	/** 获取【计息开始时间】 **/
	public Date getStartTime() {
		return startTime;
	}

	/** 设置【计息开始时间】 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/** 获取【还款方式】 **/
	public int getRepaymentType() {
		return repaymentType;
	}

	/** 设置【还款方式】 **/
	public void setRepaymentType(int repaymentType) {
		this.repaymentType = repaymentType;
	}

	/** 获取【还款利息总额】 **/
	public double getInterestTotal() {
		return interestTotal;
	}

	/** 设置【还款利息总额】 **/
	public void setInterestTotal(double interestTotal) {
		this.interestTotal = interestTotal;
	}

	/** 获取【还款总额（本息）】 **/
	public double getTotal() {
		return total;
	}

	/** 设置【还款总额（本息）】 **/
	public void setTotal(double total) {
		this.total = total;
	}

	/** 获取【calculatorModelList】 **/
	public List<CalculatorModel> getCalculatorModelList() {
		return CalculatorModelList;
	}

	/** 设置【calculatorModelList】 **/
	public void setCalculatorModelList(List<CalculatorModel> calculatorModelList) {
		CalculatorModelList = calculatorModelList;
	}
	
}
