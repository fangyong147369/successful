package com.zc.sys.cashloan.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zc.sys.cashloan.constant.BaseCashLoanConstant;
import com.zc.sys.cashloan.dao.CashLoanConfigDao;
import com.zc.sys.cashloan.dao.CashLoanDao;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.entity.CashLoanConfig;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
import com.zc.sys.cashloan.service.CashLoanService;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.encrypt.MD5;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.interest.CalculatorModel;
import com.zc.sys.core.common.model.CommonModel;
import com.zc.sys.core.common.service.CommonService;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.entity.UserIdentify;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class CashLoanModel extends CashLoan {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	/** 订单 **/
	private OrderTask orderTask;
	
	/** 交易密码 **/
	private String payPwd;
	/** 重复标识 **/
	private String token;
	/** 免息券id **/
	private long interestFreeNoteId;
	
	/**
	 * 实体转换model
	 */
	public static CashLoanModel instance(CashLoan cashLoan) {
		CashLoanModel cashLoanModel = new CashLoanModel();
		BeanUtils.copyProperties(cashLoan, cashLoanModel);
		return cashLoanModel;
	}

	/**
	 * model转换实体
	 */
	public CashLoan prototype() {
		CashLoan cashLoan = new CashLoan();
		BeanUtils.copyProperties(this, cashLoan);
		return cashLoan;
	}
	
	/**
	 * 贷款校验
	 */
	public void checkCashLoan() {
		CommonService commonService = BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		if(this.getCashLoanConfig() == null || this.getCashLoanConfig().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		CashLoanConfigDao cashLoanConfigDao = BeanUtil.getBean(CashLoanConfigDao.class);
		CashLoanConfig cashLoanConfig = cashLoanConfigDao.find(this.getCashLoanConfig().getId());
		if(cashLoanConfig == null || cashLoanConfig.getState() != BaseConstant.INFO_STATE_YES){
			throw new BusinessException("产品配置不存在");
		}
		this.setCashLoanConfig(cashLoanConfig);
		UserIdentifyDao userIdentifyDao = (UserIdentifyDao)BeanUtil.getBean(UserIdentifyDao.class);
		User user = this.getUser();
		if(user.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		UserIdentify userIdentify = userIdentifyDao.findObjByProperty("user.id", user.getId());
		this.setUser(userIdentify.getUser());
		if(userIdentify.getState() != BaseConstant.IDENTIFY_STATE_YES){
			throw new BusinessException("用户状态异常");
		}
		if(userIdentify.getRealNameState() != BaseConstant.IDENTIFY_STATE_YES){
			throw new BusinessException("请先实名认证");
		}
		if(userIdentify.getMobileState() != BaseConstant.IDENTIFY_STATE_YES){
			throw new BusinessException("请先手机认证");
		}
//		if(userIdentify.getOctopusState() != BaseConstant.IDENTIFY_STATE_YES){
//			throw new BussinessException("请先认证手机号运行商信息");
//		}
		if(userIdentify.getBindCardNum() <= 0){
			throw new BusinessException("请先绑定银行卡");
		}
		if(StringUtil.isBlank(this.getUser().getPayPwd()) || MD5.toMD5(this.payPwd).equals(this.getUser().getPayPwd())){
			throw new BusinessException("交易密码输入错误或未设置");
		}
		//免息券判断
		
		//额度校验
		if(this.getTotal() <= 0){
			throw new BusinessException("请输入正确的借款金额");
		}
		//放款账户校验
		
	}
	
	/**
	 * 初始化贷款
	 */
	public void initCashLoan() {
		this.setCno(StringUtil.getSerialNumber());
		this.setState(BaseCashLoanConstant.CASHLOAN_STATE_AUDITING);
		this.setOverdueRate(this.getCashLoanConfig().getOverdueRate());
		this.setRate(this.getCashLoanConfig().getRate());
		this.setRepaymentType(Integer.parseInt(this.getCashLoanConfig().getRepaymentType()));
		this.setIsPrepayment(this.getCashLoanConfig().getIsPrepayment());
		this.setVersion(0);
		this.setAddTime(DateUtil.getNow());
	}
	
	/**
	 * 审核信息校验
	 */
	public CashLoan checkAudit() {
		if(this.getAuditOperator() == null || this.getAuditOperator().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		CashLoanDao cashLoanDao = BeanUtil.getBean(CashLoanDao.class);
		CashLoan cashLoan = cashLoanDao.find(this.getId());
		if(cashLoan == null){
			throw new BusinessException("参数错误");
		}
		if(cashLoan.getState() != BaseCashLoanConstant.CASHLOAN_STATE_AUDITING){
			throw new BusinessException("贷款信息有误，请核实后操作");
		}
		return cashLoan;
	}
	
	/**
	 * 审核信息初始化
	 * @param cashLoan
	 */
	public void initAudit(CashLoan cashLoan) {
		cashLoan.setAuditTime(DateUtil.getNow());
		cashLoan.setRemark(this.getRemark());
		cashLoan.setState(BaseCashLoanConstant.CASHLOAN_STATE_LOANING);//审核通过
	}
	
	/**
	 * 贷款处理
	 */
	public void doQueue() {
		CashLoanService cashLoanService =BeanUtil.getBean(CashLoanService.class);
		if(this.orderTask.getType().equals("cashLoanAudit")){
			cashLoanService.cashLoanDeal(this);
		}
		if(this.orderTask.getType().equals("cashLoanLoan")){
			cashLoanService.cashLoanLoan(this);
		}
	}
	
	/**
	 * 校验放款信息
	 */
	public void checkLoan() {
		if(this.getLoanWay() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getLoanAccount())){
			throw new BusinessException("放款账号不能为空");
		}
	}
	
	/**
	 * 放款信息初始化
	 */
	public void initLoan(CashLoan cashLoan) {
		cashLoan.setLoanTime(DateUtil.getNow());
		cashLoan.setState(BaseCashLoanConstant.CASHLOAN_STATE_REPAYMENTING);//已放款-还款状态
		cashLoan.setLoanOrderNo(this.getOrderTask().getOrderNo());
	}
	
	/**
	 * 生成还款计划
	 */
	public List<CashLoanRepayment> createRepayments(CashLoan cashLoan){
		LogUtil.info("-----产生还款计划开始---- cashLoanId:"+cashLoan.getId()+"----cashLoanCno:"+cashLoan.getCno());
		CommonService commonService = BeanUtil.getBean(CommonService.class);
		List<CashLoanRepayment> repays = new ArrayList<CashLoanRepayment>();
		//计算还款计划
		CommonModel commonModel = new CommonModel(cashLoan.getPeriodUnit(), cashLoan.getPeriod(), cashLoan.getTotal(), 
				this.getRate(), DateUtil.rollDay(cashLoan.getLoanTime(), 1), cashLoan.getRepaymentType());
		commonService.calculator(commonModel);
		
		List<CalculatorModel> CalculatorModelList = commonModel.getCalculatorModelList();
		for (CalculatorModel calculatorModel : CalculatorModelList) {
			CashLoanRepayment cashLoanRepayment = new CashLoanRepayment();
			cashLoanRepayment.setAddTime(DateUtil.getNow());
			cashLoanRepayment.setCashLoan(cashLoan);
			cashLoanRepayment.setPeriod(calculatorModel.getPeriod());
			cashLoanRepayment.setRepaymentAccount(cashLoan.getLoanAccount());
			cashLoanRepayment.setRepaymentCapital(calculatorModel.getCapital());
			cashLoanRepayment.setRepaymentInterest(calculatorModel.getInterest());
//			cashLoanRepayment.setRepaymentServiceFee(repaymentServiceFee);//服务费
			cashLoanRepayment.setRepaymentTime(calculatorModel.getRepayTime());
			cashLoanRepayment.setRepaymentTotal(calculatorModel.getPeriodTotal());//本息总额
			cashLoanRepayment.setRepaymentWay(2);
			cashLoanRepayment.setState(BaseConstant.BUSINESS_STATE_NO);//还款中
			cashLoanRepayment.setUser(cashLoan.getUser());
			repays.add(cashLoanRepayment);
		}
		
		LogUtil.info("-----产生还款计划结束---- cashLoanId:"+cashLoan.getId()+"----cashLoanCno:"+cashLoan.getCno());
		return repays;
	}
	
	/**
	 * 手动放款校验
	 */
	public CashLoan checkLoanHandle() {
		if(this.getLoanOperator() == null || this.getLoanOperator().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		CashLoanDao cashLoanDao = BeanUtil.getBean(CashLoanDao.class);
		CashLoan cashLoan = cashLoanDao.find(this.getId());
		if(cashLoan == null){
			throw new BusinessException("参数错误");
		}
		if(cashLoan.getState() != BaseCashLoanConstant.CASHLOAN_STATE_LOANING){
			throw new BusinessException("贷款信息有误，请核实后操作");
		}
		return cashLoan;
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

	/** 获取【订单】 **/
	public OrderTask getOrderTask() {
		return orderTask;
	}

	/** 设置【订单】 **/
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

	/** 获取【免息券id】 **/
	public long getInterestFreeNoteId() {
		return interestFreeNoteId;
	}

	/** 设置【免息券id】 **/
	public void setInterestFreeNoteId(long interestFreeNoteId) {
		this.interestFreeNoteId = interestFreeNoteId;
	}

}