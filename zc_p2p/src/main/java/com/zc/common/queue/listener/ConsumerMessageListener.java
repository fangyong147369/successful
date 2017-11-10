package com.zc.common.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.zc.common.queue.pojo.QueueModel;
import com.zc.common.util.BeanUtil;
import com.zc.common.util.log.LogUtil;

/**
 * 处理队列消息监听
 * 
 * @author zp
 * @version 0.0.1
 * @since 2017年7月26日
 */
public class ConsumerMessageListener implements MessageListener{

	public void onMessage(Message message) {
        try {
        	ObjectMessage objectMessage = (ObjectMessage) message;
        	QueueModel model = (QueueModel)objectMessage.getObject();
        	/*if(model.getObj() instanceof Notice){
        		NoticeService noticeService = (NoticeService)BeanUtil.getBean(NoticeService.class);
        		noticeService.sendNotice((Notice)model.getObj());
        	}*/
        	
            LogUtil.info("===============消费者接收消息：" + model.toString());
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
	
}
