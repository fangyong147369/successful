package com.zc.sys.api.zc.account;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.account.model.AccountDeductModel;
import com.zc.sys.core.account.service.AccountDeductService;
import com.zc.sys.core.common.web.BaseController;
/**
 * 线下扣款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/acc/accountdeduct")
public class AccountDeductController extends BaseController<AccountDeductModel> {

	@Resource
	AccountDeductService accountDeductService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(AccountDeductModel model) throws BusinessException {
		return accountDeductService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(AccountDeductModel model) throws BusinessException {
		return accountDeductService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(AccountDeductModel model) throws BusinessException {
		return accountDeductService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(AccountDeductModel model) throws BusinessException {
		return accountDeductService.getById(model);
	}
}