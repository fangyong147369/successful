package com.zc.sys.promotion.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.promotion.constant.BasePromotionConstant;
/**
 * 活动推广奖励配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BasePromotionConstant.DB_PREFIX + BasePromotionConstant.DB_MODEL_Pt + "_promotion_prize_config")
public class PromotionPrizeConfig extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 活动推广id **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;
	/** 奖品类型 **/
	private int type;
	/** 奖品对应编号 **/
	private String prizeNo;
	/** 状态 **/
	private int state;
	/** 备注 **/
	private String remark;
	/** 添加时间 **/
	private Date addTime;
	/** 获取【活动推广id】 **/
	public Promotion getPromotion() {
		return promotion;
	}
	/** 设置【活动推广id】 **/
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	/** 获取【奖品类型】 **/
	public int getType() {
		return type;
	}
	/** 设置【奖品类型】 **/
	public void setType(int type) {
		this.type = type;
	}
	/** 获取【奖品对应编号】 **/
	public String getPrizeNo() {
		return prizeNo;
	}
	/** 设置【奖品对应编号】 **/
	public void setPrizeNo(String prizeNo) {
		this.prizeNo = prizeNo;
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
}