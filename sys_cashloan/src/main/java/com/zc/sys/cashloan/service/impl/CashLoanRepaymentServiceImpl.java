package com.zc.sys.cashloan.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.cashloan.dao.CashLoanRepaymentDao;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
import com.zc.sys.cashloan.service.CashLoanRepaymentService;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class CashLoanRepaymentServiceImpl implements CashLoanRepaymentService {

	@Resource
	private CashLoanRepaymentDao cashLoanRepaymentDao;
	@Resource
	private OrderTaskDao orderTaskDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(CashLoanRepaymentModel model){
		PageDataList<CashLoanRepayment> pageDataList = cashLoanRepaymentDao.list(model);
		PageDataList<CashLoanRepaymentModel> pageDataList_ = new PageDataList<CashLoanRepaymentModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<CashLoanRepaymentModel> list = new ArrayList<CashLoanRepaymentModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (CashLoanRepayment cashLoanRepayment : pageDataList.getList()) {
				CashLoanRepaymentModel model_ = CashLoanRepaymentModel.instance(cashLoanRepayment);
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(CashLoanRepaymentModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(CashLoanRepaymentModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(CashLoanRepaymentModel model){

		return null;
	}
	
	/**
 	 * 现金贷款还款请求
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result cashLoanRepaymentRequest(CashLoanRepaymentModel model) {
		CashLoanRepayment cashLoanRepayment = new CashLoanRepayment();
		model.checkRepayment(cashLoanRepayment);//校验还款
		model.initRepayment(cashLoanRepayment);//初始化还款信息
		cashLoanRepaymentDao.update(cashLoanRepayment);
		
		//发送队列
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(cashLoanRepayment.getUser(), "cashLoanRepayment",
				StringUtil.getSerialNumber(), BaseConstant.BUSINESS_STATE_WAIT, "", DateUtil.getNow());
		orderTaskDao.save(orderTask);
		model.setOrderTask(orderTask);
		queueService.send(new QueueModel("cashLoanRepayment", OrderTaskModel.instance(orderTask), model));
		return Result.success("还款处理中...请稍后！");
	}

	/**
 	 * 现金贷款还款处理
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result cashLoanRepaymentDeal(CashLoanRepaymentModel model) {
		CashLoanRepayment cashLoanRepayment = cashLoanRepaymentDao.find(model.getId());
		model.initDetail(cashLoanRepayment);
		cashLoanRepaymentDao.update(cashLoanRepayment);
		
		//自动扣款业务
		
		return null;
	}

}