package com.zc.sys.api.zc.integral;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.integral.model.IntegralAccountModel;
import com.zc.sys.core.integral.service.IntegralAccountService;
/**
 * 积分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/jf/integralaccount")
public class IntegralAccountController extends BaseController<IntegralAccountModel> {

	@Resource
	IntegralAccountService integralAccountService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(IntegralAccountModel model) throws BusinessException {
		return integralAccountService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(IntegralAccountModel model) throws BusinessException {
		return integralAccountService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(IntegralAccountModel model) throws BusinessException {
		return integralAccountService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(IntegralAccountModel model) throws BusinessException {
		return integralAccountService.getById(model);
	}
}