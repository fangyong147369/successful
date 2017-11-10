package com.zc.sys.cashloan.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.cashloan.dao.CashLoanDao;
import com.zc.sys.cashloan.model.CashLoanModel;
import com.zc.sys.cashloan.service.CashLoanService;
/**
 * 现金贷借款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class CashLoanServiceImpl implements CashLoanService {

	@Resource
	private CashLoanDao cashLoanDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(CashLoanModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(CashLoanModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(CashLoanModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(CashLoanModel model){

		return null;
	}

}