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
	private Integer state;
	/** 免息天数 **/
	private Integer day;
	/** 有效期类型：天数/截止时间 **/
	private Integer validityType;
	/** 有效期值 **/
	private String value;
	/** 发放配额 **/
	private Integer quota;
	/** 已发放数量 **/
	private Integer useQuota;
	/** 最小借款额度 **/
	private Double minAmount;
	/** 最大借款额度 **/
	private Double maxAmount;
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
	public Integer getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(Integer state) {
		this.state = state;
	}
	/** 获取【免息天数】 **/
	public Integer getDay() {
		return day;
	}
	/** 设置【免息天数】 **/
	public void setDay(Integer day) {
		this.day = day;
	}
	/** 获取【有效期类型：天数截止时间】 **/
	public Integer getValidityType() {
		return validityType;
	}
	/** 设置【有效期类型：天数截止时间】 **/
	public void setValidityType(Integer validityType) {
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
	public Integer getQuota() {
		return quota;
	}
	/** 设置【发放配额】 **/
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	/** 获取【已发放数量】 **/
	public Integer getUseQuota() {
		return useQuota;
	}
	/** 设置【已发放数量】 **/
	public void setUseQuota(Integer useQuota) {
		this.useQuota = useQuota;
	}
	/** 获取【最小借款额度】 **/
	public Double getMinAmount() {
		return minAmount;
	}
	/** 设置【最小借款额度】 **/
	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}
	/** 获取【最大借款额度】 **/
	public Double getMaxAmount() {
		return maxAmount;
	}
	/** 设置【最大借款额度】 **/
	public void setMaxAmount(Double maxAmount) {
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