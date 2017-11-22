package com.zc.sys.core.account.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.user.entity.User;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Acc + "_account")
public class Account extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	/** 账户总额 **/
	private double total;
	/** 可用余额 **/
	private double balance;
	/** 冻结金额 **/
	private double freezeAmount;
	/** 版本控制 **/
	@Version
	private Integer version;
	
	
	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}
	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【账户总额】 **/
	public double getTotal() {
		return total;
	}
	/** 设置【账户总额】 **/
	public void setTotal(double total) {
		this.total = total;
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
	/** 获取【版本控制】 **/
	public Integer getVersion() {
		return version;
	}
	/** 设置【版本控制】 **/
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}