package com.zc.sys.core.account.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.user.entity.User;
/**
 * 充值
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Acc + "_recharge")
public class Recharge extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;
	/** 用户 */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	/** 操作金额 **/
	private double amount;
	/** 实际到账金额 **/
	private double arrivalAmount;
	/** 类型 **/
	private int type;
	/** 支付方式 **/
	private int way;
	/** 状态 **/
	private int state;
	/** 银行卡号 **/
	private String bankCardNo;
	/** 所属银行编码 **/
	private String bankCode;
	/** 预留手机号 **/
	private String mobile;
	/** 姓名 **/
	private String realName;
	/** 订单号 **/
	private String orderNo;
	/** 分步订单号 **/
	private String orderNoExtra;
	/** 结果描述 **/
	private String resultMsg;
	/**手续费 **/
	private String fee;
	/** 渠道 **/
	private int route;
	/** 备注 **/
	private String remark;
	/** 操作管理员 **/
	private String operateUser;
	/** 添加时间 **/
	private Date addTime;
	/** 添加ip **/
	private String addIp;
	
	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}
	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getArrivalAmount() {
		return arrivalAmount;
	}
	public void setArrivalAmount(double arrivalAmount) {
		this.arrivalAmount = arrivalAmount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getWay() {
		return way;
	}
	public void setWay(int way) {
		this.way = way;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getrealName() {
		return realName;
	}
	public void setrealName(String realName) {
		this.realName = realName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderNoExtra() {
		return orderNoExtra;
	}
	public void setOrderNoExtra(String orderNoExtra) {
		this.orderNoExtra = orderNoExtra;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public int getRoute() {
		return route;
	}
	public void setRoute(int route) {
		this.route = route;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getAddIp() {
		return addIp;
	}
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	
	
}