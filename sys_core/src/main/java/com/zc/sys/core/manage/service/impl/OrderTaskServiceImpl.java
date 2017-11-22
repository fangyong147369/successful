package com.zc.sys.core.manage.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.manage.service.OrderTaskService;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class OrderTaskServiceImpl implements OrderTaskService {

	@Resource
	private OrderTaskDao orderTaskDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(OrderTaskModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(OrderTaskModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(OrderTaskModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(OrderTaskModel model){

		return null;
	}

}