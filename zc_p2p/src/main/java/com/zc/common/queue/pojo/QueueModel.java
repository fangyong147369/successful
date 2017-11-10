package com.zc.common.queue.pojo;

import java.io.Serializable;

public class QueueModel implements Serializable{
	/** 序列化 **/
	private static final long serialVersionUID = 1L;

	/** 处理实体 **/
	private Object obj;
	/** 处理类 **/
//	private Class clazzService;

	public QueueModel() {
		super();
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
	
}
