package com.zc.sys.core.integral.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.integral.dao.IntegralLogDao;
import com.zc.sys.core.integral.model.IntegralLogModel;
import com.zc.sys.core.integral.service.IntegralLogService;
/**
 * 积分日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class IntegralLogServiceImpl implements IntegralLogService {

	@Resource
	private IntegralLogDao integralLogDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(IntegralLogModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(IntegralLogModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(IntegralLogModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(IntegralLogModel model){

		return null;
	}

}