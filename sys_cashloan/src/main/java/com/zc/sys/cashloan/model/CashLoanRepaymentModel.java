package com.zc.sys.cashloan.model;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.zc.sys.cashloan.constant.BaseCashLoanConstant;
import com.zc.sys.cashloan.dao.CashLoanRepaymentDao;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
import com.zc.sys.cashloan.service.CashLoanRepaymentService;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.calculate.BigDecimalUtil;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.encrypt.MD5;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.service.CommonService;
import com.zc.sys.core.manage.entity.OrderTask;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class CashLoanRepaymentModel extends CashLoanRepayment {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	/** 交易密码 **/
	private String payPwd;
	
	/** 订单信息 **/
	private OrderTask orderTask;
	/** 重复标识 **/
	private String token;

	/**
	 * 实体转换model
	 */
	public static CashLoanRepaymentModel instance(CashLoanRepayment cashLoanRepayment) {
		CashLoanRepaymentModel cashLoanRepaymentModel = new CashLoanRepaymentModel();
		BeanUtils.copyProperties(cashLoanRepayment, cashLoanRepaymentModel);
		return cashLoanRepaymentModel;
	}

	/**
	 * model转换实体
	 */
	public CashLoanRepayment prototype() {
		CashLoanRepayment cashLoanRepayment = new CashLoanRepayment();
		BeanUtils.copyProperties(this, cashLoanRepayment);
		return cashLoanRepayment;
	}
	
	/**
	 * 现金贷还款处理
	 */
	public void doQueue() {
		CashLoanRepaymentService cashLoanRepaymentService = BeanUtil.getBean(CashLoanRepaymentService.class);
		if(this.orderTask.getType().equals("cashLoanRepayment")){
			cashLoanRepaymentService.cashLoanRepaymentDeal(this);
		}
	}
	

	/**
	 * 校验还款信息
	 * @param cashLoanRepaymet
	 */
	public CashLoanRepayment checkRepayment() {
		CommonService commonService = BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		CashLoanRepaymentDao cashLoanRepaymentDao = BeanUtil.getBean(CashLoanRepaymentDao.class);
		if(this.getId() <= 0 || StringUtil.isBlank(this.getPeriod())){
			throw new BusinessException("参数错误");
		}
		CashLoanRepayment cashLoanRepayment = cashLoanRepaymentDao.find(this.getId());
		if(cashLoanRepayment == null){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getUser().getPayPwd()) || MD5.toMD5(this.payPwd).equals(cashLoanRepayment.getUser().getPayPwd())){
			throw new BusinessException("交易密码输入错误或未设置");
		}
		if(cashLoanRepayment.getCashLoan().getState() != BaseCashLoanConstant.CASHLOAN_STATE_REPAYMENTING 
				&& cashLoanRepayment.getCashLoan().getState() != BaseCashLoanConstant.CASHLOAN_STATE_OVERDUE){
			throw new BusinessException("还款状态有误");
		}
		//当前期是否最近期还款
		boolean isCurrentRepayment = cashLoanRepaymentDao.isCurrentRepayment(cashLoanRepayment.getPeriod(), cashLoanRepayment.getCashLoan().getId());
		if(!isCurrentRepayment){
			throw new BusinessException("操作失败，上期还未还款");
		}
		if(this.getRepaymentWay() == null || this.getRepaymentWay() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getRepaymentAccount())){
			throw new BusinessException("参数错误");
		}
		return cashLoanRepayment;
	}

	/**
	 * 初始化还款信息
	 * @param cashLoanRepaymet
	 */
	public void initRepayment(CashLoanRepayment cashLoanRepaymet) {
		cashLoanRepaymet.setState(BaseConstant.BUSINESS_STATE_WAIT);
	}
	
	/**
	 * 校验还款处理
	 * @param cashLoanRepayment
	 */
	public void checkDetail(CashLoanRepayment cashLoanRepayment) {
		if(cashLoanRepayment.getState() != BaseConstant.BUSINESS_STATE_WAIT){
			throw new BusinessException("还款状态有误");
		}
	}

	/**
	 * 初始化信息
	 * @param cashLoanRepayment
	 */
	public void initDetail(CashLoanRepayment cashLoanRepayment) {
		double curCapital = cashLoanRepayment.getRepaymentCapital();//本金
		double curInterest = cashLoanRepayment.getRepaymentInterest();//利息
		double curServiceFee = cashLoanRepayment.getRepaymentServiceFee();//服务费
		double curOverdueInterest = cashLoanRepayment.getOverdueInterest();//逾期利息
		double curTotal = cashLoanRepayment.getRepaymentTotal();//总额
		Date repaymentTime = DateUtil.getNow();//还款时间
		String orderNo = StringUtil.getSerialNumber();//还款订单号
		int repaymentWay = this.getRepaymentWay();//还款方式
		String repaymentAccount = this.getRepaymentAccount();//还款账户
		
		CashLoan cashLoan = cashLoanRepayment.getCashLoan();
		cashLoan.setRepaidCapital(BigDecimalUtil.add(cashLoan.getRepaidCapital(),curCapital));
		cashLoan.setRepaidInterest(BigDecimalUtil.add(cashLoan.getRepaidInterest(),curInterest));
		cashLoan.setRepaidServiceFee(BigDecimalUtil.add(cashLoan.getRepaidServiceFee(),curServiceFee));
		cashLoan.setRepaidOverdueInterest(BigDecimalUtil.add(cashLoan.getRepaidCapital(),curOverdueInterest));
		cashLoan.setRepaidTotal(BigDecimalUtil.add(cashLoan.getRepaidTotal(),curTotal));
		cashLoanRepayment.setCashLoan(cashLoan);
		
		
		cashLoanRepayment.setRepaidCapital(BigDecimalUtil.add(cashLoanRepayment.getRepaidCapital(),curCapital));
		cashLoanRepayment.setRepaidInterest(BigDecimalUtil.add(cashLoanRepayment.getRepaidInterest(),curInterest));
		cashLoanRepayment.setRepaidServiceFee(BigDecimalUtil.add(cashLoanRepayment.getRepaidServiceFee(),curServiceFee));
		cashLoanRepayment.setRepaidOverdueInterest(BigDecimalUtil.add(cashLoanRepayment.getRepaidCapital(),curOverdueInterest));
		cashLoanRepayment.setRepaidTotal(BigDecimalUtil.add(cashLoanRepayment.getRepaidTotal(),curTotal));
		cashLoanRepayment.setRepaymentTime(repaymentTime);
		cashLoanRepayment.setOrderNo(orderNo);
		cashLoanRepayment.setRepaymentWay(repaymentWay);
		cashLoanRepayment.setRepaymentAccount(repaymentAccount);
		cashLoanRepayment.setState(BaseConstant.BUSINESS_STATE_YES);
	}

	/** 获取【当前页码】 **/
	public int getPageNo() {
		return pageNo;
	}

	/** 设置【当前页码】 **/
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/** 获取【每页数据条数】 **/
	public int getPageSize() {
		return pageSize;
	}

	/** 设置【每页数据条数】 **/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 获取【条件查询】 **/
	public String getSearchName() {
		return searchName;
	}

	/** 设置【条件查询】 **/
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/** 获取【订单信息】 **/
	public OrderTask getOrderTask() {
		return orderTask;
	}

	/** 设置【订单信息】 **/
	public void setOrderTask(OrderTask orderTask) {
		this.orderTask = orderTask;
	}

	/** 获取【交易密码】 **/
	public String getPayPwd() {
		return payPwd;
	}

	/** 设置【交易密码】 **/
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	/** 获取【重复标识】 **/
	public String getToken() {
		return token;
	}

	/** 设置【重复标识】 **/
	public void setToken(String token) {
		this.token = token;
	}
}