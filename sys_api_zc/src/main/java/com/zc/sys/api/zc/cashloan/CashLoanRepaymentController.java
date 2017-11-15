package com.zc.sys.api.zc.cashloan;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
import com.zc.sys.cashloan.service.CashLoanRepaymentService;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/cl/cashloanrepayment")
public class CashLoanRepaymentController extends BaseController<CashLoanRepaymentModel> {

	@Resource
	CashLoanRepaymentService cashLoanRepaymentService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(CashLoanRepaymentModel model) throws BussinessException {
		return cashLoanRepaymentService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(CashLoanRepaymentModel model) throws BussinessException {
		return cashLoanRepaymentService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(CashLoanRepaymentModel model) throws BussinessException {
		return cashLoanRepaymentService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(CashLoanRepaymentModel model) throws BussinessException {
		return cashLoanRepaymentService.getById(model);
	}
}