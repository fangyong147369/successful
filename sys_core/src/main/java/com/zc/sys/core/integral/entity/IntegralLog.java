package com.zc.sys.core.integral.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.user.entity.User;
/**
 * 积分日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Jf + "_integral_log")
public class IntegralLog extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	/** 操作积分 **/
	private Double integral;
	/** 类型 **/
	private String type;
	/** 名称 **/
	private String name;
	/** 积分总额 **/
	private Double totalIntegral;
	/** 可用积分 **/
	private Double balanceIntegral;
	/** 消费积分 **/
	private Double expenseIntegral;
	/** 冻结积分 **/
	private Double freezeIntegral;
	/** 交易方用户 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "to_user_id")
	private User toUser;
	/** 内容 **/
	private String content;
	/** 收支方式 **/
	private Integer paymentType;
	/** 关联订单 **/
	private String orderNo;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}
	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【操作积分】 **/
	public Double getIntegral() {
		return integral;
	}
	/** 设置【操作积分】 **/
	public void setIntegral(Double integral) {
		this.integral = integral;
	}
	/** 获取【类型】 **/
	public String getType() {
		return type;
	}
	/** 设置【类型】 **/
	public void setType(String type) {
		this.type = type;
	}
	/** 获取【名称】 **/
	public String getName() {
		return name;
	}
	/** 设置【名称】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【积分总额】 **/
	public Double getTotalIntegral() {
		return totalIntegral;
	}
	/** 设置【积分总额】 **/
	public void setTotalIntegral(Double totalIntegral) {
		this.totalIntegral = totalIntegral;
	}
	/** 获取【可用积分】 **/
	public Double getBalanceIntegral() {
		return balanceIntegral;
	}
	/** 设置【可用积分】 **/
	public void setBalanceIntegral(Double balanceIntegral) {
		this.balanceIntegral = balanceIntegral;
	}
	/** 获取【消费积分】 **/
	public Double getExpenseIntegral() {
		return expenseIntegral;
	}
	/** 设置【消费积分】 **/
	public void setExpenseIntegral(Double expenseIntegral) {
		this.expenseIntegral = expenseIntegral;
	}
	/** 获取【冻结积分】 **/
	public Double getFreezeIntegral() {
		return freezeIntegral;
	}
	/** 设置【冻结积分】 **/
	public void setFreezeIntegral(Double freezeIntegral) {
		this.freezeIntegral = freezeIntegral;
	}
	/** 获取【交易方用户】 **/
	public User getToUser() {
		return toUser;
	}
	/** 设置【交易方用户】 **/
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	/** 获取【内容】 **/
	public String getContent() {
		return content;
	}
	/** 设置【内容】 **/
	public void setContent(String content) {
		this.content = content;
	}
	/** 获取【收支方式】 **/
	public Integer getPaymentType() {
		return paymentType;
	}
	/** 设置【收支方式】 **/
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	/** 获取【关联订单】 **/
	public String getOrderNo() {
		return orderNo;
	}
	/** 设置【关联订单】 **/
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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