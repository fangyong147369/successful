package com.zc.sys.core.integral.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.integral.dao.IntegralAccountDao;
import com.zc.sys.core.integral.model.IntegralAccountModel;
import com.zc.sys.core.integral.service.IntegralAccountService;
/**
 * 积分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class IntegralAccountServiceImpl implements IntegralAccountService {

	@Resource
	private IntegralAccountDao integralAccountDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(IntegralAccountModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(IntegralAccountModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(IntegralAccountModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(IntegralAccountModel model){

		return null;
	}

}