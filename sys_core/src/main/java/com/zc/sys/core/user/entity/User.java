package com.zc.sys.core.user.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.entity.AccountDeduct;
import com.zc.sys.core.account.entity.AccountLog;
import com.zc.sys.core.account.entity.BankCard;
import com.zc.sys.core.account.entity.Recharge;
import com.zc.sys.core.account.entity.WithdrawCash;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.xc.entity.Article;
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
	
	/** 关联 UserIdentify对象*/
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private UserIdentify userIdentify;
	
	/** 关联 Account对象*/
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private Account account;
	/** 关联 WithdrawCash对象*/
	@JsonBackReference
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<WithdrawCash> withdrawCash;
	/** 关联 Recharge对象*/
	@JsonBackReference
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<Recharge> recharge;
	/** 关联BankCard对象*/
	@JsonBackReference
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<BankCard> bankCard;
	/** 关联 AccountDeduct对象*/
	@JsonBackReference
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<AccountDeduct> accountDeduct;
	/** 关联AccountLog对象*/
	@JsonBackReference
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<AccountLog> accountLog;
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
	/** 获取【关联UserIdentify对象】 **/
	public UserIdentify getUserIdentify() {
		return userIdentify;
	}
	/** 设置【关联UserIdentify对象】 **/
	public void setUserIdentify(UserIdentify userIdentify) {
		this.userIdentify = userIdentify;
	}
	/** 获取【关联Account对象】 **/
	public Account getAccount() {
		return account;
	}
	/** 设置【关联Account对象】 **/
	public void setAccount(Account account) {
		this.account = account;
	}
	/** 获取【关联WithdrawCash对象】 **/
	public List<WithdrawCash> getWithdrawCash() {
		return withdrawCash;
	}	/** 设置【关联WithdrawCash对象】 **/
	public void setWithdrawCash(List<WithdrawCash> withdrawCash) {
		this.withdrawCash = withdrawCash;
	}/** 获取【关联Recharge对象】 **/
	public List<Recharge> getRecharge() {
		return recharge;
	}/** 设置【关联Recharge对象】 **/
	public void setRecharge(List<Recharge> recharge) {
		this.recharge = recharge;
	}/** 获取【关联BankCard对象】 **/
	public List<BankCard> getBankCard() {
		return bankCard;
	}/** 设置【关联BankCard对象】 **/
	public void setBankCard(List<BankCard> bankCard) {
		this.bankCard = bankCard;
	}/** 获取【关联AccountDeduct对象】 **/
	public List<AccountDeduct> getAccountDeduct() {
		return accountDeduct;
	}/** 设置【关联AccountDeduct对象】 **/
	public void setAccountDeduct(List<AccountDeduct> accountDeduct) {
		this.accountDeduct = accountDeduct;
	}/** 获取【关联AccountLog对象】 **/
	public List<AccountLog> getAccountLog() {
		return accountLog;
	}/** 设置【关联AccountLog对象】 **/
	public void setAccountLog(List<AccountLog> accountLog) {
		this.accountLog = accountLog;
	}
	
}