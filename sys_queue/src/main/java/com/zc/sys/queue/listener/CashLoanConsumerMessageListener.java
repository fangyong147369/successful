package com.zc.sys.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.queue.consumer.QueueConsumerService;

/**
 * 处理队列消息监听
 * 现金贷队列处理
 * @author zp
 * @version 2.0.0.0
 * @since 2017年7月26日
 */
public class CashLoanConsumerMessageListener implements MessageListener{

	public void onMessage(Message message) {
        try {
        	ObjectMessage objectMessage = (ObjectMessage) message;
        	QueueModel model = (QueueModel)objectMessage.getObject();
            LogUtil.info("===============【现金贷监听队列处理】接收消息：" + model.getOrderTaskModel().toString());
            QueueConsumerService queueConsumerService = (QueueConsumerService)BeanUtil.getBean(QueueConsumerService.class);
            queueConsumerService.receive(model);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
	
}
