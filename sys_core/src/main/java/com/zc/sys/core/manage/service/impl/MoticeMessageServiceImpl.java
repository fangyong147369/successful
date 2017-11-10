package com.zc.sys.core.manage.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.MoticeMessageDao;
import com.zc.sys.core.manage.model.MoticeMessageModel;
import com.zc.sys.core.manage.service.MoticeMessageService;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class MoticeMessageServiceImpl implements MoticeMessageService {

	@Resource
	private MoticeMessageDao moticeMessageDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(MoticeMessageModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(MoticeMessageModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(MoticeMessageModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(MoticeMessageModel model){

		return null;
	}

}