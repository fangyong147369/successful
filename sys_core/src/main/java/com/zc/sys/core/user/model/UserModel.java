package com.zc.sys.core.user.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.encrypt.MD5;
import com.zc.sys.common.util.http.RequestUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.service.CommonService;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.dao.UserIdentifyDao;
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
	/** 确认密码 **/
	private String confirmPwd;
	/** 原密码 **/
	private String oldPwd;
	/** 修改密码方式：1-修改密码，2-忘记密码 **/
	private int updatePwdWay;
	
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
	/** 短信验证码 **/
	private String mobileCode;
	/** 添加ip **/
	private String addIp;
	
	/** 订单信息 **/
	private OrderTask orderTask;
	/** 重复标识 **/
	private String token;

	public UserModel() {
		super();
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
		CommonService commonService = (CommonService)BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		String mobile = this.getMobile();
		if(!StringUtil.isPhone(mobile)){
			throw new BusinessException("请输入正确手机号");
		}
		if(this.checkMobileExist(mobile)){
			throw new BusinessException("该手机号已存在");
		}
		if(StringUtil.isBlank(this.getPwd()) || StringUtil.isBlank(this.getConfirmPwd()) || !this.getPwd().equals(this.getConfirmPwd())){
			throw new BusinessException("登录密码输入有误");
		}
		//短信验证码校验
		commonService.checkMobileCode(mobile, this.getMobileCode(),BaseConstant.HANDLE_SMS_TYPE_REG);
	}
	
	/**
	 * 判断手机号是否存在
	 * @param mobile
	 * @return
	 */
	public boolean checkMobileExist(String mobile){
		UserIdentifyDao userIdentifyDao = BeanUtil.getBean(UserIdentifyDao.class);
		int count = userIdentifyDao.countByModel(new UserIdentifyModel(mobile));
		return count > 0 ? true : false;
	}
	
	/**
	 * 登录信息校验
	 */
	public void checkLogin() {
		CommonService commonService = (CommonService)BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		if(StringUtil.isBlank(this.getLoginName()) || StringUtil.isBlank(this.getPwd())){
			throw new BusinessException("登录信息不能为空");
		}
	}
	
	/**
	 * 注册初始化
	 */
	public void initReg() {
		this.setUserName(this.getMobile());//用户名默认手机号
		this.setPwd(MD5.toMD5(this.getPwd()));
		this.setAddTime(DateUtil.getNow());
		this.setAddIp(RequestUtil.getClientIp());//获取ip
	}
	
	/**
	 * 注册返回数据
	 */
	public void initReturn() {
		this.setPwd(null);
		this.setPayPwd(null);
	}

	/**
	 * 校验修改登录密码
	 */
	public User checkUpdatePwd() {
		CommonService commonService = (CommonService)BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		UserDao userDao = BeanUtil.getBean(UserDao.class);
		if(this.getId() == null || this.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getPwd()) || StringUtil.isBlank(this.getConfirmPwd()) || !this.getPwd().equals(this.getConfirmPwd())){
			throw new BusinessException("新密码输入有误");
		}
		User user = userDao.find(this.getId());
		if(user == null){
			throw new BusinessException("参数错误");
		}
		switch (this.updatePwdWay) {
		case BaseConstant.UPDATE_PWD_WAY_UPDATE://正常修改
			if(StringUtil.isBlank(this.getOldPwd()) || StringUtil.isBlank(this.getConfirmPwd()) || !MD5.toMD5(this.oldPwd).equals(user.getPwd())){
				throw new BusinessException("原密码输入有误");
			}
			break;
		case BaseConstant.UPDATE_PWD_WAY_FORGET://忘记密码
			if(StringUtil.isBlank(this.mobileCode)){
				throw new BusinessException("短信验证码不能为空");
			}
			//短信验证码校验
			commonService.checkMobileCode(user.getMobile(), this.getMobileCode(),BaseConstant.HANDLE_SMS_TYPE_PWD);
			break;
		default:
			throw new BusinessException("参数错误");
		}
		return user;
	}
	
	/**
	 * 初始化信息
	 * @param user
	 */
	public void initUpdatePwd(User user) {
		user.setPwd(MD5.toMD5(this.getPwd()));
	}
	

	/**
	 * 校验修改交易密码
	 * @return
	 */
	public User checkUpdatePayPwd() {
		CommonService commonService = (CommonService)BeanUtil.getBean(CommonService.class);
		commonService.checkToken(this.token);
		UserDao userDao = BeanUtil.getBean(UserDao.class);
		if(this.getId() == null || this.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getPayPwd()) || StringUtil.isBlank(this.getConfirmPwd()) || !this.getPayPwd().equals(this.getConfirmPwd())){
			throw new BusinessException("新密码输入有误");
		}
		User user = userDao.find(this.getId());
		if(user == null){
			throw new BusinessException("参数错误");
		}
		if(MD5.toMD5(this.getPayPwd()).equals(user.getPwd())){
			throw new BusinessException("交易密码不能和登录密码相同");
		}
		switch (this.updatePwdWay) {
		case BaseConstant.UPDATE_PWD_WAY_SET://设置
			//设置密码判断
			break;
		case BaseConstant.UPDATE_PWD_WAY_UPDATE://修改
			if(StringUtil.isBlank(this.oldPwd) || StringUtil.isBlank(this.getConfirmPwd()) || !MD5.toMD5(this.oldPwd).equals(this.getPayPwd())){
				throw new BusinessException("原交易密码输入有误");
			}
			break;
		case BaseConstant.UPDATE_PWD_WAY_FORGET://忘记密码
			if(StringUtil.isBlank(this.mobileCode)){
				throw new BusinessException("短信验证码不能为空");
			}
			//短信验证码校验
			commonService.checkMobileCode(user.getMobile(), this.getMobileCode(),BaseConstant.HANDLE_SMS_TYPE_PAYPWD);
			break;
		default:
			throw new BusinessException("参数错误");
		}
		return user;
	}

	/**
	 * 初始化信息
	 * @param user
	 */
	public void initUpdatePayPwd(User user) {
		user.setPayPwd(MD5.toMD5(this.getPayPwd()));
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
		if(type != null){
			type = type.intValue();
		}
		return type;
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
		if(userNature != null){
			userNature = userNature.intValue();
		}
		return userNature;
	}

	/** 设置【用户类别】 **/
	public void setUserNature(Integer userNature) {
		this.userNature = userNature;
	}

	/** 获取【注册渠道】 **/
	public Integer getRoute() {
		if(route != null){
			route = route.intValue();
		}
		return route;
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
		if(mobileState != null){
			mobileState = mobileState.intValue();
		}
		return mobileState;
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
		if(realNameState != null){
			realNameState = realNameState.intValue();
		}
		return realNameState;
	}

	/** 设置【认证状态】 **/
	public void setRealNameState(Integer realNameState) {
		this.realNameState = realNameState;
	}

	/** 获取【短信验证码】 **/
	public String getMobileCode() {
		return mobileCode;
	}

	/** 设置【短信验证码】 **/
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}

	/** 获取【订单信息】 **/
	public OrderTask getOrderTask() {
		return orderTask;
	}

	/** 设置【订单信息】 **/
	public void setOrderTask(OrderTask orderTask) {
		this.orderTask = orderTask;
	}

	/** 获取【添加ip】 **/
	public String getAddIp() {
		return addIp;
	}

	/** 设置【添加ip】 **/
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}

	/** 获取【确认密码】 **/
	public String getConfirmPwd() {
		return confirmPwd;
	}

	/** 设置【确认密码】 **/
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	/** 获取【原密码】 **/
	public String getOldPwd() {
		return oldPwd;
	}

	/** 设置【原密码】 **/
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	/** 获取【修改密码方式：1-修改密码，2-忘记密码】 **/
	public Integer getUpdatePwdWay() {
		return updatePwdWay;
	}

	/** 设置【修改密码方式：1-修改密码，2-忘记密码】 **/
	public void setUpdatePwdWay(Integer updatePwdWay) {
		this.updatePwdWay = updatePwdWay;
	}

	/** 设置【修改密码方式：1-修改密码，2-忘记密码】 **/
	public void setUpdatePwdWay(int updatePwdWay) {
		this.updatePwdWay = updatePwdWay;
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