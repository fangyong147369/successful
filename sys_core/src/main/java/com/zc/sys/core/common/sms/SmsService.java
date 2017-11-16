package com.zc.sys.core.common.sms;

import com.zc.sys.core.manage.model.NoticeMessageModel;

/**
 * 短信发送
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月13日
 */
public interface SmsService {

	public void sendSms(NoticeMessageModel model);
	
}
