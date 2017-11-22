package com.zc.sys.core.common.service;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.common.model.CommonModel;

/**
 * 公共接口
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
public interface CommonService {

	/**
 	 * 生成唯一请求标识
 	 * @param model
 	 * @return
 	 */
	Result getToken();

	/**
	 * 校验token
	 * @param token
	 * @return
	 */
	void checkToken(String token);

	/**
	 * 发送短信验证码
	 * @param model
	 * @return
	 */
	Result getMobileCode(CommonModel model);

	/**
	 * 校验短信验证码
	 * @param mobile
	 * @param code
	 * @return
	 */
	void checkMobileCode(String mobile,String code,int handleSmsType);

	/**
	 * 利息计算器
	 * @param model
	 * @return
	 */
	void calculator(CommonModel model);

	
}
