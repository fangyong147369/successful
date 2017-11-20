package com.zc.sys.core.user.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_U + "_user")
public class User extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户名 **/
	private String userName;
	/** 登录密码 **/
	private String pwd;
	/** 交易密码 **/
	private String payPwd;
	/** 姓名 **/
	private String realName;
	/** 邮箱 **/
	private String email;
	/** 手机号 **/
	private String mobile;
	/** 证件号码 **/
	private String cardNo;
	/** 注册时间 **/
	private Date addTime;
	
	/** 关联 UserInfo对象*/
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private UserInfo userInfo;
	
	/** 获取【用户名】 **/
	public String getUserName() {
		return userName;
	}
	/** 设置【用户名】 **/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** 获取【登录密码】 **/
	public String getPwd() {
		return pwd;
	}
	/** 设置【登录密码】 **/
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/** 获取【交易密码】 **/
	public String getPayPwd() {
		return payPwd;
	}
	/** 设置【交易密码】 **/
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	/** 获取【姓名】 **/
	public String getRealName() {
		return realName;
	}
	/** 设置【姓名】 **/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/** 获取【邮箱】 **/
	public String getEmail() {
		return email;
	}
	/** 设置【邮箱】 **/
	public void setEmail(String email) {
		this.email = email;
	}
	/** 获取【手机号】 **/
	public String getMobile() {
		return mobile;
	}
	/** 设置【手机号】 **/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/** 获取【证件号码】 **/
	public String getCardNo() {
		return cardNo;
	}
	/** 设置【证件号码】 **/
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/** 获取【注册时间】 **/
	public Date getAddTime() {
		return addTime;
	}
	/** 设置【注册时间】 **/
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/** 获取【关联UserInfo对象】 **/
	public UserInfo getUserInfo() {
		return userInfo;
	}
	/** 设置【关联UserInfo对象】 **/
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}