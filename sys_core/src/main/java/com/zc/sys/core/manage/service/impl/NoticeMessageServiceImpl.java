package com.zc.sys.core.manage.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.global.Global;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.common.sms.SmsService;
import com.zc.sys.core.manage.dao.NoticeMessageDao;
import com.zc.sys.core.manage.entity.NoticeMessage;
import com.zc.sys.core.manage.model.NoticeMessageModel;
import com.zc.sys.core.manage.service.NoticeMessageService;
import com.zc.sys.core.sys.dao.TemplateDao;
import com.zc.sys.core.sys.entity.Template;
import com.zc.sys.core.sys.model.TemplateModel;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
@Service
public class NoticeMessageServiceImpl implements NoticeMessageService {

	@Resource
	private NoticeMessageDao noticeMessageDao;
	@Resource
	private TemplateDao templateDao;
	@Resource
	private QueueProducerService queueProducerService;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(NoticeMessageModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(NoticeMessageModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(NoticeMessageModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(NoticeMessageModel model){

		return null;
	}
	
	/**
	 * 消息发送请求
	 * @param model
	 * @return
	 */
	@Override
	public void sendRequest(NoticeMessageModel model) {
		String nid = "notice_" + model.getNid();
		Template template = templateDao.findByNid(nid);
		if(template == null){
			LogUtil.info(nid + "配置未启用");
			return;
		}
		TemplateModel templateModel = TemplateModel.instance(template);
		model.initMessage(templateModel);
		//发送队列
		queueProducerService.send(new QueueModel(model.getOrderTaskModel().getQueueType(),model.getOrderTaskModel(), model));
	}

	/**
	 * 消息发送
	 * @param model
	 * @return
	 */
	@Override
	public Result send(NoticeMessageModel model) {
		switch (model.getType()) {
		case 1://站内信
			model.setState(1);
			model.setResult("成功");
			model.setResultCode("0000");
			break;
		case 2://短信
			this.sendSms(model);
		case 3://邮件
			
			break;
		default:
			return Result.error("参数错误");
		}
		NoticeMessage message = model.prototype();
		noticeMessageDao.save(message);
		return Result.success();
	}
	
	/**
	 * 短信发送方法
	 * @param model
	 */
	private void sendSms(NoticeMessageModel model){
		String smsRoute = Global.getValue("SMSRoute");
		if(StringUtil.isBlank(smsRoute)){
			LogUtil.info("短信通道未配置");
			return;
		}
		SmsService smsService = (SmsService)BeanUtil.getBean(smsRoute+ "Service");//短信渠道商
		smsService.sendSms(model);
		if(StringUtil.isNull(model.getResultCode()).equals("0000")){
			model.setState(-1);
		}
	}

}