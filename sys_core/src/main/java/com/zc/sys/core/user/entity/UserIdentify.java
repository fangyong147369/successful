package com.zc.sys.core.user.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_U + "_user_identify")
public class UserIdentify extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户 */
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	/** 实名认证状态(现金贷包含：OCR、活体) **/
	private int realNameState;
	/** 邮箱认证状态 **/
	private int emailState;
	/** 手机号认证状态 **/
	private int mobileState;
	/** 绑卡数量 **/
	private int bindCardNum;
	/** 实名认证次数 **/
	private int realNameCount;
	/** 身份证图片认证状态 **/
	private int cardImgState;
	/** 数据魔盒-运营商-数据认证状态 **/
	private int octopusState;
	/** 用户状态 **/
	private int state;
	/** 登录失败次数 **/
	private int loginFailCount;
	/** e签宝印章创建状态 **/
	private int eSignState;
	
	
	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}
	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【实名认证状态(现金贷包含：OCR、活体)】 **/
	public int getRealNameState() {
		return realNameState;
	}
	/** 设置【实名认证状态(现金贷包含：OCR、活体)】 **/
	public void setRealNameState(int realNameState) {
		this.realNameState = realNameState;
	}
	/** 获取【邮箱认证状态】 **/
	public int getEmailState() {
		return emailState;
	}
	/** 设置【邮箱认证状态】 **/
	public void setEmailState(int emailState) {
		this.emailState = emailState;
	}
	/** 获取【手机号认证状态】 **/
	public int getMobileState() {
		return mobileState;
	}
	/** 设置【手机号认证状态】 **/
	public void setMobileState(int mobileState) {
		this.mobileState = mobileState;
	}
	/** 获取【绑卡数量】 **/
	public int getBindCardNum() {
		return bindCardNum;
	}
	/** 设置【绑卡数量】 **/
	public void setBindCardNum(int bindCardNum) {
		this.bindCardNum = bindCardNum;
	}
	/** 获取【实名认证次数】 **/
	public int getRealNameCount() {
		return realNameCount;
	}
	/** 设置【实名认证次数】 **/
	public void setRealNameCount(int realNameCount) {
		this.realNameCount = realNameCount;
	}
	/** 获取【身份证图片认证状态】 **/
	public int getCardImgState() {
		return cardImgState;
	}
	/** 设置【身份证图片认证状态】 **/
	public void setCardImgState(int cardImgState) {
		this.cardImgState = cardImgState;
	}
	/** 获取【数据魔盒-运营商-数据认证状态】 **/
	public int getOctopusState() {
		return octopusState;
	}
	/** 设置【数据魔盒-运营商-数据认证状态】 **/
	public void setOctopusState(int octopusState) {
		this.octopusState = octopusState;
	}
	/** 获取【用户状态】 **/
	public int getState() {
		return state;
	}
	/** 设置【用户状态】 **/
	public void setState(int state) {
		this.state = state;
	}
	/** 获取【登录失败次数】 **/
	public int getLoginFailCount() {
		return loginFailCount;
	}
	/** 设置【登录失败次数】 **/
	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}
	/** 获取【e签宝印章创建状态】 **/
	public int geteSignState() {
		return eSignState;
	}
	/** 设置【e签宝印章创建状态】 **/
	public void seteSignState(int eSignState) {
		this.eSignState = eSignState;
	}
}