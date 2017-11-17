package com.zc.sys.core.integral.entity;
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
 * 积分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Jf + "_integral_account")
public class IntegralAccount extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	/** 积分总额 **/
	private Double totalIntegral;
	/** 可用积分 **/
	private Double balanceIntegral;
	/** 消费积分 **/
	private Double expenseIntegral;
	/** 冻结积分 **/
	private Double freezeIntegral;
	/** 积分等级 **/
	private Integer gradeIntegral;
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
	/** 获取【积分等级】 **/
	public Integer getGradeIntegral() {
		return gradeIntegral;
	}
	/** 设置【积分等级】 **/
	public void setGradeIntegral(Integer gradeIntegral) {
		this.gradeIntegral = gradeIntegral;
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