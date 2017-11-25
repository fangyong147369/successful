package com.zc.sys.promotion.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.promotion.constant.BasePromotionConstant;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BasePromotionConstant.DB_PREFIX + BasePromotionConstant.DB_MODEL_Pt + "_promotion")
public class Promotion extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 标题 **/
	private String name;
	/** 推广方式 **/
	private int way;
	/** 推广内容 **/
	private String content;
	/** 摘要 **/
	private String summary;
	/** 状态 **/
	private int state;
	/** 开始时间 **/
	private Date startTime;
	/** 结束时间 **/
	private Date endTime;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 获取【标题】 **/
	public String getName() {
		return name;
	}
	/** 设置【标题】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【推广方式】 **/
	public int getWay() {
		return way;
	}
	/** 设置【推广方式】 **/
	public void setWay(int way) {
		this.way = way;
	}
	/** 获取【摘要】 **/
	public String getSummary() {
		return summary;
	}
	/** 设置【摘要】 **/
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/** 获取【状态】 **/
	public int getState() {
		return state;
	}
	/** 设置【状态】 **/
	public void setState(int state) {
		this.state = state;
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
	/** 获取【推广内容】 **/
	public String getContent() {
		return content;
	}
	/** 设置【推广内容】 **/
	public void setContent(String content) {
		this.content = content;
	}
}