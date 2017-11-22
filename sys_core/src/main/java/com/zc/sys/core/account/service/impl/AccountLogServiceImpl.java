package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.account.dao.AccountLogDao;
import com.zc.sys.core.account.model.AccountLogModel;
import com.zc.sys.core.account.service.AccountLogService;
/**
 * 资金日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AccountLogServiceImpl implements AccountLogService {

	@Resource
	private AccountLogDao accountLogDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AccountLogModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(AccountLogModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(AccountLogModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AccountLogModel model){

		return null;
	}

}