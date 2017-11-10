package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.account.dao.BankCardDao;
import com.zc.sys.core.account.model.BankCardModel;
import com.zc.sys.core.account.service.BankCardService;
/**
 * 银行卡
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class BankCardServiceImpl implements BankCardService {

	@Resource
	private BankCardDao bankCardDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(BankCardModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(BankCardModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(BankCardModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(BankCardModel model){

		return null;
	}

}