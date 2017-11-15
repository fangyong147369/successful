package com.zc.sys.cashloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.cashloan.dao.CashLoanDao;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.model.CashLoanModel;
import com.zc.sys.cashloan.service.CashLoanService;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.common.util.BeanUtil;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;

/**
 * 现金贷借款
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class CashLoanServiceImpl implements CashLoanService {

	@Resource
	private CashLoanDao cashLoanDao;
	@Resource
	private OrderTaskDao orderTaskDao;

	/**
	 * 列表
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public Result list(CashLoanModel model) {
		PageDataList<CashLoan> pageDataList = cashLoanDao.list(model);
		PageDataList<CashLoanModel> pageDataList_ = new PageDataList<CashLoanModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<CashLoanModel> list = new ArrayList<CashLoanModel>();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (CashLoan cashLoan : pageDataList.getList()) {
				CashLoanModel model_ = CashLoanModel.instance(cashLoan);
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
	 * 添加
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public Result add(CashLoanModel model) {

		return null;
	}

	/**
	 * 修改
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public Result update(CashLoanModel model) {

		return null;
	}

	/**
	 * 获取
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public Result getById(CashLoanModel model) {

		return null;
	}

	/**
	 * 现金贷款请求
	 * 
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result cashLoanRequest(CashLoanModel model) {
		model.checkCashLoan();// 贷款校验
		model.initCashLoan();// 初始化贷款
		CashLoan cashLoan = model.prototype();
		cashLoanDao.save(cashLoan);

		//发送队列处理实名
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(model.getUser(), "cashLoan",
				model.getCno(), 2, "", DateUtil.getNow());
		orderTaskDao.save(orderTask);
		queueService.send(new QueueModel("cashLoan", orderTask, model));
		return Result.success("贷款处理中...请稍后！");
	}

	/**
	 * 现金贷款处理
	 * 
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result cashLoanDeal(CashLoanModel model) {
		OrderTask orderTask = (OrderTask) orderTaskDao.findByProperty("orderNo", model.getCno());
		if(orderTask == null || orderTask.getState() != 2){
			LogUtil.info("订单号+" + model.getCno() + "不存在，或者处理状态有误");
			return Result.error("订单号+" + model.getCno() + "不存在，或者处理状态有误");
		}
		
		//放款
		
		
		return Result.success();
	}

}