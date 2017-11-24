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
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_U + "_user_info")
public class UserInfo extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 用户 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	/** 邀请用户 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "invite_user_id")
	private User inviteUser;
	/** 邀请码 **/
	private String inviteCode;
	/** 用户类型 **/
	private int type;
	/** 用户类别 **/
	private int userNature;
	/** 证件类型 **/
	private int cardType;
	/** 注册渠道 **/
	private int route;
	/** 推广途径 **/
	private String channel;
	/** 性别 **/
	private int sex;
	/** 头像地址 **/
	private String headImg;
	/** E签宝账户唯一标识 **/
	private String eSignAccountId;
	/** E签宝电子签章数据 **/
	private String eSignSealData;
	/** 民泰电子账号 **/
	private String elecAcct;
	/** 设备标识符 **/
	private String adIdentifier;
	/** 身份证国徽面 **/
	private String cardFg;
	/** 身份证头像面 **/
	private String cardBg;
	/** 锁定备注 **/
	private String loginLockRemark;
	/** 省 **/
	private String province;
	/** 市 **/
	private String city;
	/** 区 **/
	private String area;
	/** 居住地址 **/
	private String address;
	/** 公司名称 **/
	private String companyName;
	/** 公司类型 **/
	private int companyType;
	/** 公司证件号(企业征信代码) **/
	private String companyCardNo;
	/** 公司描述 **/
	private String companyDes;
	/** 企业法人姓名 **/
	private String legalName;
	/** 企业法人证件号 **/
	private String legalCardNo;
	/** 注册ip **/
	private String addIp;
	
	public UserInfo() {
		super();
	}
	public UserInfo(User user) {
		super();
		this.user = user;
	}
	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}
	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}
	/** 获取【邀请用户】 **/
	public User getInviteUser() {
		return inviteUser;
	}
	/** 设置【邀请用户】 **/
	public void setInviteUser(User inviteUser) {
		this.inviteUser = inviteUser;
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
	public int getType() {
		return type;
	}
	/** 设置【用户类型】 **/
	public void setType(int type) {
		this.type = type;
	}
	/** 获取【用户类别】 **/
	public int getUserNature() {
		return userNature;
	}
	/** 设置【用户类别】 **/
	public void setUserNature(int userNature) {
		this.userNature = userNature;
	}
	/** 获取【证件类型】 **/
	public int getCardType() {
		return cardType;
	}
	/** 设置【证件类型】 **/
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	/** 获取【注册渠道】 **/
	public int getRoute() {
		return route;
	}
	/** 设置【注册渠道】 **/
	public void setRoute(int route) {
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
	/** 获取【性别】 **/
	public int getSex() {
		return sex;
	}
	/** 设置【性别】 **/
	public void setSex(int sex) {
		this.sex = sex;
	}
	/** 获取【头像地址】 **/
	public String getHeadImg() {
		return headImg;
	}
	/** 设置【头像地址】 **/
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	/** 获取【E签宝账户唯一标识】 **/
	public String geteSignAccountId() {
		return eSignAccountId;
	}
	/** 设置【E签宝账户唯一标识】 **/
	public void seteSignAccountId(String eSignAccountId) {
		this.eSignAccountId = eSignAccountId;
	}
	/** 获取【民泰电子账号】 **/
	public String getElecAcct() {
		return elecAcct;
	}
	/** 设置【民泰电子账号】 **/
	public void setElecAcct(String elecAcct) {
		this.elecAcct = elecAcct;
	}
	/** 获取【设备标识符】 **/
	public String getAdIdentifier() {
		return adIdentifier;
	}
	/** 设置【设备标识符】 **/
	public void setAdIdentifier(String adIdentifier) {
		this.adIdentifier = adIdentifier;
	}
	/** 获取【身份证国徽面】 **/
	public String getCardFg() {
		return cardFg;
	}
	/** 设置【身份证国徽面】 **/
	public void setCardFg(String cardFg) {
		this.cardFg = cardFg;
	}
	/** 获取【身份证头像面】 **/
	public String getCardBg() {
		return cardBg;
	}
	/** 设置【身份证头像面】 **/
	public void setCardBg(String cardBg) {
		this.cardBg = cardBg;
	}
	/** 获取【省】 **/
	public String getProvince() {
		return province;
	}
	/** 设置【省】 **/
	public void setProvince(String province) {
		this.province = province;
	}
	/** 获取【市】 **/
	public String getCity() {
		return city;
	}
	/** 设置【市】 **/
	public void setCity(String city) {
		this.city = city;
	}
	/** 获取【区】 **/
	public String getArea() {
		return area;
	}
	/** 设置【区】 **/
	public void setArea(String area) {
		this.area = area;
	}
	/** 获取【居住地址】 **/
	public String getAddress() {
		return address;
	}
	/** 设置【居住地址】 **/
	public void setAddress(String address) {
		this.address = address;
	}
	/** 获取【公司名称】 **/
	public String getCompanyName() {
		return companyName;
	}
	/** 设置【公司名称】 **/
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/** 获取【公司类型】 **/
	public int getCompanyType() {
		return companyType;
	}
	/** 设置【公司类型】 **/
	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}
	/** 获取【公司证件号(企业征信代码)】 **/
	public String getCompanyCardNo() {
		return companyCardNo;
	}
	/** 设置【公司证件号(企业征信代码)】 **/
	public void setCompanyCardNo(String companyCardNo) {
		this.companyCardNo = companyCardNo;
	}
	/** 获取【公司描述】 **/
	public String getCompanyDes() {
		return companyDes;
	}
	/** 设置【公司描述】 **/
	public void setCompanyDes(String companyDes) {
		this.companyDes = companyDes;
	}
	/** 获取【企业法人姓名】 **/
	public String getLegalName() {
		return legalName;
	}
	/** 设置【企业法人姓名】 **/
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	/** 获取【企业法人证件号】 **/
	public String getLegalCardNo() {
		return legalCardNo;
	}
	/** 设置【企业法人证件号】 **/
	public void setLegalCardNo(String legalCardNo) {
		this.legalCardNo = legalCardNo;
	}
	/** 获取【注册ip】 **/
	public String getAddIp() {
		return addIp;
	}
	/** 设置【注册ip】 **/
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	/** 获取【E签宝电子签章数据】 **/
	public String geteSignSealData() {
		return eSignSealData;
	}
	/** 设置【E签宝电子签章数据】 **/
	public void seteSignSealData(String eSignSealData) {
		this.eSignSealData = eSignSealData;
	}
	/** 获取【锁定备注】 **/
	public String getLoginLockRemark() {
		return loginLockRemark;
	}
	/** 设置【锁定备注】 **/
	public void setLoginLockRemark(String loginLockRemark) {
		this.loginLockRemark = loginLockRemark;
	}
}