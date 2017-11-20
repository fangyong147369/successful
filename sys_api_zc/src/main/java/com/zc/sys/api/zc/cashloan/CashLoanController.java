package com.zc.sys.api.zc.cashloan;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.cashloan.model.CashLoanModel;
import com.zc.sys.cashloan.service.CashLoanService;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/cl/cashloan")
public class CashLoanController extends BaseController<CashLoanModel> {

	@Resource
	CashLoanService cashLoanService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(CashLoanModel model) throws BussinessException {
		return cashLoanService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(CashLoanModel model) throws BussinessException {
		return cashLoanService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(CashLoanModel model) throws BussinessException {
		return cashLoanService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(CashLoanModel model) throws BussinessException {
		return cashLoanService.getById(model);
	}
	
	/**
	 * 借款申请
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/cashLoan", method = RequestMethod.POST)
	@ResponseBody
	public Object cashLoan(CashLoanModel model) throws BussinessException {
		return cashLoanService.cashLoanRequest(model);
	}
}