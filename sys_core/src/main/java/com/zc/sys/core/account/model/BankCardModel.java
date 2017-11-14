package com.zc.sys.core.account.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.calculate.BigDecimalUtil;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.http.RequestUtil;
import com.zc.sys.core.account.entity.BankCard;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.entity.User;
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
	/** 订单号 **/
	private String orderNo;

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
		
	}
	
	/**
	 * 初始化
	 */
	public void initBind() {
		UserDao userDao = (UserDao)BeanUtil.getBean(UserDao.class);
		this.setState(2);//绑卡处理中
		User user = (User) userDao.findByProperty("id",this.getUserId());
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

	/** 获取【订单号】 **/
	public String getOrderNo() {
		return orderNo;
	}

	/** 设置【订单号】 **/
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}