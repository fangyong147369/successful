package com.zc.sys.core.user.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.model.UserIdentifyModel;
import com.zc.sys.core.user.service.UserIdentifyService;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class UserIdentifyServiceImpl implements UserIdentifyService {

	@Resource
	private UserIdentifyDao userIdentifyDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(UserIdentifyModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(UserIdentifyModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(UserIdentifyModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserIdentifyModel model){

		return null;
	}

}