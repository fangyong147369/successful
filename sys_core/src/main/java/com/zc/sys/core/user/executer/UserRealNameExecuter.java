package com.zc.sys.core.user.executer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.executer.BaseExecuter;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.NoticeMessageModel;
import com.zc.sys.core.user.model.UserIdentifyModel;

/**
 * 用户实名成功任务
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月13日
 */
@Component
public class UserRealNameExecuter extends BaseExecuter{

	@Resource
	private QueueProducerService queueProducerService;
	@Resource
	private OrderTaskDao orderTaskDao;
	private UserIdentifyModel model;
	
	@Override
	public void init() {
		if(!(this.obj instanceof UserIdentifyModel)){
			throw new BussinessException("实例不存在");
		}
		this.model = (UserIdentifyModel) this.obj;
	}
	
	@Override
	public void sendMessage() {
		try {
//			OrderTask orderTask = new OrderTask(model.getUser(), "sendMessage", StringUtil.getSerialNumber(), 2, "", DateUtil.getNow());
//			orderTaskDao.merge(orderTask);
//			NoticeMessageModel message = new NoticeMessageModel(2, null, model.getUser(), null, orderTask.getOrderNo(), orderTask);
//			queueProducerService.send(new QueueModel("sendMessage",model.getOrderTask(), message));
		} catch (Exception e) {
			LogUtil.info("Message消息发送失败" + e.getMessage());
		}
	}
	
	@Override
	public void sendSMS() {
		try {
//			OrderTask orderTask = new OrderTask(model.getUser(), "sendSMS", StringUtil.getSerialNumber(), 2, "", DateUtil.getNow());
//			orderTaskDao.merge(orderTask);
//			NoticeMessageModel sms = new NoticeMessageModel(2, null, model.getUser(), null, orderTask.getOrderNo(), orderTask);
//			queueProducerService.send(new QueueModel("sendSMS",model.getOrderTask(), sms));
		} catch (Exception e) {
			LogUtil.info("SMS消息发送失败" + e.getMessage());
		}
	}
	
}
