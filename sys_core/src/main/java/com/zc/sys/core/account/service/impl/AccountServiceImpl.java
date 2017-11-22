package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.account.dao.AccountDao;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.core.account.service.AccountService;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AccountModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(AccountModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(AccountModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AccountModel model){

		return null;
	}

}