package com.zc.sys.cashloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.cashloan.dao.CashLoanDao;
import com.zc.sys.cashloan.dao.CashLoanRepaymentDao;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.executer.CashLoanLoanExecuter;
import com.zc.sys.cashloan.model.CashLoanModel;
import com.zc.sys.cashloan.service.CashLoanService;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.global.Global;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.manage.service.OrderTaskService;

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
	private CashLoanRepaymentDao cashLoanRepaymentDao;

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
	@Transactional
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
	@Transactional
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
		model.setId(cashLoan.getId());
		
		String orderNo = StringUtil.getSerialNumber();//请求流水
		
		//是否自动审核贷款
		if(Global.getInt("isCashLoanAutoAudit") == 1){
			//发送队列
			QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
			OrderTaskService orderTaskService = BeanUtil.getBean(OrderTaskService.class);
			OrderTask orderTask = orderTaskService.add(model.getUser(), "cashLoanAudit", orderNo, "");
			model.setOrderTask(orderTask);
			model.setRemark("自动审核通过");
			queueService.send(new QueueModel("cashLoan", OrderTaskModel.instance(orderTask), model));
		}
		return Result.success("借款处理中...请稍后！").setData(orderNo);
	}
	
	/**
	 * 现金贷款管理员审核
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result cashLoanAudit(CashLoanModel model){
		CashLoan cashLoan = model.checkAudit();
		model = CashLoanModel.instance(cashLoan);
		model.setRemark(model.getRemark());
		//发送队列
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTaskService orderTaskService = BeanUtil.getBean(OrderTaskService.class);
		OrderTask orderTask = orderTaskService.add(cashLoan.getUser(), "cashLoanAudit", StringUtil.getSerialNumber(), "");
		model.setOrderTask(orderTask);
		queueService.send(new QueueModel("cashLoan", OrderTaskModel.instance(orderTask), model));
		return Result.success("借款审核中...请稍后！").setData(orderTask.getOrderNo());
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
		CashLoan cashLoan = cashLoanDao.find(model.getId());
		model.initAudit(cashLoan);
		cashLoanDao.update(cashLoan);
		
		//订单处理
		OrderTaskService orderTaskService = BeanUtil.getBean(OrderTaskService.class);
		orderTaskService.update(model.getOrderTask(), BaseConstant.BUSINESS_STATE_YES, "现金贷款审核成功");
		
		//放款--是否自动放款
		if(Global.getInt("isCashLoanAutoLoan") == 1){
			//发送队列
			QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
			OrderTask orderTaskLoan =orderTaskService.add(cashLoan.getUser(), "cashLoanLoan", StringUtil.getSerialNumber(), "");
			CashLoanModel modelLoan = CashLoanModel.instance(cashLoan);
			modelLoan.setOrderTask(orderTaskLoan);
			queueService.send(new QueueModel("cashLoan", OrderTaskModel.instance(orderTaskLoan), modelLoan));
		}
		return Result.success();
	}
	
	/**
	 * 手动放款
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result cashLoanLoanHandle(CashLoanModel model){
		CashLoan cashLoan =model.checkLoanHandle();
		
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTaskService orderTaskService = BeanUtil.getBean(OrderTaskService.class);
		OrderTask orderTaskLoan = orderTaskService.add(cashLoan.getUser(), "cashLoanLoan", StringUtil.getSerialNumber(), "");
		model.setOrderTask(orderTaskLoan);
		queueService.send(new QueueModel("cashLoan", OrderTaskModel.instance(orderTaskLoan), model));
		return Result.success("放款处理中...请稍后!").setData(orderTaskLoan.getOrderNo());
	}

	/**
 	 * 现金贷款放款处理
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result cashLoanLoan(CashLoanModel model) {
		model.checkLoan();
		CashLoan cashLoan = cashLoanDao.find(model.getId());
		model.initLoan(cashLoan);
		cashLoanDao.update(cashLoan);
		
		//生成还款计划
		cashLoanRepaymentDao.save(model.createRepayments(cashLoan));
		
		//放款到账户
		
		//订单处理
		OrderTaskService orderTaskService = BeanUtil.getBean(OrderTaskService.class);
		orderTaskService.update(model.getOrderTask(), BaseConstant.BUSINESS_STATE_YES, "现金贷款放款成功");
		
		//现金贷放款成功任务
		Executer cashLoanLoanExecuter = BeanUtil.getBean(CashLoanLoanExecuter.class);
		cashLoanLoanExecuter.execute(model);
		return Result.success();
	}

}