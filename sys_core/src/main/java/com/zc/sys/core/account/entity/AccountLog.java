package com.zc.sys.core.account.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.user.entity.User;
/**
 * 资金日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Acc + "_account_log")
public class AccountLog extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户 */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	/** 类型 **/
	private String type;
	/** 名称 **/
	private String name;
	/** 账户总额 **/
	private double total;
	/** 操作金额 **/
	private double amount;
	/** 可用余额 **/
	private double balance;
	/** 冻结金额 **/
	private double freezeAmount;
	/** 交易方用户 **/
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_user_id")
	private User toUser;
	/** 内容 **/
	private String content;
	/** 收支方式 **/
	private int payemntsType;
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
	/** 获取【账户总额】 **/
	public double getTotal() {
		return total;
	}
	/** 设置【账户总额】 **/
	public void setTotal(double total) {
		this.total = total;
	}
	/** 获取【操作金额】 **/
	public double getAmount() {
		return amount;
	}
	/** 设置【操作金额】 **/
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/** 获取【可用余额】 **/
	public double getBalance() {
		return balance;
	}
	/** 设置【可用余额】 **/
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/** 获取【冻结金额】 **/
	public double getFreezeAmount() {
		return freezeAmount;
	}
	/** 设置【冻结金额】 **/
	public void setFreezeAmount(double freezeAmount) {
		this.freezeAmount = freezeAmount;
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
	public int getPayemntsType() {
		return payemntsType;
	}
	/** 设置【收支方式】 **/
	public void setPayemntsType(int payemntsType) {
		this.payemntsType = payemntsType;
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