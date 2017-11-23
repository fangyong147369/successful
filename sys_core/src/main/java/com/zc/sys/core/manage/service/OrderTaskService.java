package com.zc.sys.core.manage.service;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.common.form.Result;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface OrderTaskService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(OrderTaskModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public OrderTask add(User user,String type,String orderNo,String remark);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public void update(OrderTask orderTask,int state,String result);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(OrderTaskModel model);

}