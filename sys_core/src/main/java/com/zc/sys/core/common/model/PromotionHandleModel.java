package com.zc.sys.core.common.model;

import java.io.Serializable;

import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.entity.User;

/**
 * 推广处理model
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月25日
 */
public class PromotionHandleModel implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/** 推广活动方式 **/
	private int promotionWay;
	
	/** 用户 **/
	private User user;
	
	/** 订单 **/
	private OrderTaskModel orderTaskModel;

	public PromotionHandleModel() {
		super();
	}
	
	/**
	 * @param promotionWay
	 * @param user
	 * @param orderTaskModel
	 */
	public PromotionHandleModel(int promotionWay, User user,
			OrderTaskModel orderTaskModel) {
		super();
		this.promotionWay = promotionWay;
		this.user = user;
		this.orderTaskModel = orderTaskModel;
	}


	/** 获取【推广活动方式】 **/
	public int getPromotionWay() {
		return promotionWay;
	}

	/** 设置【推广活动方式】 **/
	public void setPromotionWay(int promotionWay) {
		this.promotionWay = promotionWay;
	}

	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}

	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}

	/** 获取【订单】 **/
	public OrderTaskModel getOrderTaskModel() {
		return orderTaskModel;
	}

	/** 设置【订单】 **/
	public void setOrderTaskModel(OrderTaskModel orderTaskModel) {
		this.orderTaskModel = orderTaskModel;
	}

	@Override
	public String toString() {
		return "PromotionHandleModel [promotionWay=" + promotionWay + ", user="
				+ user.getId() + ", orderTaskModel=" + orderTaskModel.getOrderNo() + "]";
	}

}
