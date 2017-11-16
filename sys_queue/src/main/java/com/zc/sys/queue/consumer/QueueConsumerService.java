package com.zc.sys.queue.consumer;

import com.zc.sys.core.common.queue.pojo.QueueModel;

/**
 * 队列消费者
 * @author zp
 * @version 2.0.0.0
 * @since 2017年7月26日
 */
public interface QueueConsumerService {

	/**
	 * 消费者处理
	 * @param model
	 */
	void receive(QueueModel model);
}
