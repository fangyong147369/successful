package com.zc.sys.core.common.executer;

/**
 * 任务基类
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface Executer {
	
	/**
	 * 初始化
	 */
	void init();
	
	/**
	 * 处理核心方法
	 */
	void execute(Object obj);
	
	/**
	 * 处理通知
	 */
	void handleNotice();
	
	/**
	 * 新增操作记录
	 */
	void addOperateLog();
	
	/**
	 * 信用分处理
	 */
	void handleCredit();

	/**
	 * 积分处理
	 */
	void handleIntegral();

	/**
	 * 添加资金记录
	 */
	void addAccountLog();

	/**
	 * 更新账户
	 */
	void handleAccount();
}
