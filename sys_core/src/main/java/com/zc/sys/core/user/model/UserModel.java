package com.zc.sys.core.user.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.entity.User;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class UserModel extends User {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	/** 登录名 **/
	private String loginName;
	
	/** 邀请码 **/
	private String inviteCode;
	/** 用户类型 **/
	private Integer type;
	/** 用户类别 **/
	private Integer userNature;
	/** 注册渠道 **/
	private Integer route;
	/** 推广途径 **/
	private String channel;
	/** 用户基本信息 **/
	private UserInfoModel infoModel;
	
	/** 手机号认证状态 **/
	private Integer mobileState;
	/** 认证状态 **/
	private Integer realNameState;

	public UserModel() {
		super();
	}
	
	public UserModel(String mobile) {
		this.setMobile(mobile);
	}

	/**
	 * 实体转换model
	 */
	public static UserModel instance(User user) {
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(user, userModel);
		return userModel;
	}

	/**
	 * model转换实体
	 */
	public User prototype() {
		User user = new User();
		BeanUtils.copyProperties(this, user);
		return user;
	}
	
	/**
	 * 注册信息校验
	 */
	public void checkReg(){
		String mobile = this.getMobile();
		if(!StringUtil.isPhone(mobile)){
			throw new BussinessException("请输入正确手机号");
		}
		if(!this.checkMobileExist(mobile)){
			throw new BussinessException("该手机号已存在");
		}
		//短信验证码校验
		System.err.println("短信验证码校验");
		
		
	}
	
	/**
	 * 判断手机号是否存在
	 * @param mobile
	 * @return
	 */
	public boolean checkMobileExist(String mobile){
		UserDao userDao = BeanUtil.getBean(UserDao.class);
		int count = userDao.countByModel(new UserModel(mobile));
		return count > 0 ? true : false;
	}
	
	/**
	 * 登录信息校验
	 */
	public void checkLogin() {
		if(StringUtil.isBlank(this.getLoginName()) || StringUtil.isBlank(this.getPwd())){
			throw new BussinessException("登录信息不能为空");
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

	/** 获取【邀请码】 **/
	public String getInviteCode() {
		return inviteCode;
	}

	/** 设置【邀请码】 **/
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	/** 获取【用户类型】 **/
	public Integer getType() {
		return type.intValue();
	}

	/** 设置【用户类型】 **/
	public void setType(Integer type) {
		this.type = type;
	}

	/** 获取【用户基本信息】 **/
	public UserInfoModel getInfoModel() {
		return infoModel;
	}

	/** 设置【用户基本信息】 **/
	public void setInfoModel(UserInfoModel infoModel) {
		this.infoModel = infoModel;
	}

	/** 获取【用户类别】 **/
	public Integer getUserNature() {
		return userNature.intValue();
	}

	/** 设置【用户类别】 **/
	public void setUserNature(Integer userNature) {
		this.userNature = userNature;
	}

	/** 获取【注册渠道】 **/
	public Integer getRoute() {
		return route.intValue();
	}

	/** 设置【注册渠道】 **/
	public void setRoute(Integer route) {
		this.route = route;
	}

	/** 获取【推广途径】 **/
	public String getChannel() {
		return channel;
	}

	/** 设置【推广途径】 **/
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/** 获取【手机号认证状态】 **/
	public Integer getMobileState() {
		return mobileState.intValue();
	}

	/** 设置【手机号认证状态】 **/
	public void setMobileState(Integer mobileState) {
		this.mobileState = mobileState;
	}

	/** 获取【登录名】 **/
	public String getLoginName() {
		return loginName;
	}

	/** 设置【登录名】 **/
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/** 获取【认证状态】 **/
	public Integer getRealNameState() {
		return realNameState;
	}

	/** 设置【认证状态】 **/
	public void setRealNameState(Integer realNameState) {
		this.realNameState = realNameState;
	}

}