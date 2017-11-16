package com.zc.sys.core.common.executer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.core.manage.model.NoticeMessageModel;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.manage.service.NoticeMessageService;

/**
 * 注册等通用消息任务
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月13日
 */
@Component
public class NoticeMessageExecuter extends BaseExecuter{

	@Resource
	private NoticeMessageService noticeMessageService;
	private NoticeMessageModel model;
	
	@Override
	public void init() {
		if(!(this.obj instanceof NoticeMessageModel)){
			throw new BussinessException("实例不存在");
		}
		this.model = (NoticeMessageModel) this.obj;
	}
	
	@Override
	public void sendMessage() {
		try {
			OrderTaskModel orderTaskModel = model.getOrderTaskModel();
			orderTaskModel.setQueueType("sendMessage");
			model.setOrderTaskModel(orderTaskModel);
			noticeMessageService.sendRequest(model);
		} catch (Exception e) {
			LogUtil.info("Message消息发送失败" + e.getMessage());
		}
	}
	
	@Override
	public void sendSMS() {
		try {
			OrderTaskModel orderTaskModel = model.getOrderTaskModel();
			orderTaskModel.setQueueType("sendSMS");
			model.setOrderTaskModel(orderTaskModel);
			noticeMessageService.sendRequest(model);
		} catch (Exception e) {
			LogUtil.info("SMS消息发送失败" + e.getMessage());
		}
	}
	
}
