package com.zc.sys.core.manage.service;
import com.zc.sys.core.manage.model.NoticeMessageModel;
import com.zc.sys.common.form.Result;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
public interface NoticeMessageService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(NoticeMessageModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(NoticeMessageModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(NoticeMessageModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(NoticeMessageModel model);
	
	/**
	 * 消息发送请求
	 * @param model
	 * @return
	 */
	public void sendRequest(NoticeMessageModel model);
	
	/**
	 * 消息发送
	 * @param model
	 * @return
	 */
	public Result send(NoticeMessageModel model);

}