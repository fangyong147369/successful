package com.zc.sys.core.common.executer;

/**
 * 任务主类
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class BaseExecuter extends AbstractExecuter {

	@Override
	public void handleCredit() {

	}

	@Override
	public void handleIntegral() {

	}

	@Override
	public void addAccountLog() {

	}

	@Override
	public void handleAccount() {

	}

	@Override
	public void handleNotice() {
		// 短信
		sendSMS();
		// 邮件
		sendEmail();
		// 站内信
		sendMessage();
		// 推送
		sendAppPush();
	}

	@Override
	public void addOperateLog() {

	}

	@Override
	public void init() {

	}

	@Override
	public void sendMessage() {

	}

	@Override
	public void sendEmail() {

	}

	@Override
	public void sendSMS() {

	}

	@Override
	public void sendAppPush() {

	}

	@Override
	public void queueSend() {
		
	}

	@Override
	public void handlePromotion() {
		
	}

}
