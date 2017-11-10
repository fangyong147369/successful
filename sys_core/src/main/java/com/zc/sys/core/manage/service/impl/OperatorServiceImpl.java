package com.zc.sys.core.manage.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.OperatorDao;
import com.zc.sys.core.manage.model.OperatorModel;
import com.zc.sys.core.manage.service.OperatorService;
/**
 * 管理员
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class OperatorServiceImpl implements OperatorService {

	@Resource
	private OperatorDao operatorDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(OperatorModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(OperatorModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(OperatorModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(OperatorModel model){

		return null;
	}

}