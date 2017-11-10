package com.zc.sys.api.zc.account;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.account.model.WithdrawCashModel;
import com.zc.sys.core.account.service.WithdrawCashService;
import com.zc.sys.core.common.web.BaseController;
/**
 * 提现
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/acc/withdrawcash")
public class WithdrawCashController extends BaseController<WithdrawCashModel> {

	@Resource
	WithdrawCashService withdrawCashService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(WithdrawCashModel model) throws BussinessException {
		return withdrawCashService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(WithdrawCashModel model) throws BussinessException {
		return withdrawCashService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(WithdrawCashModel model) throws BussinessException {
		return withdrawCashService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(WithdrawCashModel model) throws BussinessException {
		return withdrawCashService.getById(model);
	}
}