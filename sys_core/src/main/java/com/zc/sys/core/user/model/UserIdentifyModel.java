package com.zc.sys.core.user.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.service.CommonService;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.sys.entity.Menu;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.dao.UserInfoDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.entity.UserIdentify;
import com.zc.sys.core.user.entity.UserInfo;
import com.zc.sys.core.user.service.UserIdentifyService;
import com.zc.sys.core.xc.model.SiteModel;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class UserIdentifyModel extends UserIdentify {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	/** 姓名 **/
	private String realName;
	/** 证件号码 **/
	private String cardNo;
	/** 证件类型 **/
	private int cardType;
	/** 手机号 **/
	private String mobile;
	
	/** 订单 **/
	private OrderTask orderTask;
	/** 重复标识 **/
	private String token;
	/** UserModel **/
	private UserModel userModel;

	public UserIdentifyModel() {
		super();
	}

	public UserIdentifyModel(String mobile) {
		this.setMobile(mobile);
	}

	/**
	 * 实体转换model
	 */
	public static UserIdentifyModel instance(UserIdentify userIdentify) {
		UserIdentifyModel userIdentifyModel = new UserIdentifyModel();
		BeanUtils.copyProperties(userIdentify, userIdentifyModel);
		return userIdentifyModel;
	}

	/**
	 * model转换实体
	 */
	public UserIdentify prototype() {
		UserIdentify userIdentify = new UserIdentify();
		BeanUtils.copyProperties(this, userIdentify);
		return userIdentify;
	}
	/**
	 * 设置修改基本参数
	 * @param menu
	 */
	public void setUpdateParam(UserIdentify userIdentify) {
		userIdentify.setEmailState(this.getEmailState());
		userIdentify.setCardImgState(this.getCardImgState());
		userIdentify.seteSignState(this.geteSignState());
		userIdentify.setMobileState(this.getMobileState());
		userIdentify.setRealNameState(this.getRealNameState());
		userIdentify.setState(this.getState());
		userIdentify.setLoginFailCount(this.getLoginFailCount());
		userIdentify.setOctopusState(this.getOctopusState());
		userIdentify.setRealNameCount(this.getRealNameCount());
		userIdentify.setBindCardNum(this.getBindCardNum());
		userIdentify.setUser(this.getUser());
	}

	/**
	 * 初始化注册用户认证信息
	 * @param model
	 */
	public void initReg(UserModel model) {
		this.setRealNameState(0);
		this.setEmailState(0);
		if(model.getMobileState() == 0){
			model.setMobileState(0);
		}
		this.setMobileState(1);
		this.setBindCardNum(0);
		this.setRealNameCount(0);
		this.setCardImgState(0);
		this.setOctopusState(0);
		this.setState(1);//启用状态
		this.setLoginFailCount(0);
		this.seteSignState(0);
	}
	
	/**
	 * 实名信息校验
	 */
	public void checkRealName() {
		CommonService commonService = (CommonService)BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		if(this.getUser() == null || this.getUser().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.realName)){
			throw new BusinessException("实名信息不能为空");
		}
		if(this.cardType <= 0){
			throw new BusinessException("参数错误");
		}
		this.checkCard(this.cardType,this.cardNo);//证件格式校验
		this.checkCardNoExist(this.cardNo);//判断证件号是否存在
		
	}
	
	/**
	 * 判断证件号是否存在
	 * @param cardNo
	 * @return
	 */
	public boolean checkCardNoExist(String cardNo){
		UserIdentifyDao userIdentifyDao = BeanUtil.getBean(UserIdentifyDao.class);
		UserIdentifyModel userIdentifyModel = new UserIdentifyModel();
		userIdentifyModel.setCardNo(cardNo);
		userIdentifyModel.setRealNameState(BaseConstant.IDENTIFY_STATE_YES);
		int count = userIdentifyDao.countByModel(userIdentifyModel);
		return count > 0 ? true : false;
	}
	
	/**
	 * 证件格式校验
	 */
	public void checkCard(int cardType,String cardNo){
		switch (this.cardType) {
		case 1://二代身份证
			if(!StringUtil.isCard(cardNo)){
				throw new BusinessException("证件格式错误");
			};
			break;
		default:
			throw new BusinessException("参数有误");
		}
	}
	
	/**
	 * 初始化实名认证
	 * @param userIdentify
	 */
	public void initRealName(UserIdentify userIdentify) {
		userIdentify.setRealNameCount(userIdentify.getRealNameCount() + 1);//认证次数+1
		userIdentify.setRealNameState(BaseConstant.BUSINESS_STATE_YES);
		
		User user = userIdentify.getUser();
		user.setRealName(this.getRealName());
		
		UserInfoDao userInfoDao = (UserInfoDao)BeanUtil.getBean(UserInfoDao.class);
		UserInfo userInfo = userInfoDao.findObjByProperty("user.id", user.getId());
		userInfo.setCardType(this.getCardType());
		userInfoDao.update(userInfo);
		userIdentify.setUser(user);
	}
	
	/**
	 * 任务分发
	 */
	public void doQueue(){
		UserIdentifyService userIdentifyService = (UserIdentifyService)BeanUtil.getBean(UserIdentifyService.class);
		if(this.orderTask.getType().equals("realName")){
			userIdentifyService.realNameDeal(this);
		}
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

	/** 获取【姓名】 **/
	public String getRealName() {
		return realName;
	}

	/** 设置【姓名】 **/
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/** 获取【证件号码】 **/
	public String getCardNo() {
		return cardNo;
	}

	/** 设置【证件号码】 **/
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/** 获取【证件类型】 **/
	public int getCardType() {
		return cardType;
	}

	/** 设置【证件类型】 **/
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	/** 获取【订单】 **/
	public OrderTask getOrderTask() {
		return orderTask;
	}

	/** 设置【订单】 **/
	public void setOrderTask(OrderTask orderTask) {
		this.orderTask = orderTask;
	}

	/** 获取【手机号】 **/
	public String getMobile() {
		return mobile;
	}

	/** 设置【手机号】 **/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/** 获取【重复标识】 **/
	public String getToken() {
		return token;
	}

	/** 设置【重复标识】 **/
	public void setToken(String token) {
		this.token = token;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

}