package com.zc.sys.cashloan.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.cashloan.dao.CashLoanRepaymentDao;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
import com.zc.sys.cashloan.service.CashLoanRepaymentService;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class CashLoanRepaymentServiceImpl implements CashLoanRepaymentService {

	@Resource
	private CashLoanRepaymentDao cashLoanRepaymentDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(CashLoanRepaymentModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(CashLoanRepaymentModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(CashLoanRepaymentModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(CashLoanRepaymentModel model){

		return null;
	}

}