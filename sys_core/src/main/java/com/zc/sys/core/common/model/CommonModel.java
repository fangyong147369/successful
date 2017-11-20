package com.zc.sys.core.common.model;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.util.validate.StringUtil;

/**
 * 公共接口
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
public class CommonModel {

	/** 手机号 **/
	private String mobile;

	/**
	 * 短信发送校验
	 */
	public void checkSMS() {
		if(StringUtil.isBlank(mobile) || !StringUtil.isPhone(mobile)){
			throw new BusinessException("手机号不能为空");
		}
	}
	
	/** 获取【手机号】 **/
	public String getMobile() {
		return mobile;
	}

	/** 设置【手机号】 **/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
