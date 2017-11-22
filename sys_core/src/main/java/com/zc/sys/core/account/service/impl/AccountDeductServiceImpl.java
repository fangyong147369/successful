package com.zc.sys.core.account.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.account.dao.AccountDeductDao;
import com.zc.sys.core.account.model.AccountDeductModel;
import com.zc.sys.core.account.service.AccountDeductService;
/**
 * 线下扣款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AccountDeductServiceImpl implements AccountDeductService {

	@Resource
	private AccountDeductDao accountDeductDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AccountDeductModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(AccountDeductModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(AccountDeductModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AccountDeductModel model){

		return null;
	}

}