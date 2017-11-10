package com.zc.sys.core.common.queue.pojo;

import java.io.Serializable;

public class QueueModel implements Serializable{
	/** 序列化 **/
	private static final long serialVersionUID = 1L;

	/** 业务代码 **/
	private String code;
	
	/** 订单号 **/
	private String orderNo;
	
	/** 处理实体 **/
	private Object obj;

	public QueueModel() {
		super();
	}
	
	public QueueModel(String code, String orderNo, Object obj) {
		super();
		this.code = code;
		this.orderNo = orderNo;
		this.obj = obj;
	}

	public QueueModel(Object obj) {
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

	/** 获取【业务代码】 **/
	public String getCode() {
		return code;
	}

	/** 设置【业务代码】 **/
	public void setCode(String code) {
		this.code = code;
	}

	/** 获取【订单号】 **/
	public String getOrderNo() {
		return orderNo;
	}

	/** 设置【订单号】 **/
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
