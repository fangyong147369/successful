package com.zc.sys.cashloan.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.cashloan.dao.CashLoanConfigDao;
import com.zc.sys.cashloan.model.CashLoanConfigModel;
import com.zc.sys.cashloan.service.CashLoanConfigService;
/**
 * 现金贷产品配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月22日
 */
@Service
public class CashLoanConfigServiceImpl implements CashLoanConfigService {

	@Resource
	private CashLoanConfigDao cashLoanConfigDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(CashLoanConfigModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(CashLoanConfigModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(CashLoanConfigModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(CashLoanConfigModel model){

		return null;
	}

}