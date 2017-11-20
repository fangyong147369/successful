package com.zc.sys.api.zc.manage;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.OperatorModel;
import com.zc.sys.core.manage.service.OperatorService;
/**
 * 管理员
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/m/operator")
public class OperatorController extends BaseController<OperatorModel> {

	@Resource
	OperatorService operatorService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(OperatorModel model) throws BusinessException {
		return operatorService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(OperatorModel model) throws BusinessException {
		return operatorService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(OperatorModel model) throws BusinessException {
		return operatorService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(OperatorModel model) throws BusinessException {
		return operatorService.getById(model);
	}

	/**
	 * 登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	@ResponseBody
	public Object signIn(OperatorModel model) throws BusinessException {
		return operatorService.signIn(model);
	}

}