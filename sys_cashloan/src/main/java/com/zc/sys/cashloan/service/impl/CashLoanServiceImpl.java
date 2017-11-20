package com.zc.sys.cashloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.cashloan.dao.CashLoanDao;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.executer.CashLoanAuditExecuter;
import com.zc.sys.cashloan.executer.CashLoanLoanExecuter;
import com.zc.sys.cashloan.model.CashLoanModel;
import com.zc.sys.cashloan.service.CashLoanService;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.executer.UserRealNameExecuter;

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
		model.setId(cashLoan.getId());

		//是否自动审核贷款
		/*if(Global.getInt("isCashLoanAutoAudit") == 1){
			
		}*/
		//发送队列
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(model.getUser(), "cashLoanAudit",
				model.getCno(), 2, "", DateUtil.getNow());
		orderTaskDao.save(orderTask);
		model.setOrderTask(orderTask);
		model.setRemark("自动审核通过");
		queueService.send(new QueueModel("cashLoan", OrderTaskModel.instance(orderTask), model));
		return Result.success("借款处理中...请稍后！");
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
		model.checkAudit();
		CashLoan cashLoan = cashLoanDao.find(model.getId());
		model.initAudit(cashLoan);
		cashLoanDao.save(cashLoan);
		
		//订单处理
		OrderTask orderTask = model.getOrderTask();
		orderTask.setDoTime(DateUtil.getNow());
		orderTask.setDoResult("现金贷款审核成功");
		orderTask.setState(1);
		orderTaskDao.update(orderTask);
		
		//放款--是否自动放款
		/*if(Global.getInt("isCashLoanAutoLoan") == 1){
		
		}*/
		//发送队列
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTaskLoan = new OrderTask(cashLoan.getUser(), "cashLoanLoan",
				StringUtil.getSerialNumber(), 2, "", DateUtil.getNow());
		orderTaskDao.save(orderTaskLoan);
		CashLoanModel modelLoan = CashLoanModel.instance(cashLoan);
		modelLoan.setOrderTask(orderTaskLoan);
		queueService.send(new QueueModel("cashLoan", OrderTaskModel.instance(orderTaskLoan), modelLoan));
		
		//现金贷审核任务
		Executer cashLoanAuditExecuter = BeanUtil.getBean(CashLoanAuditExecuter.class);
		cashLoanAuditExecuter.execute(model);
		return Result.success();
	}

	/**
 	 * 现金贷款放款处理
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result cashLoanLoan(CashLoanModel model) {
		model.checkLoan();
		CashLoan cashLoan = cashLoanDao.find(model.getId());
		model.initLoan(cashLoan);
		cashLoanDao.update(cashLoan);
		
		//生成还款计划
		
		//放款到账户
		
		//订单处理
		OrderTask orderTask = model.getOrderTask();
		orderTask.setDoTime(DateUtil.getNow());
		orderTask.setDoResult("现金贷款放款成功");
		orderTask.setState(1);
		orderTaskDao.update(orderTask);
		
		//现金贷放款成功任务
		Executer cashLoanLoanExecuter = BeanUtil.getBean(CashLoanLoanExecuter.class);
		cashLoanLoanExecuter.execute(model);
		return Result.success();
	}

}