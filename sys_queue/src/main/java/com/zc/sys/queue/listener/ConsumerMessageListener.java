package com.zc.sys.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;

/**
 * 处理队列消息监听
 * 综合信息处理
 * @author zp
 * @version 0.0.1
 * @since 2017年7月26日
 */
public class ConsumerMessageListener implements MessageListener{

	public void onMessage(Message message) {
        try {
        	ObjectMessage objectMessage = (ObjectMessage) message;
        	QueueModel model = (QueueModel)objectMessage.getObject();
        	LogUtil.info("===============【综合信息监听队列处理】接收消息：" + model.getOrderTask().toString());
        	/*if(model.getObj() instanceof Notice){
        		NoticeService noticeService = (NoticeService)BeanUtil.getBean(NoticeService.class);
        		noticeService.sendNotice((Notice)model.getObj());
        	}*/
        	
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
	
}
