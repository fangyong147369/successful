package com.zc.sys.core.user.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	/** 实名认证状态(现金贷包含：OCR、活体) **/
	private Integer realNameState;
	/** 邮箱认证状态 **/
	private Integer emailState;
	/** 手机号认证状态 **/
	private Integer mobileState;
	/** 绑卡数量 **/
	private Integer bindCardNum;
	/** 实名认证次数 **/
	private Integer realNameCount;
	/** 身份证图片认证状态 **/
	private Integer cardImgState;
	/** 数据魔盒-运营商-数据认证状态 **/
	private Integer octopusState;
	/** 用户状态 **/
	private Integer state;
	/** 登录失败次数 **/
	private Integer loginFailCount;
	/** e签宝印章创建状态 **/
	private Integer eSignState;
	
	
	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}
	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【实名认证状态(现金贷包含：OCR、活体)】 **/
	public Integer getRealNameState() {
		if(realNameState != null){
			return realNameState.intValue();
		}
		return realNameState;
	}
	/** 设置【实名认证状态(现金贷包含：OCR、活体)】 **/
	public void setRealNameState(Integer realNameState) {
		this.realNameState = realNameState;
	}
	/** 获取【邮箱认证状态】 **/
	public Integer getEmailState() {
		return emailState.intValue();
	}
	/** 设置【邮箱认证状态】 **/
	public void setEmailState(Integer emailState) {
		this.emailState = emailState;
	}
	/** 获取【手机号认证状态】 **/
	public Integer getMobileState() {
		return mobileState.intValue();
	}
	/** 设置【手机号认证状态】 **/
	public void setMobileState(Integer mobileState) {
		this.mobileState = mobileState;
	}
	/** 获取【绑卡数量】 **/
	public Integer getBindCardNum() {
		return bindCardNum.intValue();
	}
	/** 设置【绑卡数量】 **/
	public void setBindCardNum(Integer bindCardNum) {
		this.bindCardNum = bindCardNum;
	}
	/** 获取【实名认证次数】 **/
	public Integer getRealNameCount() {
		return realNameCount.intValue();
	}
	/** 设置【实名认证次数】 **/
	public void setRealNameCount(Integer realNameCount) {
		this.realNameCount = realNameCount;
	}
	/** 获取【身份证图片认证状态】 **/
	public Integer getCardImgState() {
		return cardImgState.intValue();
	}
	/** 设置【身份证图片认证状态】 **/
	public void setCardImgState(Integer cardImgState) {
		this.cardImgState = cardImgState;
	}
	/** 获取【数据魔盒-运营商-数据认证状态】 **/
	public Integer getOctopusState() {
		return octopusState.intValue();
	}
	/** 设置【数据魔盒-运营商-数据认证状态】 **/
	public void setOctopusState(Integer octopusState) {
		this.octopusState = octopusState;
	}
	/** 获取【用户状态】 **/
	public Integer getState() {
		return state.intValue();
	}
	/** 设置【用户状态】 **/
	public void setState(Integer state) {
		this.state = state;
	}
	/** 获取【登录失败次数】 **/
	public Integer getLoginFailCount() {
		return loginFailCount.intValue();
	}
	/** 设置【登录失败次数】 **/
	public void setLoginFailCount(Integer loginFailCount) {
		this.loginFailCount = loginFailCount;
	}
	/** 获取【e签宝印章创建状态】 **/
	public Integer geteSignState() {
		return eSignState.intValue();
	}
	/** 设置【e签宝印章创建状态】 **/
	public void seteSignState(Integer eSignState) {
		this.eSignState = eSignState;
	}
}