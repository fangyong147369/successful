package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.account.dao.WithdrawCashDao;
import com.zc.sys.core.account.model.WithdrawCashModel;
import com.zc.sys.core.account.service.WithdrawCashService;
/**
 * 提现
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class WithdrawCashServiceImpl implements WithdrawCashService {

	@Resource
	private WithdrawCashDao withdrawCashDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(WithdrawCashModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(WithdrawCashModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(WithdrawCashModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(WithdrawCashModel model){

		return null;
	}

}