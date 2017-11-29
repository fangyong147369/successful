package com.zc.sys.core.user.executer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.executer.BaseExecuter;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.model.PromotionHandleModel;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.model.UserModel;

/**
 * 用户注册任务
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月13日
 */
@Component
public class UserRegExecuter extends BaseExecuter{

	private UserModel model;
	@Resource
	private OrderTaskDao orderTaskDao;
	/** 推广活动方式-注册  **/
	public static final int PROMOTION_WAY_REG = 1;
	
	@Override
	public void init() {
		if(!(this.obj instanceof UserModel)){
			throw new BusinessException("实例不存在");
		}
		this.model = (UserModel) this.obj;
	}
	
	@Override
	public void handlePromotion() {
		QueueProducerService queueProducerService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(model.prototype(), "promotion", StringUtil.getSerialNumber(), 2, "", DateUtil.getNow());
		orderTaskDao.save(orderTask);
		OrderTaskModel orderTaskModel =OrderTaskModel.instance(orderTask);
		PromotionHandleModel phModel = new PromotionHandleModel(PROMOTION_WAY_REG, model.prototype(),orderTaskModel);
		queueProducerService.send(new QueueModel("promotion",phModel.getOrderTaskModel(), phModel));
	}
}
