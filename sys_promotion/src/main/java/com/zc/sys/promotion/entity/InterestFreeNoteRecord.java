package com.zc.sys.promotion.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.promotion.constant.BasePromotionConstant;
/**
 * 免息券发放记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BasePromotionConstant.DB_PREFIX + BasePromotionConstant.DB_MODEL_Pt + "_interest_free_note_record")
public class InterestFreeNoteRecord extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 债务人 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	/** 免息券 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "interest_free_note_id")
	private InterestFreeNote interestFreeNote;
	/** 状态 **/
	private int state;
	/** 发放管理员 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "operator_id")
	private Operator operator;
	/** 使用时间 **/
	private Date useTime;
	/** 免息金额 **/
	private double amount;
	/** 开始时间 **/
	private Date startTime;
	/** 结束时间 **/
	private Date endTime;
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
	/** 获取【免息券】 **/
	public InterestFreeNote getInterestFreeNote() {
		return interestFreeNote;
	}
	/** 设置【免息券】 **/
	public void setInterestFreeNote(InterestFreeNote interestFreeNote) {
		this.interestFreeNote = interestFreeNote;
	}
	/** 获取【状态】 **/
	public int getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(int state) {
		this.state = state;
	}
	/** 获取【发放管理员】 **/
	public Operator getOperator() {
		return operator;
	}
	/** 设置【发放管理员】 **/
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	/** 获取【使用时间】 **/
	public Date getUseTime() {
		return useTime;
	}
	/** 设置【使用时间】 **/
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	/** 获取【免息金额】 **/
	public double getAmount() {
		return amount;
	}
	/** 设置【免息金额】 **/
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/** 获取【开始时间】 **/
	public Date getStartTime() {
		return startTime;
	}
	/** 设置【开始时间】 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/** 获取【结束时间】 **/
	public Date getEndTime() {
		return endTime;
	}
	/** 设置【结束时间】 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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