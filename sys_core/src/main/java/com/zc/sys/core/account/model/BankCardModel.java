package com.zc.sys.core.account.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.calculate.BigDecimalUtil;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.http.RequestUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.account.entity.BankCard;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.entity.UserIdentify;
/**
 * 银行卡
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class BankCardModel extends BankCard {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	/** 用户id **/
	private Integer userId;
	
	/** 订单信息 **/
	private OrderTask orderTask;

	/**
	 * 实体转换model
	 */
	public static BankCardModel instance(BankCard bankCard) {
		BankCardModel bankCardModel = new BankCardModel();
		BeanUtils.copyProperties(bankCard, bankCardModel);
		return bankCardModel;
	}

	/**
	 * model转换实体
	 */
	public BankCard prototype() {
		BankCard bankCard = new BankCard();
		BeanUtils.copyProperties(this, bankCard);
		return bankCard;
	}

	/**
	 * 绑卡校验
	 */
	public void checkBindBC() {
		UserIdentifyDao userIdentifyDao = (UserIdentifyDao)BeanUtil.getBean(UserIdentifyDao.class);
		User user = this.getUser();
		if(user == null || user.getId() == null || user.getId().longValue() <= 0){
			throw new BusinessException("参数错误");
		}
		UserIdentify userIdentify = userIdentifyDao.findObjByProperty("user.id", user.getId());
		this.setUser(userIdentify.getUser());
		if(userIdentify.getState() != 1){
			throw new BusinessException("用户状态异常");
		}
		if(userIdentify.getRealNameState() != 1){
			throw new BusinessException("请先实名认证");
		}
		if(userIdentify.getMobileState() != 1){
			throw new BusinessException("请先手机认证");
		}
		/*if(userIdentify.getOctopusState() != 1){
			throw new BussinessException("请先认证手机号运行商信息");
		}*/
		if(StringUtil.isBlank(this.getBankCardNo())){
			throw new BusinessException("请输入银行卡账号");
		}
		if(StringUtil.isBlank(this.getMobile()) || !StringUtil.isPhone(this.getMobile())){
			throw new BusinessException("请输入正确的银行卡预留手机号");
		}
		if(StringUtil.isBlank(this.getBankCode())){
			throw new BusinessException("请输入所属银行卡编码");
		}
	}
	
	/**
	 * 初始化
	 */
	public void initBind() {
		UserDao userDao = (UserDao)BeanUtil.getBean(UserDao.class);
		this.setState(BaseConstant.BUSINESS_STATE_WAIT);//绑卡处理中
		User user = (User) userDao.findObjByProperty("id",this.getUser().getId());
		this.setUser(user);
		this.setAddIp(RequestUtil.getClientIp());
		this.setAddTime(DateUtil.getNow());
		this.setAmount(BigDecimalUtil.round(0));
		this.setAutoDeduct(0);
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

	/** 获取【用户id】 **/
	public Integer getUserId() {
		return userId.intValue();
	}

	/** 设置【用户id】 **/
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/** 获取【订单信息】 **/
	public OrderTask getOrderTask() {
		return orderTask;
	}

	/** 设置【订单信息】 **/
	public void setOrderTask(OrderTask orderTask) {
		this.orderTask = orderTask;
	}

}