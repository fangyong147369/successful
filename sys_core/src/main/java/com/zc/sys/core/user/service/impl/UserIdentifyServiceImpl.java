package com.zc.sys.core.user.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.entity.UserIdentify;
import com.zc.sys.core.user.executer.UserRealNameExecuter;
import com.zc.sys.core.user.model.UserIdentifyModel;
import com.zc.sys.core.user.service.UserIdentifyService;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class UserIdentifyServiceImpl implements UserIdentifyService {

	@Resource
	private UserIdentifyDao userIdentifyDao;
	@Resource
	private OrderTaskDao orderTaskDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(UserIdentifyModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(UserIdentifyModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(UserIdentifyModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserIdentifyModel model){

		return null;
	}
	

	/**
	 * 实名请求
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Object realNameRequest(UserIdentifyModel model) {
		model.checkRealName();//实名校验
		UserIdentify userIdentify = (UserIdentify) userIdentifyDao.findObjByProperty("user.id", model.getUser().getId());
		/*if(userIdentify.getRealNameCount() > Global.getInt("realNameCount")){
			return Result.error("已达到实名认证次数上限，请联系平台处理");
		}*/
		model.initRealName(userIdentify);//初始化实名
		userIdentifyDao.update(userIdentify);
		model.setId(userIdentify.getId());
		
		//发送队列处理实名
		QueueProducerService queueProducerService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(userIdentify.getUser(), "realName", StringUtil.getSerialNumber(), 2, "", DateUtil.getNow());
		orderTaskDao.merge(orderTask);
		model.setOrderTask(orderTask);
		queueProducerService.send(new QueueModel("user",OrderTaskModel.instance(model.getOrderTask()), model));
		return Result.success("实名处理中...请稍后！");
	}

	/**
	 * 实名处理
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Object realNameDeal(UserIdentifyModel model) {
		UserIdentify userIdentify = userIdentifyDao.find(model.getId());
		userIdentify.setRealNameState(1);
		userIdentifyDao.update(userIdentify);
		
		//订单处理
		OrderTask orderTask = model.getOrderTask();
		orderTask.setDoTime(DateUtil.getNow());
		orderTask.setDoResult("实名成功");
		orderTask.setState(1);
		orderTaskDao.update(orderTask);
		
		//实名成功任务
		Executer realNameExecuter = BeanUtil.getBean(UserRealNameExecuter.class);
		realNameExecuter.execute(model);
		return Result.success();
	}

	/**
	 * 数据魔盒-运营商-数据认证请求
	 * @param model
	 * @return
	 */
	@Override
	public Object octopusRequest(UserIdentifyModel model) {
		
		return null;
	}

	/**
	 * 数据魔盒-运营商-数据认证处理
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Object octopusDeal(UserIdentifyModel model) {
		
		return null;
	}
	
}