package com.zc.sys.promotion.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.promotion.constant.BaseConstant;
/**
 * 免息券
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Pt + "_interest_free_note")
public class InterestFreeNote extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 券编号 **/
	private String noteNo;
	/** 券名称 **/
	private String name;
	/** 状态 **/
	private int state;
	/** 免息天数 **/
	private int day;
	/** 有效期类型：天数/截止时间 **/
	private int validityType;
	/** 有效期值 **/
	private String value;
	/** 发放配额 **/
	private int quota;
	/** 已发放数量 **/
	private int useQuota;
	/** 最小借款额度 **/
	private double minAmount;
	/** 最大借款额度 **/
	private double maxAmount;
	/** 简介 **/
	private String summary;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 获取【券编号】 **/
	public String getNoteNo() {
		return noteNo;
	}
	/** 设置【券编号】 **/
	public void setNoteNo(String noteNo) {
		this.noteNo = noteNo;
	}
	/** 获取【券名称】 **/
	public String getName() {
		return name;
	}
	/** 设置【券名称】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【状态】 **/
	public int getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(int state) {
		this.state = state;
	}
	/** 获取【免息天数】 **/
	public int getDay() {
		return day;
	}
	/** 设置【免息天数】 **/
	public void setDay(int day) {
		this.day = day;
	}
	/** 获取【有效期类型：天数截止时间】 **/
	public int getValidityType() {
		return validityType;
	}
	/** 设置【有效期类型：天数截止时间】 **/
	public void setValidityType(int validityType) {
		this.validityType = validityType;
	}
	/** 获取【有效期值】 **/
	public String getValue() {
		return value;
	}
	/** 设置【有效期值】 **/
	public void setValue(String value) {
		this.value = value;
	}
	/** 获取【发放配额】 **/
	public int getQuota() {
		return quota;
	}
	/** 设置【发放配额】 **/
	public void setQuota(int quota) {
		this.quota = quota;
	}
	/** 获取【已发放数量】 **/
	public int getUseQuota() {
		return useQuota;
	}
	/** 设置【已发放数量】 **/
	public void setUseQuota(int useQuota) {
		this.useQuota = useQuota;
	}
	/** 获取【最小借款额度】 **/
	public double getMinAmount() {
		return minAmount;
	}
	/** 设置【最小借款额度】 **/
	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}
	/** 获取【最大借款额度】 **/
	public double getMaxAmount() {
		return maxAmount;
	}
	/** 设置【最大借款额度】 **/
	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}
	/** 获取【简介】 **/
	public String getSummary() {
		return summary;
	}
	/** 设置【简介】 **/
	public void setSummary(String summary) {
		this.summary = summary;
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