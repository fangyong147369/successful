package com.zc.sys.core.common.queue.pojo;

import java.io.Serializable;

import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;

public class QueueModel implements Serializable{
	/** 序列化 **/
	private static final long serialVersionUID = 1L;
	
	/** 监听代码 **/
	private String code;
	
	/** 订单信息 **/
	private OrderTaskModel orderTaskModel;
	
	/** 处理实体 **/
	private Object obj;

	public QueueModel() {
		super();
	}

	public QueueModel(String code, OrderTaskModel orderTaskModel, Object obj) {
		super();
		this.code = code;
		this.orderTaskModel = orderTaskModel;
		this.obj = obj;
	}


	/** 获取【处理实体】 **/
	public Object getObj() {
		return obj;
	}

	/** 设置【处理实体】 **/
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/** 获取【订单信息】 **/
	public OrderTaskModel getOrderTaskModel() {
		return orderTaskModel;
	}

	/** 设置【订单信息】 **/
	public void setOrderTaskModel(OrderTaskModel orderTaskModel) {
		this.orderTaskModel = orderTaskModel;
	}

	/** 获取【监听代码】 **/
	public String getCode() {
		return code;
	}

	/** 设置【监听代码】 **/
	public void setCode(String code) {
		this.code = code;
	}
	
}
