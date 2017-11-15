package com.zc.sys.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;

/**
 * 处理队列消息监听
 * 通知消息处理
 * @author zp
 * @version 0.0.1
 * @since 2017年7月26日
 */
public class NoticeConsumerMessageListener implements MessageListener{

	public void onMessage(Message message) {
        try {
        	ObjectMessage objectMessage = (ObjectMessage) message;
        	QueueModel model = (QueueModel)objectMessage.getObject();
        	LogUtil.info("===============【通知消息监听队列处理】接收消息：" + model.getOrderTask().toString());
        	
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
	
}
