package com.zc.sys.api.zc.cashloan;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zc.sys.cashloan.model.CashLoanConfigModel;
import com.zc.sys.cashloan.service.CashLoanConfigService;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
/**
 * 现金贷产品配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月22日
 */
@RestController
@RequestMapping("/cl/cashloanconfig")
public class CashLoanConfigController extends BaseController<CashLoanConfigModel> {

	@Resource
	CashLoanConfigService cashLoanConfigService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(CashLoanConfigModel model) throws BusinessException {
		return cashLoanConfigService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(CashLoanConfigModel model) throws BusinessException {
		return cashLoanConfigService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(CashLoanConfigModel model) throws BusinessException {
		return cashLoanConfigService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(CashLoanConfigModel model) throws BusinessException {
		return cashLoanConfigService.getById(model);
	}
}