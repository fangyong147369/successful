package com.zc.sys.core.common.queue.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueService;

/**
 * 生产者
 * 
 * @author zp
 * @version 0.0.1
 * @since 2017年7月26日
 */
@Service
public class QueueServiceImpl implements QueueService{

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
    @Qualifier("queueDestination")
    private Destination destinationQueue;//queue
//	@Autowired
//	@Qualifier("topicDestination")
//	private Destination destinationTopic;//topic
	
	public void send(final QueueModel model) {
		send(destinationQueue, model);
    }
	
	public void send(Destination destination, final QueueModel model) {
        LogUtil.info("==============生产者发送消息：" + model.toString());
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	Message message = session.createObjectMessage(model);
            	message.setStringProperty("code",model.getCode());
                return message;
            }
        });
    }
}
