package com.zc.sys.core.manage.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.manage.service.OrderTaskService;
import com.zc.sys.core.user.entity.User;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class OrderTaskServiceImpl implements OrderTaskService {

	@Resource
	private OrderTaskDao orderTaskDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(OrderTaskModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public OrderTask add(User user,String type,String orderNo,String remark){
		OrderTask orderTaskLoan = new OrderTask(user, "cashLoanLoan",
				StringUtil.getSerialNumber(), BaseConstant.BUSINESS_STATE_WAIT, "", DateUtil.getNow());
		orderTaskDao.save(orderTaskLoan);
		return orderTaskLoan;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public void update(OrderTask orderTask,int state,String result){
		orderTask.setDoTime(DateUtil.getNow());
		orderTask.setDoResult("现金贷款审核成功");
		orderTask.setState(BaseConstant.BUSINESS_STATE_YES);
		orderTaskDao.update(orderTask);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(OrderTaskModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误");
		}
		return Result.success().setData(orderTaskDao.find(model.getId()));
	}

}