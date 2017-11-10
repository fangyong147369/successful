package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.account.dao.RechargeDao;
import com.zc.sys.core.account.model.RechargeModel;
import com.zc.sys.core.account.service.RechargeService;
/**
 * 充值
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class RechargeServiceImpl implements RechargeService {

	@Resource
	private RechargeDao rechargeDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(RechargeModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(RechargeModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(RechargeModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(RechargeModel model){

		return null;
	}

}