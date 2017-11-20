package com.zc.sys.api.zc.manage;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.manage.service.OrderTaskService;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/m/ordertask")
public class OrderTaskController extends BaseController<OrderTaskModel> {

	@Resource
	OrderTaskService orderTaskService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(OrderTaskModel model) throws BusinessException {
		return orderTaskService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(OrderTaskModel model) throws BusinessException {
		return orderTaskService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(OrderTaskModel model) throws BusinessException {
		return orderTaskService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(OrderTaskModel model) throws BusinessException {
		return orderTaskService.getById(model);
	}
}