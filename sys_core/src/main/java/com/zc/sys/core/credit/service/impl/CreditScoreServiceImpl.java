package com.zc.sys.core.credit.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.credit.dao.CreditScoreDao;
import com.zc.sys.core.credit.model.CreditScoreModel;
import com.zc.sys.core.credit.service.CreditScoreService;
/**
 * 信用分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class CreditScoreServiceImpl implements CreditScoreService {

	@Resource
	private CreditScoreDao creditScoreDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(CreditScoreModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(CreditScoreModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(CreditScoreModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(CreditScoreModel model){

		return null;
	}

}