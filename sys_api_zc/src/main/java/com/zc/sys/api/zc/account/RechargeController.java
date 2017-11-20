package com.zc.sys.api.zc.account;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.account.model.RechargeModel;
import com.zc.sys.core.account.service.RechargeService;
import com.zc.sys.core.common.web.BaseController;
/**
 * 充值
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/acc/recharge")
public class RechargeController extends BaseController<RechargeModel> {

	@Resource
	RechargeService rechargeService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(RechargeModel model) throws BusinessException {
		return rechargeService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(RechargeModel model) throws BusinessException {
		return rechargeService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(RechargeModel model) throws BusinessException {
		return rechargeService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(RechargeModel model) throws BusinessException {
		return rechargeService.getById(model);
	}
}