package com.zc.common.queue.service;

import javax.jms.Destination;

import com.zc.common.queue.pojo.QueueModel;
/**
 * 队列生产者
 * 
 * @author zp
 * @version 0.0.1
 * @since 2017年7月26日
 */
public interface QueueService {

	void send(final QueueModel model);
	
	void send(Destination destination, final QueueModel model);
	
}
