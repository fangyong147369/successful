package com.zc.sys.cashloan.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.cashloan.constant.BaseCashLoanConstant;
import com.zc.sys.cashloan.entity.CashLoan;
import com.zc.sys.cashloan.service.CashLoanService;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.user.dao.UserDao;
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
		UserIdentifyDao userIdentifyDao = (UserIdentifyDao)BeanUtil.getBean(UserIdentifyDao.class);
		User user = this.getUser();
		if(user == null || user.getId() == null || user.getId().longValue() <= 0){
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
		this.setType(1);//产品类型
		this.setState(BaseCashLoanConstant.CASHLOAN_STATE_AUDITING);
		this.setOverdueRate(0.15d);
		this.setPeriodUnit(1);
		this.setPeriod(30);
		this.setRate(0.10d);
		this.setRepaymentType(1);
		this.setRepaymentTotal(1015.00d);
		this.setRepaymentCapital(1000.00d);
		this.setRepaymentInterest(10.00d);
		this.setRepaymentServiceFee(5.00d);
		this.setIsInterestFreeNote(0);
		this.setIsPrepayment(0);
		this.setVersion(0);
		this.setAddTime(DateUtil.getNow());
		this.setLoanWay(1);
		this.setLoanAccount("1111111111111111");
	}
	
	/**
	 * 审核信息校验
	 */
	public void checkAudit() {
		
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
		CashLoanService cashLoanService = (CashLoanService)BeanUtil.getBean(CashLoanService.class);
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
		if(this.getLoanWay()==null || this.getLoanWay() <= 0){
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

}